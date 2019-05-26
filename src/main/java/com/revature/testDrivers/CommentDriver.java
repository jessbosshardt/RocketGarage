package com.revature.testDrivers;

import java.sql.Timestamp;
import java.util.ArrayList;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.revature.beans.Comment;
import com.revature.beans.Rocket;
import com.revature.beans.User;
import com.revature.dao.CommentDAO;
import com.revature.dao.RocketDAO;

public class CommentDriver 
{
	public static void main(String[] args) 
	{
		AbstractApplicationContext ac = new ClassPathXmlApplicationContext("beans.xml");
		CommentDAO dao = (CommentDAO) ac.getBean("commentDao");
		
		User user = new User();
		user.setId(4);
		Rocket rocket = new Rocket();
		rocket.setRocketId(6);
		
		Timestamp time = new Timestamp(123476589);
		
		Comment comment = new Comment();
		Comment comment2 = new Comment();
		Comment comment3 = new Comment();
		
		comment.setAuthor(user);
		comment.setRocket(rocket);
		comment.setComment("blahblahblahUpdate");
		comment.setDate(time);
		
		comment2.setAuthor(user);
		comment2.setRocket(rocket);
		comment2.setComment("blahblahblah2");
		comment2.setDate(time);
		
		comment3 = dao.getComment(1);
		comment3.setComment("blahblahblah2");
		
		
		
		System.out.println(dao.createComment(comment));
		//System.out.println(dao.deleteComment(2));
		//System.out.println(dao.updateComment(comment3));
		
		
		ArrayList<Comment> comments = new ArrayList<Comment>();
		comments = (ArrayList<Comment>) dao.getComments(1);
		System.out.println(comments.toString());
		
		
		
		
	}
		
}
