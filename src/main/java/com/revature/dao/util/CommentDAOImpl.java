package com.revature.dao.util;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;

import com.revature.beans.Comment;
import com.revature.dao.CommentDAO;

@Transactional
public class CommentDAOImpl implements CommentDAO 
{

	private SessionFactory sessionFactory;
	public void setSessionFactory(SessionFactory sessionFactory)
	{
		this.sessionFactory = sessionFactory;
	}
	
	@Override
	public boolean createComment(Comment comment) 
	{
		try
		{
			Session sesh = sessionFactory.getCurrentSession();
			sesh.save(comment);

			return true;
		}
		catch(HibernateException ex)
		{
			ex.printStackTrace();
			return false;
		}		
	}

	@Override
	public Comment getComment(int commentId) 
	{
		try
		{
			Session sesh = sessionFactory.getCurrentSession();
			ArrayList<Comment> result = new ArrayList<Comment>();
			Comment comment = new Comment();
			

			result =  (ArrayList<Comment>) sesh.createQuery("FROM Comment WHERE id =" + commentId).list();
			
			if(result.size() > 0)
			{
				comment = result.get(0);
			}
			return comment;
		}
		catch(HibernateException ex)
		{
			ex.printStackTrace();
			return null;
		}
	}

	@Override
	public List<Comment> getComments(int rocketId) 
	{
		try
		{
			Session sesh = sessionFactory.getCurrentSession();
			ArrayList<Comment> comments = new ArrayList<Comment>();
			

			comments =  (ArrayList<Comment>) sesh.createQuery("FROM Comment").list();
			
			return comments;
		}
		catch(HibernateException ex)
		{
			ex.printStackTrace();
			return null;
		}	
		
	}

	@Override
	public boolean updateComment(Comment comment)
	{
		try
		{
			Session sesh = sessionFactory.getCurrentSession();
			if(comment.getId() != 0)
			{
				sesh.update(comment);
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
	public boolean deleteComment(int commentId) 
	{
		try
		{
			Session sesh = sessionFactory.getCurrentSession();
			Comment comment = new Comment();
			comment = (Comment)sesh.get(Comment.class, commentId);
			if(comment != null)
			{
				sesh.delete(comment);
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
