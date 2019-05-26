package com.revature.dao;

import java.util.List;

import com.revature.beans.PeerOpinion;
import com.revature.beans.Rocket;
import com.revature.beans.User;


public interface PeerOpinionDAO 
{
	public boolean createOpinion(PeerOpinion opinion);
	
	public PeerOpinion getOpinion(User author, Rocket rocket);
	public List<PeerOpinion> getOpinions();
	
	public boolean updateOpinion(PeerOpinion opinion);
	
	public boolean deleteOpinion(int opinionId);
}
