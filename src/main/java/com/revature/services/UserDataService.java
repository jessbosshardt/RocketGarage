package com.revature.services;

import java.awt.List;
import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.ui.Model;

import com.revature.beans.Rocket;
import com.revature.beans.User;
import com.revature.dao.UserDAO;
import com.revature.dao.util.ApplicationContextSingleton;

public class UserDataService 
{
	
	private static ApplicationContext ac = ApplicationContextSingleton.getInstance();
	
	public static boolean getUserData(Model m, HttpSession sesh)
	{
		UserDAO dao = (UserDAO) ac.getBean("userDao");
		
		
		User user = dao.getUser(sesh.getAttribute("userName").toString());
		
		if(!(null == user))
		{
			if(user.getUserRole().equals("user"))
			{
				m.addAttribute("user", user);
				m.addAttribute("userRockets", user.getUserRockets());	
				return true;	
			}
			
			else if(user.getUserRole().equals("admin"))
			{
				ArrayList<User> users = (ArrayList<User>) dao.getUsers();
				ArrayList<Rocket> flaggedRockets = new ArrayList<Rocket>(); 
								
				for(int i = 0; i < users.size(); i++)
				{
					for(int j = 0; j < users.get(i).getUserRockets().size(); j++)
					{
						for(int k = 0; k < users.get(i).getUserRockets().get(j).getRocketOpinions().size(); k++)
						{
							if(users.get(i).getUserRockets().get(j).getRocketOpinions().get(k).getOpinion().equals("flag"))
							{
								flaggedRockets.add(users.get(i).getUserRockets().get(j));
							}
						}
					}
				}
				
				m.addAttribute("users", users);
				m.addAttribute("flaggedRockets", flaggedRockets);
				
				
				return true;
			}
			
			else
			{
				return false;
			}

		}
		
		return false;
	}
}
