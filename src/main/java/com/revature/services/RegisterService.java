package com.revature.services;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.ui.Model;

import com.revature.beans.User;
import com.revature.dao.UserDAO;
import com.revature.dao.util.ApplicationContextSingleton;

public class RegisterService 
{
	
	private static ApplicationContext ac = ApplicationContextSingleton.getInstance();

	
	public static boolean registerUser(String username, String password, String email)
	{
		UserDAO dao = (UserDAO) ac.getBean("userDao");
		User user = new User();
		user.setUsername(username);
		user.setPassword(password);
		user.setEmail(email);
		user.setFirstName("");
		user.setLastName("");
		user.setUserRole("user");
		
		if(dao.createUser(user))
		{
			return true;
		}
		else
		{
			return false;
		}
		
	}
}
