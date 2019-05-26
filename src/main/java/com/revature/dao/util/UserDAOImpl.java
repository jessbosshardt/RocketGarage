package com.revature.dao.util;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;

import com.revature.beans.Rocket;
import com.revature.beans.User;
import com.revature.dao.UserDAO;

@Transactional
public class UserDAOImpl implements UserDAO 
{
	private SessionFactory sessionFactory;
	public void setSessionFactory(SessionFactory sessionFactory)
	{
		this.sessionFactory = sessionFactory;
	}
	
	
	@Override
	public boolean createUser(User user) 
	{
		try
		{
			Session sesh = sessionFactory.getCurrentSession();
			ArrayList<User> alreadyExists = new ArrayList<User>();
			alreadyExists = (ArrayList<User>) sesh.createQuery("FROM User WHERE USERNAME =" + "'" + user.getUsername() + "'").list();

			if(alreadyExists.size() == 0)
			{
				for(Rocket rock : user.getUserRockets())
				{
					sesh.saveOrUpdate(rock);
				}
				sesh.save(user);
				return true;	
			}
			else
			{
				return false;
			}

		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			return false;
		}

	}

	@Override
	public User getUser(int userId) 
	{
		try
		{
			Session sesh = sessionFactory.getCurrentSession();
			ArrayList<User> result = new ArrayList<User>();
			User user = new User();
			

			result =  (ArrayList<User>) sesh.createQuery("FROM User WHERE id =" + userId).list();
			
			if(result.size() > 0)
			{
				user = result.get(0);
			}
			return user;
		}
		catch(HibernateException ex)
		{
			ex.printStackTrace();
			return null;
		}
	}

	@Override
	public List<User> getUsers() 
	{
		try
		{
			Session sesh = sessionFactory.getCurrentSession();
			ArrayList<User> users = new ArrayList<User>();
			

			users =  (ArrayList<User>) sesh.createQuery("FROM User").list();
			
			return users;
		}
		catch(HibernateException ex)
		{
			ex.printStackTrace();
			return null;
		}	
		
	}

	@Override
	public boolean updateUser(User user) 
	{
		try
		{
			Session sesh = sessionFactory.getCurrentSession();
			if(user.getId() != 0)
			{
				sesh.update(user);
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

	@Override
	public boolean deleteUser(int userId) 
	{
		try
		{
			Session sesh = sessionFactory.getCurrentSession();
			User user = new User();
			user = (User)sesh.get(User.class, userId);
			if(user != null)
			{
				sesh.delete(user);
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


	@Override
	public User getUser(String username) 
	{
		try
		{
			Session sesh = sessionFactory.getCurrentSession();
			ArrayList<User> result = new ArrayList<User>();
			User user = new User();
			

			result =  (ArrayList<User>) sesh.createQuery("FROM User WHERE username =" + "'" + username + "'").list();
			
			if(result.size() > 0)
			{
				user = result.get(0);
			}
			return user;
		}
		catch(HibernateException ex)
		{
			ex.printStackTrace();
			return null;
		}
	}
}
