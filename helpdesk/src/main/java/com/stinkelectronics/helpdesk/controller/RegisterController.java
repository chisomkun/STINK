package com.stinkelectronics.helpdesk.controller;

import com.stinkelectronics.helpdesk.model.Account;
import com.stinkelectronics.helpdesk.model.Profile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.stinkelectronics.helpdesk.service.AccountDao;
import com.stinkelectronics.helpdesk.service.ProfileDao;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import sun.jvm.hotspot.asm.Register;


@Controller
public class RegisterController {

	@Autowired
	private AccountDao accdao;

	@Autowired
	private ProfileDao profdao;

	//get register
	@GetMapping("/Register.html")
	public String accCheck(Model model) {
			model.addAttribute("account", new Account());
			model.addAttribute("profile", new Profile());

		return "/Register";
	}
		//post register
		@PostMapping()
		public String accRegister (@ModelAttribute Account account, @ModelAttribute Profile profile){
			if (account.getPassword() == null || account.getUserID() == null) {
				//broadcast that required fields are left empty
				return "/Register";
			}

			if (!accdao.isUserIdExists(account.getUserID())) {
				accdao.postAccount(account,profile);

			}

			return "/Register";
		}
	}

