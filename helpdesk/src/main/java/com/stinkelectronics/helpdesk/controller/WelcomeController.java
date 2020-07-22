package com.stinkelectronics.helpdesk.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.stinkelectronics.helpdesk.service.ProfileDao;
import com.stinkelectronics.helpdesk.service.RepairDao;
import com.stinkelectronics.helpdesk.service.RoleDao;

@Controller
public class WelcomeController {
	
	@Autowired
	private ProfileDao profdao;
	
	@Autowired
	private RepairDao repairdao;
	
	@Autowired
	private RoleDao roledao;
	
	//get welcome
	
	//post welcome
}
