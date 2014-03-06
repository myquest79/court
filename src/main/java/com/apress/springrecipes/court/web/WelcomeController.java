package com.apress.springrecipes.court.web;

import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.apress.springrecipes.court.dao.VehicleDao;
import com.apress.springrecipes.court.dao.impl.JdbcVehicleDao;
import com.apress.springrecipes.court.domain.Vehicle;

@Controller
public class WelcomeController 
{
	@RequestMapping(value={"/welcome"}, method=RequestMethod.GET)
	public String welcome(Model model)
	{
		Date today = new Date();
		model.addAttribute("today", today);
		
		// Database tests
		Vehicle vehicle = new Vehicle();
		vehicle.setVehicleNo("1234");
		vehicle.setColor("blue");
		vehicle.setWheel(30);
		vehicle.setSeat(4);
		
		VehicleDao vehicleDao = new JdbcVehicleDao();
		vehicleDao.insert(vehicle);
		
		
		
		return "welcome";
	}
	
	@RequestMapping(value={"/welcomeRedirect1"}, method=RequestMethod.GET)
	public void welcomeRedirect1()
	{
		System.out.println("#####Welcome Redirect 1#####");
	}
	
	@RequestMapping(value={"/welcomeRedirect2"}, method=RequestMethod.GET)
	public void welcomeRedirect2()
	{
		System.out.println("#####Welcome Redirect 2#####");
	}
}