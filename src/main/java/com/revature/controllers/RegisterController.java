package com.revature.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.revature.services.AuthenticateService;
import com.revature.services.RegisterService;

@RequestMapping(value="")
@Controller
public class RegisterController 
{
	@RequestMapping(value="newUser", method=RequestMethod.GET)
	public String registerGET(Model m,  HttpServletRequest request)
	{
		HttpSession sesh = request.getSession();

		
		if(!(null == sesh.getAttribute("userLoggedIn")) && (sesh.getAttribute("userLoggedIn").equals(true)))
		{
			return "garage";
		}
			
		else if(!(null == sesh.getAttribute("adminLoggedIn")) && (sesh.getAttribute("adminLoggedIn").equals(true)))
		{
			return "admin";
		}
		
		return "login";
	}
	
	@RequestMapping(value="newUser", method=RequestMethod.POST)
	public String register(@RequestParam String regUsername, @RequestParam String regPassword, 
							@RequestParam String regEmail, HttpServletRequest request, Model m)
	{
		HttpSession sesh = request.getSession();
		
		if(RegisterService.registerUser(regUsername, regPassword, regEmail))
		{
			if(AuthenticateService.validateUser(regUsername, regPassword, sesh, m))
			{
				return "garage";	
			}
		}
			return "login";	
	}
}
