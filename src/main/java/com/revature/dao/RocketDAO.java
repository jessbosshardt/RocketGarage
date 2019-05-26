package com.revature.dao;

import java.util.List;

import com.revature.beans.Rocket;

public interface RocketDAO 
{
	public boolean createRocket(Rocket rocket);
	
	public Rocket getRocket(int rocketId);
	public List<Rocket> getRockets();
	
	public boolean updateRocket(Rocket rocket);
	
	public boolean deleteRocket(int rocketId);

}
