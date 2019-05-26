package com.revature.testDrivers;

import java.util.ArrayList;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.revature.beans.User;
import com.revature.dao.UserDAO;

public class UserDriver {
	
	public static void main(String[] args) 
	{
		/*
		Comment comment = new Comment();
		comment.setComment("test comment");
		//comment.setAuthor(author);
		*/
	
		AbstractApplicationContext ac = new ClassPathXmlApplicationContext("beans.xml");
		UserDAO dao = (UserDAO) ac.getBean("userDao");
		
		
		User user1 = new User();
		user1.setId(1);
		user1.setFirstName("Robert");
		user1.setLastName("Walters");
		user1.setUsername("rwalters");
		user1.setPassword("rwalters");
		user1.setUserRole("user");
		
		//dao.updateUser(user1);
		
		
		User user2 = new User();
		user2.setFirstName("Jesse");
		user2.setLastName("Bosshardt");
		user2.setUsername("jbosshardt");
		user2.setPassword("jbosshardt");
		user2.setUserRole("user");
		user2.setEmail("jboss@jboss.com");
		
		User user3 = new User();
		user3.setFirstName("Luis");
		user3.setLastName("Nieves");
		user3.setUsername("lnieves");
		user3.setPassword("lnieves");
		user3.setUserRole("user");
		user3.setEmail("lniev@lniev.com");
		
		User user4 = new User();
		
		User user5 = new User();
		user5.setFirstName("Emily");
		user5.setLastName("Higgins");
		user5.setUsername("ehiggins");
		user5.setPassword("ehiggins");
		user5.setUserRole("admin");
		user5.setEmail("ehig@ehig.com");
		
		//dao.updateUser(user4);
		System.out.println(dao.createUser(user5));
		
		
		//dao.deleteUser(1);
		
		
		//User userGot = dao.getUser(4);
		//System.out.println(userGot.toString());
		//System.out.println(userGot.getUserRockets().toString());
		System.out.println();
		
		
		//System.out.println(dao.getUser(1).toString());
		//System.out.println(dao.getUser(1).getUserRockets().toString());
		System.out.println(dao.getUser("asdfas").toString());
		
		//System.out.println(dao.deleteUser(2));
		
		ArrayList<User> users = new ArrayList<User>();
		users = (ArrayList<User>) dao.getUsers();
		
		
		
		System.out.println(users.size());
		for(int i = 0; i < users.size(); i++)
		{
			System.out.println(users.get(i).toString());
			
		}
	}
}
