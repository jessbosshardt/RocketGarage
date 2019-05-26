package com.revature.services;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.revature.beans.Rocket;
import com.revature.dao.PeerOpinionDAO;
import com.revature.dao.RocketDAO;
import com.revature.dao.util.ApplicationContextSingleton;

public class PardonService 
{
	
	private static ApplicationContext ac = ApplicationContextSingleton.getInstance();

	
	public static void pardon(int rocketId)
	{
		RocketDAO rocketDao = (RocketDAO)ac.getBean("rocketDao");
		PeerOpinionDAO opinionDao = (PeerOpinionDAO)ac.getBean("peerOpinionDao");
		Rocket newLeaseOnLife = rocketDao.getRocket(rocketId);
		
		for(int i = 0; i < newLeaseOnLife.getRocketOpinions().size(); i++)
		{
			if(newLeaseOnLife.getRocketOpinions().get(i).getOpinion().equals("flag"))
			{
				opinionDao.deleteOpinion(newLeaseOnLife.getRocketOpinions().get(i).getId());
			}
		}
	}
}
