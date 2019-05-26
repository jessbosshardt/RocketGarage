package com.revature.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.revature.services.UserService;

@RequestMapping(value="")
@Controller
public class UserController 
{
	@RequestMapping(value="deleteUser", method=RequestMethod.POST)
	public String deleteUser(Model m, @RequestParam(value="userDeleteId") int userId, HttpServletRequest request)
	{
		HttpSession sesh = request.getSession();
		UserService.delete(userId);
		return "admin";
	}
	

	@RequestMapping(value="userPromote", method=RequestMethod.POST)
	public String promoteUser(Model m, @RequestParam(value="userPromoteId") int userId, HttpServletRequest request)
	{
		HttpSession sesh = request.getSession();
		UserService.promote(userId);
		return "admin";
	}
	
	@RequestMapping(value="profile", method=RequestMethod.POST)
	public String userProfile(Model m, HttpServletRequest request)
	{
		HttpSession sesh = request.getSession();
		return "user";
	}
	
	@RequestMapping(value="profile", method=RequestMethod.GET)
	public String userProfileGET(Model m, HttpServletRequest request)
	{
		HttpSession sesh = request.getSession();
		return "user";
	}
	
	@RequestMapping(value="passwordChange", method=RequestMethod.POST)
	public String passwordChange(@RequestParam(value="newPassword") String password, Model m, HttpServletRequest request)
	{
		HttpSession sesh = request.getSession();
		UserService.changePassword(password, sesh);
		return "user";
	}
	
	@RequestMapping(value="passwordChange", method=RequestMethod.GET)
	public String passwordChangeGET(Model m, HttpServletRequest request)
	{
		HttpSession sesh = request.getSession();
		return "user";
	}
	
	@RequestMapping(value="infoChange", method=RequestMethod.POST)
	public String infoChange(@RequestParam(value="firstName") String newFirst,
							@RequestParam(value="lastName") String newLast,
							@RequestParam(value="email") String newEmail,
							Model m, HttpServletRequest request)
	{
		HttpSession sesh = request.getSession();
		UserService.changeInfo(newFirst, newLast, newEmail, sesh);
		return "user";
	}
	
	@RequestMapping(value="infoChange", method=RequestMethod.GET)
	public String infoChangeGET(Model m, HttpServletRequest request)
	{
		HttpSession sesh = request.getSession();
		return "user";
	}
}


