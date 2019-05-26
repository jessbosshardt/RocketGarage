package com.revature.testDrivers;

import java.util.ArrayList;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.revature.beans.PeerOpinion;
import com.revature.beans.Rocket;
import com.revature.beans.User;
import com.revature.dao.PeerOpinionDAO;
import com.revature.dao.RocketDAO;
import com.revature.dao.UserDAO;

public class PeerOpinionDriver 
{
	
	public static void main(String[] args) 
	{
		AbstractApplicationContext ac = new ClassPathXmlApplicationContext("beans.xml");
		PeerOpinionDAO dao = (PeerOpinionDAO) ac.getBean("peerOpinionDao");
		UserDAO userDao = (UserDAO) ac.getBean("userDao");
		RocketDAO rocketDao = (RocketDAO) ac.getBean("rocketDao");


		User user = new User();
		user.setId(1);
		user = userDao.getUser(1);

		Rocket rocket = new Rocket();
		rocket.setRocketId(7);
		rocket = rocketDao.getRocket(7);
	

		PeerOpinion opinion = new PeerOpinion();
		opinion.setAuthor(user);
		opinion.setRocket(rocket);
		opinion.setOpinion("like");
	
		PeerOpinion opinion2 = new PeerOpinion();
		opinion2.setAuthor(user);
		opinion2.setRocket(rocket);
		opinion2.setOpinion("dislike");
		
		PeerOpinion opinion3 = new PeerOpinion();
		opinion3.setAuthor(user);
		opinion3.setRocket(rocket);
		opinion3.setOpinion("flag");
		
		//PeerOpinion opinion4 = dao.getOpinion(user, rocket);
		//opinion4.setOpinion("flag");

		System.out.println(dao.createOpinion(opinion3));
		//System.out.println(dao.updateOpinion(opinion3));
		//System.out.println(dao.deleteOpinion(4));
		
		
		ArrayList<PeerOpinion> opinions = new ArrayList<PeerOpinion>();
		opinions = (ArrayList<PeerOpinion>) dao.getOpinions();
		System.out.println(opinions.toString());
	}
}
