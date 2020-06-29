package com.stinkelectronics.helpdesk.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.stinkelectronics.helpdesk.model.Profile;
import com.stinkelectronics.helpdesk.repository.ProfileCRUDRepository;

@Controller
public class IndexController {

	private final ProfileCRUDRepository profileCRUDRepository;
	
	public IndexController(ProfileCRUDRepository profileCRUDRepository) {
		this.profileCRUDRepository = profileCRUDRepository;
	}
	
	@RequestMapping("/")
	public String demo(Model profile) {
		Profile user = new Profile();
		profile.addAttribute("user", user);
		
		return "index";
	}
	
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String saveUser(@ModelAttribute("user") Profile rawProfile) {
		Profile profile = new Profile(rawProfile.getFirstName(), rawProfile.getPassword(), rawProfile.getEmail());
		profileCRUDRepository.save(profile);
		return "landing";
	}
	
}
