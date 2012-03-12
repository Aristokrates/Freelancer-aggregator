package org.pan.freelancer.controller;

import java.util.Enumeration;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.pan.freelancer.service.LinkedInProjectService;
import org.pan.linkedin.model.job.LinkedInJobModelWrapper;
import org.pan.linkedin.model.person.LinkedInPersonModelWrapper;
import org.pan.linkedin.model.person.details.LinkedInPersonDetailsModel;
import org.pan.linkedin.search.LinkedInJobSearchCriteria;
import org.pan.linkedin.search.LinkedInPeopleSearchCriteria;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(value="/linkedin")
public class LinkedinController {
	
	@Resource private LinkedInProjectService linkedinService;
	
	@RequestMapping(value="/job_home.do", method = RequestMethod.GET)
	public String showLinkedinJobPage(HttpServletRequest request, HttpSession session, ModelMap modelMap) {
		
		int page = getPage(request);
		
		LinkedInJobSearchCriteria jobSearchCriteria = new LinkedInJobSearchCriteria();
		
		jobSearchCriteria.setStart(page * jobSearchCriteria.getCount());
		
		LinkedInJobModelWrapper modelWrapper = linkedinService.getJobsByCriteria(jobSearchCriteria);
		
		modelMap.addAttribute("jobList", modelWrapper.getLinkedinJobs());
		
		modelMap.addAttribute("size", Integer.valueOf(modelWrapper.getTotalResults()));
		
		return "linkedinJob";
	}
	
	@RequestMapping(value="/provider_home.do", method = RequestMethod.GET)
	public String showLinkedinProviderPage(HttpServletRequest request, HttpSession session, ModelMap modelMap) {
		
		int page = getPage(request);
		
		LinkedInPeopleSearchCriteria providerSearchCrit = new LinkedInPeopleSearchCriteria();
		providerSearchCrit.addCountryCode("cn:0");
		providerSearchCrit.addCountryCode("fr:0");
		providerSearchCrit.setStart(page * providerSearchCrit.getCount());

		LinkedInPersonModelWrapper modelWrapper = linkedinService.getProvidersByCriteria(providerSearchCrit);
		
		modelMap.addAttribute("size", Integer.valueOf(modelWrapper.getTotalResults()));
		modelMap.addAttribute("providerList", modelWrapper.getPeople());
		
		return "linkedinProvider";
	}
	
	@RequestMapping(value="/provider_details.do", method=RequestMethod.GET)
	public @ResponseBody LinkedInPersonDetailsModel getProviderDetails(@RequestParam("id") String providerId) {
			
		return linkedinService.getProviderDetailsById(providerId);
		
	}

	public int getPage(HttpServletRequest request){
		int page=0;
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
