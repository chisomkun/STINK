package com.stinkelectronics.helpdesk.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.stinkelectronics.helpdesk.model.Account;
import com.stinkelectronics.helpdesk.model.Profile;
import com.stinkelectronics.helpdesk.service.AccountDao;
import com.stinkelectronics.helpdesk.service.ProfileDao;


@Controller
public class RegisterController {

	@Autowired
	private AccountDao accdao;

	@Autowired
	private ProfileDao profdao;
	
	private ArrayList<Object> user;

	//get register
	@GetMapping("register")
	public String accCheck(Model model) {
		
		user.add(new Account());
		user.add(new Profile());
		model.addAttribute("user", user);

		return "Register";
	}
	//post register
	@PostMapping()
	public String accRegister (@ModelAttribute ArrayList<Object> user){
		Account account = (Account) user.get(0);
		Profile profile = (Profile) user.get(1);
		
		profile.setUserID(account.getUserID());
		
		if (account.getPassword() == null || account.getUserID() == null) {
			//broadcast that required fields are left empty
			return "Register";
		}

		if (!accdao.isUserIdExists(account.getUserID())) {
			accdao.postAccount(account,profile);
			return "Login";
		}

		return "Register";
	}
	
	@RequestMapping(value="/registeraccount")
	public String registerAccount(@ModelAttribute ArrayList<Object> user) {
		Account account = (Account) user.get(0);
		Profile profile = (Profile) user.get(1);
		
		profile.setUserID(account.getUserID());
		
		//nullcheck
		if (account.getPassword() == null || account.getUserID() == null) {
			//broadcast that required fields are left empty
			return "Register";
		}
		
		//lengthcheck

		if (!accdao.isUserIdExists(account.getUserID())) {
			accdao.postAccount(account,profile);
			return "Login";
		}
		return "Register";
	}
}

