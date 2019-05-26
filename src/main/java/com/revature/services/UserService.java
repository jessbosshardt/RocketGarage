package com.revature.services;

import javax.servlet.http.HttpSession;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.revature.beans.User;
import com.revature.dao.UserDAO;
import com.revature.dao.util.ApplicationContextSingleton;

public class UserService 
{

	private static ApplicationContext ac = ApplicationContextSingleton.getInstance();
	
	public static void delete(int userId)
	{
		UserDAO dao = (UserDAO)ac.getBean("userDao");
		
		dao.deleteUser(userId);
		
		
	}
	
	public static void promote(int userId)
	{
		UserDAO dao = (UserDAO)ac.getBean("userDao");
		
		User newAdmin = dao.getUser(userId);
		newAdmin.setUserRole("admin");
		dao.updateUser(newAdmin);
	}
	
	public static void changePassword(String password, HttpSession sesh)
	{
		UserDAO dao = (UserDAO)ac.getBean("userDao");
		String username = sesh.getAttribute("userName").toString();
		User user = dao.getUser(username);

		user.setPassword(password);
		dao.updateUser(user);
	}
	
	public static void changeInfo(String newFirst,String newLast,String newEmail,HttpSession sesh)
	{
		UserDAO dao = (UserDAO)ac.getBean("userDao");
		String username = sesh.getAttribute("userName").toString();
		User user = dao.getUser(username);

		user.setFirstName(newFirst);
		user.setLastName(newLast);
		user.setEmail(newEmail);
		dao.updateUser(user);
		
		sesh.setAttribute("firstName", user.getFirstName());
		sesh.setAttribute("lastName", user.getLastName());
		sesh.setAttribute("email", user.getEmail());		
	}
}
