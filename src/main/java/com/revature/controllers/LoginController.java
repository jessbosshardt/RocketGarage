package com.revature.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.revature.services.AuthenticateService;
import com.revature.services.InvalidateService;
import com.revature.services.UserDataService;

@RequestMapping(value="")
@Controller
public class LoginController 
{
	
	@RequestMapping(value="", method=RequestMethod.GET)
	public String FrontGET(Model m,  HttpServletRequest request)
	{
		HttpSession sesh = request.getSession();
		
		if(!(null == sesh.getAttribute("userLoggedIn")))
		{
			if((sesh.getAttribute("userLoggedIn").equals(true)))
			{
				if(UserDataService.getUserData(m, sesh))
				{
					return "garage";
				}
			} 	
		}
				
		else if(!(null == sesh.getAttribute("adminLoggedIn")))
		{
			if((sesh.getAttribute("adminLoggedIn").equals(true)))
			{
				if(UserDataService.getUserData(m, sesh))
				{
					return "admin";
				}
			}
		}
		return "login";
	}
	
	
	@RequestMapping(value="login", method=RequestMethod.GET)
	public String loginGET(Model m,  HttpServletRequest request)
	{
		HttpSession sesh = request.getSession();
		
		if(!(null == sesh.getAttribute("userLoggedIn")))
		{
			if((sesh.getAttribute("userLoggedIn").equals(true)))
			{
				if(UserDataService.getUserData(m, sesh))
				{
					return "garage";
				}
			} 	
		}
				
		else if(!(null == sesh.getAttribute("adminLoggedIn")))
		{
			if((sesh.getAttribute("adminLoggedIn").equals(true)))
			{
				if(UserDataService.getUserData(m, sesh))
				{
					return "admin";
				}
			}
		}
		return "login";
	}
	
	@RequestMapping(value="home",method=RequestMethod.POST)
	public String userLogin(@RequestParam(value="username") String username, 
			@RequestParam(value="password") String password, Model m, HttpServletRequest request)
	{
		HttpSession sesh = request.getSession();
		if(AuthenticateService.validateUser(username, password, sesh, m))
		{
			if(!(null == sesh.getAttribute("userLoggedIn")) && sesh.getAttribute("userLoggedIn").equals(true) && UserDataService.getUserData(m, sesh))
			{
				return "garage";
			}
			
			else if(!(null == sesh.getAttribute("adminLoggedIn")) && sesh.getAttribute("adminLoggedIn").equals(true) && UserDataService.getUserData(m, sesh))
			{
				return "admin";
			}
		}
		
		return "login";
	}
	
	@RequestMapping(value="home",method=RequestMethod.GET)
	public String userGET(Model m, HttpServletRequest request)
	{
		HttpSession sesh = request.getSession();
		
		if(!(null == sesh.getAttribute("userLoggedIn")))
		{
			if((sesh.getAttribute("userLoggedIn").equals(true)))
			{
				if(UserDataService.getUserData(m, sesh))
				{
					return "garage";
				}
			} 	
		}
				
		else if(!(null == sesh.getAttribute("adminLoggedIn")))
		{
			if((sesh.getAttribute("adminLoggedIn").equals(true)))
			{
				if(UserDataService.getUserData(m, sesh))
				{
					return "admin";
				}
			}
		}
		return "login";
	}	
	
	@RequestMapping(value="logout",method=RequestMethod.POST)
	public String userLogout(Model m, HttpServletRequest request)
	{
		HttpSession sesh= request.getSession();
		InvalidateService.invalidateSession(sesh);

		return "login";
	}
	
	@RequestMapping(value="logout",method=RequestMethod.GET)
	public String userLogoutGET(Model m, HttpServletRequest request)
	{
		HttpSession sesh = request.getSession();
		
		if(!(null == sesh.getAttribute("userLoggedIn")))
		{
			if((sesh.getAttribute("userLoggedIn").equals(true)))
			{
				if(UserDataService.getUserData(m, sesh))
				{
					return "garage";
				}
			} 	
		}
				
		else if(!(null == sesh.getAttribute("adminLoggedIn")))
		{
			if((sesh.getAttribute("adminLoggedIn").equals(true)))
			{
				if(UserDataService.getUserData(m, sesh))
				{
					return "admin";
				}
			}
		}
		return "login";
	}
	
	
	@RequestMapping(value="admin",method=RequestMethod.GET)
	public String adminGet(Model m, HttpServletRequest request)
	{
		HttpSession sesh = request.getSession();
		
		if(!(null == sesh.getAttribute("userLoggedIn")))
		{
			if((sesh.getAttribute("userLoggedIn").equals(true)))
			{
				if(UserDataService.getUserData(m, sesh))
				{
					return "garage";
				}
			} 	
		}
				
		else if(!(null == sesh.getAttribute("adminLoggedIn")))
		{
			if((sesh.getAttribute("adminLoggedIn").equals(true)))
			{
				if(UserDataService.getUserData(m, sesh))
				{
					return "admin";
				}
			}
		}
		return "login";
	}
	
	
	
	
	@RequestMapping(value="userPromote", method=RequestMethod.GET)
	public String promoteUserGET(Model m, @RequestParam(value="userPromoteId") int userId, HttpServletRequest request)
	{
		HttpSession sesh = request.getSession();
		
		if(!(null == sesh.getAttribute("userLoggedIn")))
		{
			if((sesh.getAttribute("userLoggedIn").equals(true)))
			{
				if(UserDataService.getUserData(m, sesh))
				{
					return "garage";
				}
			} 	
		}
				
		else if(!(null == sesh.getAttribute("adminLoggedIn")))
		{
			if((sesh.getAttribute("adminLoggedIn").equals(true)))
			{
				if(UserDataService.getUserData(m, sesh))
				{
					return "admin";
				}
			}
		}
		return "login";
	}
	
	
	@RequestMapping(value="deleteUser", method=RequestMethod.GET)
	public String deleteUserGET(Model m, @RequestParam(value="userDeleteId") int userId, HttpServletRequest request)
	{
		HttpSession sesh = request.getSession();
		
		if(!(null == sesh.getAttribute("userLoggedIn")))
		{
			if((sesh.getAttribute("userLoggedIn").equals(true)))
			{
				if(UserDataService.getUserData(m, sesh))
				{
					return "garage";
				}
			} 	
		}
				
		else if(!(null == sesh.getAttribute("adminLoggedIn")))
		{
			if((sesh.getAttribute("adminLoggedIn").equals(true)))
			{
				if(UserDataService.getUserData(m, sesh))
				{
					return "admin";
				}
			}
		}
		return "login";
	}
}

