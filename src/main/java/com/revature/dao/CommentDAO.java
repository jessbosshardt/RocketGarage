package com.revature.dao;

import java.util.List;

import com.revature.beans.*;

public interface CommentDAO 
{
	public boolean createComment(Comment comment);
	
	public Comment getComment(int commentId);
	public List<Comment> getComments(int rocketId);
	
	public boolean updateComment(Comment comment);
	
	public boolean deleteComment(int commentId);
	
}
