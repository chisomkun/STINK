package com.stinkelectronics.helpdesk.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.stinkelectronics.helpdesk.model.Profile;
import com.stinkelectronics.helpdesk.model.Account;
import com.stinkelectronics.helpdesk.repository.AccountCRUDRepository;

@Controller
public class IndexController {

	private final AccountCRUDRepository profileCRUDRepository;
	
	public IndexController(AccountCRUDRepository profileCRUDRepository) {
		this.profileCRUDRepository = profileCRUDRepository;
	}
	
	@RequestMapping("/")
	public String demo(Model account) {
		Account user = new Account();
		account.addAttribute("user", user);
		
		return "index";
	}
	
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String saveUser(@ModelAttribute("user") Account rawAccount) {
		Account account = new Account(rawAccount.getFirstName(), rawAccount.getPassword(), rawAccount.getEmail());
		profileCRUDRepository.save(account);
		return "landing";
	}
	
}
