package com.stinkelectronics.helpdesk.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import service.AccountDao;
import service.ProfileDao;

@Controller
public class RegisterController {
	
	@Autowired
	private AccountDao accdao;
	
	@Autowired
	private ProfileDao profdao;
	
	//get register
	
	//post register
}
