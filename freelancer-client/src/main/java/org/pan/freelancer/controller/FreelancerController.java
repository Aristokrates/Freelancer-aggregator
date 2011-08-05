package org.pan.freelancer.controller;

import java.util.Enumeration;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.pan.freelancer.service.FreelancerProjectService;
import org.pan.freelancer4j.model.FreelancerProjectState;
import org.pan.freelancer4j.model.project.FreelancerProject;
import org.pan.freelancer4j.model.project.bids.FreelancerProjectBid;
import org.pan.freelancer4j.model.user.FreelancerUser;
import org.pan.freelancer4j.model.user.details.FreelancerUserDetails;
import org.pan.freelancer4j.search.ProjectSearchCriteria;
import org.pan.freelancer4j.search.UserSearchCriteria;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(value="/freelancer")
public class FreelancerController {
	
	@Resource private FreelancerProjectService freelancerService;
	
	@RequestMapping(value="/job_home.do", method = RequestMethod.GET)
	public String showFreelancerJobPage(HttpServletRequest request, HttpSession session, ModelMap modelMap) {
		
		int page = getPage(request);
		
		ProjectSearchCriteria searchCriteria = new ProjectSearchCriteria();
		searchCriteria.setPage(page);
		searchCriteria.setProjectState(FreelancerProjectState.ACTIVE);
		
		List<FreelancerProject> projects = freelancerService.getProjectsByCriteria(searchCriteria);
		
		modelMap.addAttribute("jobList", projects);
		modelMap.addAttribute("size", 1000);
		
		return "freelancerJob";
	}
	
	@RequestMapping(value="/bid_home.do", method = RequestMethod.GET)
	public String showFreelancerBidPage(@RequestParam("projectId") Integer projectId, HttpServletRequest request, HttpSession session, ModelMap modelMap) {
		
		List<FreelancerProjectBid> bids = freelancerService.getProjectBidDetails(projectId);
		
		modelMap.addAttribute("bidList", bids);
		modelMap.addAttribute("size", bids.size());
		
		return "freelancerBid";
	}
	
	@RequestMapping(value="/provider_home.do", method = RequestMethod.GET)
	public String showFreelancerProviderPage(HttpServletRequest request, HttpSession session, ModelMap modelMap) {
		
		int page = getPage(request);
		
		UserSearchCriteria searchCriteria = new UserSearchCriteria();
		searchCriteria.setPage(page);
		
		List<FreelancerUser> users = freelancerService.getUsersByCriteria(searchCriteria);
		 
		modelMap.addAttribute("size", 10000);
		modelMap.addAttribute("providerList", users);
		
		return "freelancerProvider";
	}
	
	@RequestMapping(value="/provider_details.do", method=RequestMethod.GET)
	public @ResponseBody FreelancerUserDetails getProviderDetails(@RequestParam("id") Integer providerId) {
			
		return freelancerService.getUserDetails(providerId, null);
		
	}
	
	public int getPage(HttpServletRequest request){
		int page = 0;
		Enumeration<?> paramNames = request.getParameterNames();
		while (paramNames.hasMoreElements()) {
			String name = (String)paramNames.nextElement();
			if (name != null && name.startsWith("d-") && name.endsWith("-p")) {
				String pageValue = request.getParameter(name);
				if (pageValue != null) {
					page = Integer.parseInt(pageValue) - 1;
				}
			}
		}
		return page;
	}

}
