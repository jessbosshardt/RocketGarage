package com.revature.dao.util;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;

import com.revature.beans.Rocket;
import com.revature.dao.RocketDAO;

@Transactional
public class RocketDAOImpl implements RocketDAO 
{
	private SessionFactory sessionFactory;
	public void setSessionFactory(SessionFactory sessionFactory)
	{
		this.sessionFactory = sessionFactory;
	}

	@Override
	public boolean createRocket(Rocket rocket) 
	{
		try
		{
			Session sesh = sessionFactory.getCurrentSession();
				sesh.save(rocket);
				return true;	
		}
		catch(HibernateException ex)
		{
			ex.printStackTrace();
			return false;
		}
	}

	@Override
	public Rocket getRocket(int rocketId) 
	{
		try
		{
			Session sesh = sessionFactory.getCurrentSession();
			ArrayList<Rocket> result = new ArrayList<Rocket>();
			Rocket rocket = new Rocket();
			

			result =  (ArrayList<Rocket>) sesh.createQuery("FROM Rocket WHERE id =" + rocketId).list();
			
			if(result.size() > 0)
			{
				rocket = result.get(0);
			}
			return rocket;
		}
		catch(HibernateException ex)
		{
			ex.printStackTrace();
			return null;
		}
	}

	@Override
	public List<Rocket> getRockets() 
	{
		try
		{
			Session sesh = sessionFactory.getCurrentSession();
			ArrayList<Rocket> rockets = new ArrayList<Rocket>();
			

			rockets =  (ArrayList<Rocket>) sesh.createQuery("FROM Rocket").list();
			
			return rockets;
		}
		catch(HibernateException ex)
		{
			ex.printStackTrace();
			return null;
		}	
		
	}

	@Override
	public boolean updateRocket(Rocket rocket)
	{
		try
		{
			Session sesh = sessionFactory.getCurrentSession();
			if(rocket.getRocketId() != 0)
			{
				sesh.update(rocket);
				return true;	
			}
			else
			{
				return false;
			}

		}
		catch(HibernateException ex)
		{
			ex.printStackTrace();
			return false;
		}	}

	@Override
	public boolean deleteRocket(int rocketId) 
	{
		try
		{
			Session sesh = sessionFactory.getCurrentSession();
			Rocket rocket = new Rocket();
			rocket = (Rocket)sesh.get(Rocket.class, rocketId);
			if(rocket != null)
			{
				sesh.delete(rocket);
				return true;
			}
			else
			{
				return false;
			}
		}
		catch(HibernateException ex)
		{
			ex.printStackTrace();
			return false;
		}
	}

}
