package org.pan.freelancer.controller;

import java.util.Enumeration;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.pan.elance.model.job.ElanceJobModelWrapper;
import org.pan.elance.model.provider.ElanceProviderModelWrapper;
import org.pan.elance.model.provider.details.ElanceProviderDetailsModel;
import org.pan.elance.search.ElanceJobSearchCriteria;
import org.pan.elance.search.ElanceProviderSearchCriteria;
import org.pan.freelancer.service.ElanceProjectService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(value="/elance")
public class ElanceController {
	
	@Resource private ElanceProjectService elanceService;
	
	@RequestMapping(value="/job_home.do", method = RequestMethod.GET)
	public String showElanceJobPage(HttpServletRequest request, HttpSession session, ModelMap modelMap) {
		
		int page = getPage(request);
		
		ElanceJobSearchCriteria jobSearchCriteria = new ElanceJobSearchCriteria();
		
		jobSearchCriteria.setPage(page);
		jobSearchCriteria.setSortColumn("startDate");
		jobSearchCriteria.setSortOrder("desc");
		
		ElanceJobModelWrapper modelWrapper = elanceService.getProjectsByCriteria(jobSearchCriteria);
		
		modelMap.addAttribute("jobList", modelWrapper.getJobs());
		
		modelMap.addAttribute("size", Integer.valueOf(modelWrapper.getTotalResults()));
		
		return "elanceJob";
	}
	
	@RequestMapping(value="/provider_home.do", method = RequestMethod.GET)
	public String showElanceProviderPage(HttpServletRequest request, HttpSession session, ModelMap modelMap) {
		
		int page = getPage(request);
		
		ElanceProviderSearchCriteria providerSearchCriteria = new ElanceProviderSearchCriteria();
		
		providerSearchCriteria.setPage(page);
		
		ElanceProviderModelWrapper modelWrapper = elanceService.getProvidersByCriteria(providerSearchCriteria);
		
		modelMap.addAttribute("size", Integer.valueOf(modelWrapper.getTotalResults()));
		modelMap.addAttribute("providerList", modelWrapper.getProviders());
		
		return "elanceProvider";
	}
	
	@RequestMapping(value="/provider_details.do", method=RequestMethod.GET)
	public @ResponseBody ElanceProviderDetailsModel getProviderDetails(@RequestParam("id") Integer providerId) {
			
		return elanceService.getProviderDetailsById(providerId);
		
	}
	

	public int getPage(HttpServletRequest request){
		int page=1;
		Enumeration<?> paramNames = request.getParameterNames();
		while (paramNames.hasMoreElements()) {
			String name = (String)paramNames.nextElement();
			if (name != null && name.startsWith("d-") && name.endsWith("-p")) {
				String pageValue = request.getParameter(name);
				if (pageValue != null) {
					page = Integer.parseInt(pageValue);
				}
			}
		}
		return page;
	}
}
