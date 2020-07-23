package com.stinkelectronics.helpdesk.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.stinkelectronics.helpdesk.model.Account;
import com.stinkelectronics.helpdesk.service.AccountDao;

@Controller
public class LoginController {
	
	@Autowired
	private AccountDao accdao;
	
	//get login
	@GetMapping("/")
	public String loginForm(Model m) {
		m.addAttribute("account", new Account());
		return "/";
	}
	
	//post login
	@PostMapping("/")
	public String loginPost(@ModelAttribute Account account) {
		//null check
		if(account.getPassword() == null || account.getUserID() == null) {
			//broadcast that required fields are left empty
			return "/";
		}
		
		//length check
		//password max 12 char
		//userid max 35 char
		if(account.getPassword().length() > 12 || account.getUserID().length() > 35) {
			//broadcast that respective field is too long
			return "/";
		}
		
		if(accdao.isUserIdExists(account.getUserID())) {
			//check if password matches account
			if(account.getPassword().contentEquals(accdao.getAccountByUserID(account.getUserID()).getPassword())) {
				//login session user
				return "/";
			}
			else {
				//broadcast that password does nto match userid
				return "/";
			}
		}
		else {
			//broadcast that no such user with userID exists
			return "/";
		}
	}
}
