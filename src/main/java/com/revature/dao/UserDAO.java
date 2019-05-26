package com.revature.dao;

import java.util.List;

import com.revature.beans.User;

public interface UserDAO 
{
	public boolean createUser(User user);
	
	public User getUser(int userId);
	public User getUser(String username);
	public List<User> getUsers();
	
	public boolean updateUser(User user);
	
	public boolean deleteUser(int userId);
	
}
