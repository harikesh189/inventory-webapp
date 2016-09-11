package com.fab.inventory.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class DashboardController {

	Logger logger = Logger.getLogger(DashboardController.class);

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String homePage(HttpServletRequest req, HttpServletResponse res, Model model) {

		return "index";
	}

	@RequestMapping(value = "/header", method = RequestMethod.GET)
	public String header(Model model) {
		return "header";
	}

}