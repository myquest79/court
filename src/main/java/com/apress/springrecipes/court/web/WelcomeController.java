package com.apress.springrecipes.court.web;

import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class WelcomeController 
{
	@RequestMapping(value={"/welcome"}, method=RequestMethod.GET)
	public String welcome(Model model)
	{
		Date today = new Date();
		model.addAttribute("today", today);
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