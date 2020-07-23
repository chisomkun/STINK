package com.stinkelectronics.helpdesk.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.stinkelectronics.helpdesk.model.Account;
import com.stinkelectronics.helpdesk.model.Profile;
import com.stinkelectronics.helpdesk.service.AccountDao;
import com.stinkelectronics.helpdesk.service.ProfileDao;

@Controller
@SessionAttributes("sessionProfile")
public class LoginController {
	
	@Autowired
	private AccountDao accdao;
	
	@Autowired
	private ProfileDao profdao;
	
	@ModelAttribute("sessionProfile")
	public Profile makeSessionProfile() {return new Profile();}
	
	//get login
	@GetMapping("/")
	public String loginForm(Model m, @ModelAttribute("sessionProfile") Profile sessionProfile) {
		m.addAttribute("account", new Account());
		return "Login";
	}
	
	//post login
	@PostMapping("/Login")
	public String loginPost(@ModelAttribute Account account, @ModelAttribute("sessionProfile") Profile sessionProfile) {
		//null check
		if(account.getPassword() == null || account.getUserID() == null) {
			//broadcast that required fields are left empty
			return "Login";
		}
		
		//length check
		//password max 12 char
		//userid max 35 char
		if(account.getPassword().length() > 12 || account.getUserID().length() > 35) {
			//broadcast that respective field is too long
			return "Login";
		}
		
		if(accdao.isUserIdExists(account.getUserID())) {
			//check if password matches account
			if(account.getPassword().contentEquals(accdao.getAccountByUserID(account.getUserID()).getPassword())) {
				//login session user
				sessionProfile = profdao.getProfileByUserID(account.getUserID());
				//authenticate
				return "welcome";
			}
			else {
				//broadcast that password does not match userid
				return "Login";
			}
		}
		else {
			//broadcast that no such user with userID exists
			return "Login";
		}
	}
	
	@RequestMapping("/Register")
	public String register() {
		return "Register";
	}
}
