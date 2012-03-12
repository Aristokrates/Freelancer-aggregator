package org.pan.freelancer.controller;

import java.util.Enumeration;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.pan.freelancer.service.oDeskProjectService;
import org.pan.odesk.model.job.oDeskJobWrapper;
import org.pan.odesk.model.provider.oDeskProviderModel;
import org.pan.odesk.model.provider.oDeskProviderModelWrapper;
import org.pan.odesk.search.oDeskJobSearchCriteria;
import org.pan.odesk.search.oDeskProviderSearchCriteria;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(value="/oDesk")
public class oDeskController {
	
	@Resource private oDeskProjectService oDeskService;
	
	@RequestMapping(value="/job_home.do", method = RequestMethod.GET)
	public String showoDeskJobPage(HttpServletRequest request, HttpSession session, ModelMap modelMap) {
		
		int page = getPage(request);
		
		oDeskJobSearchCriteria jobSearchCriteria = new oDeskJobSearchCriteria();
		
		jobSearchCriteria.setPage(page);
		jobSearchCriteria.setStatusForSearching("Open");
		jobSearchCriteria.setSort("date_posted");
		
		oDeskJobWrapper modelWrapper = oDeskService.getJobsByCriteria(jobSearchCriteria);
		
		modelMap.addAttribute("jobList", modelWrapper.getJobs());
		
		String stringSize = modelWrapper.getLister().getTotalItems();
		int size = 0;
		if (stringSize != null & !stringSize.isEmpty()) {
			size = Integer.valueOf(stringSize);
			if (size > 5000) {
				size = 5000;
			}
		}
		
		modelMap.addAttribute("size", size);
		
		return "odeskJob";
	}
	
	@RequestMapping(value="/provider_home.do", method = RequestMethod.GET)
	public String showoDeskProviderPage(HttpServletRequest request, HttpSession session, ModelMap modelMap) {
		
		int page = getPage(request);
		
		oDeskProviderSearchCriteria providerSearchCriteria = new oDeskProviderSearchCriteria();
		
		providerSearchCriteria.setPage(page);
		
		oDeskProviderModelWrapper modelWrapper = oDeskService.getProvidersByCriteria(providerSearchCriteria);
		modelMap.addAttribute("providerList", modelWrapper.getProviders());
		
		String stringSize = modelWrapper.getLister().getTotalItems();
		int size = 0;
		if (stringSize != null & !stringSize.isEmpty()) {
			size = Integer.valueOf(stringSize);
			if (size > 5000) {
				size = 5000;
			}
		}
		
		modelMap.addAttribute("size", size);
		
		return "odeskProvider";
	}
	
	@RequestMapping(value="/details.do", method=RequestMethod.GET)
	public @ResponseBody oDeskProviderModel getProviderDetails(@RequestParam("id") String providerId) {
			
		return oDeskService.getProviderById(providerId);
		
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
