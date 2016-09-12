package com.fab.inventory.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.fab.inventory.dao.HotelDao;
import com.fab.inventory.domain.Hotel;

@Controller
public class DashboardController {

	Logger logger = Logger.getLogger(DashboardController.class);

	@Autowired
	HotelDao hotelDao;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String homePage(HttpServletRequest req, HttpServletResponse res, Model model) {
		
		@SuppressWarnings("unchecked")
		List<Hotel> allHotels = (List<Hotel>) hotelDao.getEntityManager().createQuery("Select h from Hotel h").getResultList();
		model.addAttribute("allHotels", allHotels);
		return "index";
	}

}
