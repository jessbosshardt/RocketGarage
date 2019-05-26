package com.revature.testDrivers;

import java.util.ArrayList;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.revature.beans.Rocket;
import com.revature.beans.User;
import com.revature.dao.RocketDAO;

public class RocketDriver 
{
		public static void main(String[] args) 
		{
			AbstractApplicationContext ac = new ClassPathXmlApplicationContext("beans.xml");
			RocketDAO dao = (RocketDAO) ac.getBean("rocketDao");
			
			Rocket rocket = new Rocket();
			Rocket rocket2= new Rocket();
			Rocket rocket3= new Rocket();
			User user = new User();
			user.setId(1);
			
			
			rocket.setLayout("test");
			rocket.setOwner(user);
			rocket.setRocketName("Rocket1");
			
			rocket2.setLayout("test2");
			rocket2.setOwner(user);
			rocket2.setRocketName("Rocket2");

			
			//rocket3.setRocketId(2);
			rocket3.setLayout("test3");
			rocket3.setOwner(user);
			rocket3.setRocketName("Rocket3");

			
			System.out.println(dao.createRocket(rocket3));
			//System.out.println(dao.updateRocket(rocket2));
			//System.out.println(dao.deleteRocket(2));
			
			/*
			Rocket gotRocket = dao.getRocket(6);
			System.out.println(gotRocket.getRocketComments().toString());
			System.out.println(gotRocket.getRocketOpinions().toString());
			System.out.println();
			*/
			
			ArrayList<Rocket> rockets = new ArrayList<Rocket>();
			rockets = (ArrayList<Rocket>) dao.getRockets();
			
			
			
			System.out.println(rockets.size());
			for(int i = 0; i < rockets.size(); i++)
			{
				System.out.println(rockets.get(i).toString());
				
			}
			
		}
}
