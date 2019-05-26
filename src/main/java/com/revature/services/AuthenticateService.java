package com.revature.services;

import javax.servlet.http.HttpSession;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.ui.Model;

import com.revature.beans.User;
import com.revature.dao.UserDAO;
import com.revature.dao.util.ApplicationContextSingleton;

public class AuthenticateService 
{

	private static ApplicationContext ac = ApplicationContextSingleton.getInstance();
	
	public static boolean validateUser(String username, String password, HttpSession sesh, Model m)
	{
		UserDAO dao = (UserDAO) ac.getBean("userDao");
		
		
		User user = new User();
		user.setUsername(username);
		user.setPassword(password);
		
		User credMatch = dao.getUser(username);
		
		if(	!(null == credMatch) && 
			!(null == user) &&
			(user.getUsername().equals(credMatch.getUsername()) && 
			(user.getPassword().equals(credMatch.getPassword()))))
		{		
			if(credMatch.getUserRole().equals("user"))
			{
				sesh.setAttribute("userLoggedIn", true);

				sesh.setAttribute("userName", credMatch.getUsername());
				sesh.setAttribute("firstName", credMatch.getFirstName());
				sesh.setAttribute("lastName", credMatch.getLastName());
				sesh.setAttribute("email", credMatch.getEmail());
				return true;
			}
			
			else if(credMatch.getUserRole().equals("admin"))
			{
				sesh.setAttribute("adminLoggedIn", true);

				sesh.setAttribute("userName", credMatch.getUsername());
				sesh.setAttribute("firstName", credMatch.getFirstName());
				sesh.setAttribute("lastName", credMatch.getLastName());
				sesh.setAttribute("email", credMatch.getEmail());
				return true;
			}
			
			else
			{
				return false;
			}
			

		}
		else
		{
			return false;
		}
		
	}
}
