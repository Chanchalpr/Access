package com.access.erp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class loginContoller {
	
	@GetMapping("/")
	public String loginPage(Model model) {
		return "login";
	}

}
