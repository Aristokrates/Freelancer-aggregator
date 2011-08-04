package org.pan.freelancer.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value="/home.do")
public class HomeController {
	
	@RequestMapping(method=RequestMethod.GET)
	public String showHomePage(HttpServletRequest request, HttpSession session, ModelMap modelMap) {
		
		return "home";
		
	}

}
