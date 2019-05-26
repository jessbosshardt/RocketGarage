package com.revature.services;

import javax.servlet.http.HttpSession;


public class InvalidateService 
{
	public static void invalidateSession(HttpSession sesh)
	{
		if(!(null == sesh.getAttribute("userLoggedIn")))
		{
			sesh.setAttribute("userLoggedIn", false);
		}
		
		if(!(null == sesh.getAttribute("adminLoggedIn")))
		{
			sesh.setAttribute("adminLoggedIn", false);
		}
		
		if(!(null == sesh.getAttribute("user")))
		{
			sesh.setAttribute("user", null);
		}
	}
}
