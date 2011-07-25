package org.pan.freelancer4j.scheduler.job;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.pan.freelancer4j.client.FreelancerClientWrapper;
import org.pan.freelancer4j.model.project.bids.FreelancerCacheProjectBid;
import org.pan.freelancer4j.model.project.bids.FreelancerProjectBid;
import org.pan.freelancer4j.model.project.bids.FreelancerProjectBidEntity;
import org.pan.freelancer4j.scheduler.FreelancerObserver;
import org.quartz.JobDataMap;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.quartz.StatefulJob;

/**
 * Freelance project bid trigger job
 * <p>
 * Freelancer project bid trigger is triggered from freelancer scheduler. 
 * It performs pulling of pproject bids for particular projects and check if the bids exist in cache.
 * If they don't exist in cache, it notifies the observer for new project bids
 * 
 * @author Pance.Isajeski
 *
 */
public class FreelancerProjectBidJob implements StatefulJob {

	@SuppressWarnings("unchecked")
	@Override
	public void execute(JobExecutionContext context) throws JobExecutionException {

		System.out.println("Freelancer BID pulling initiated: " + new Date());		
		JobDataMap dataMap = context.getJobDetail().getJobDataMap();
		List<Integer> projectIdList = (List<Integer>) dataMap.get("projectIdList");
		FreelancerObserver freelanceObserver =  (FreelancerObserver) dataMap.get("observer");
		FreelancerClientWrapper client = (FreelancerClientWrapper) dataMap.get("client");
		Map<Integer, Map<Integer, FreelancerCacheProjectBid>> bidCache = 
			(Map<Integer, Map<Integer, FreelancerCacheProjectBid>>) dataMap.get("bidCache");
		
		if (projectIdList.isEmpty()){
			System.out.println("No project list set: " + new Date());
			return;
		}
		
		List<FreelancerProjectBidEntity> projectBidEntityList = new ArrayList<FreelancerProjectBidEntity>();
		
		for (Integer projectId : projectIdList) {

			List<FreelancerProjectBid> projectBids = client.getProjectBidDetails(projectId).getFreelancerProjectBids();
			for (FreelancerProjectBid projectBid : projectBids) {
				FreelancerCacheProjectBid bidModel = new FreelancerCacheProjectBid(projectBid.getProviderUserId(), 
						projectBid.getBidAmmount(), projectBid.getPeriod());

				Map<Integer, FreelancerCacheProjectBid> cachedBidMap = bidCache.get(projectBid.getProviderUserId());
				if (cachedBidMap == null) {
					cachedBidMap = new HashMap<Integer, FreelancerCacheProjectBid>();
					cachedBidMap.put(projectId, bidModel);
					bidCache.put(projectBid.getProviderUserId(), cachedBidMap);
					projectBidEntityList.add(new FreelancerProjectBidEntity(projectId, projectBid));
				} else {
					FreelancerCacheProjectBid cachedBid = cachedBidMap.get(projectId);

					if (cachedBid != null) {
						if (!cachedBid.equals(bidModel)) {
							cachedBidMap.put(projectId, bidModel);
							bidCache.put(projectBid.getProviderUserId(), cachedBidMap);
							//notify if needed
							System.out.println("Project: " + projectId + " " + "Notifying bid update: " + bidModel);
						}
					} else {
						cachedBidMap.put(projectId, bidModel);
						bidCache.put(projectBid.getProviderUserId(), cachedBidMap);
						projectBidEntityList.add(new FreelancerProjectBidEntity(projectId, projectBid));
					}
				}
			}
		}

		if (!projectBidEntityList.isEmpty()){
			freelanceObserver.notifyOnNewBids(projectBidEntityList);
		}
		projectBidEntityList = null;		
	}
}
