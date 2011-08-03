package org.pan.freelancer.controller;

import javax.annotation.Resource;

import org.pan.freelancer.service.ElanceProjectService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value="/elance")
public class ElanceController {
	
	@Resource private ElanceProjectService elanceService;
	
	

}
