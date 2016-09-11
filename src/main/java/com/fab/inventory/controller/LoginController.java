package com.fab.inventory.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController
{
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login(Model map,
		@RequestParam(value = "error", required = false) String error,
		@RequestParam(value = "logout", required = false) String logout)
	{
		if (error != null) {
			map.addAttribute("error", "Invalid username and password!");
		}
		if (logout != null) {
			map.addAttribute("msg", "You've been logged out successfully.");
		}
		return "login";
	}
}