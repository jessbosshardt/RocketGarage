package com.revature.controllers;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


import com.revature.beans.Comment;
import com.revature.beans.PeerOpinion;
import com.revature.beans.Rocket;
import com.revature.beans.User;
import com.revature.dao.CommentDAO;
import com.revature.dao.PeerOpinionDAO;
import com.revature.dao.RocketDAO;
import com.revature.dao.UserDAO;
import com.revature.dao.util.ApplicationContextSingleton;
import com.revature.services.PardonService;
import com.revature.services.SaveRocketService;
import com.revature.services.UserDataService;

@Controller
@RequestMapping("")
public class RocketController {
	
	private static ApplicationContext ac = ApplicationContextSingleton.getInstance();
	

	@RequestMapping(value = "rocket", method = RequestMethod.POST)
	public String userLogin(Model m, @RequestParam(value = "id") int id) {
		RocketDAO rocketDao = (RocketDAO) ac.getBean("rocketDao");

		Rocket rocket = rocketDao.getRocket(id);

		m.addAttribute("rocket", rocket.getLayout());

		return "build";
	}

	@RequestMapping(value = "backtoGarage", method = RequestMethod.POST)
	public String backtoGarage(Model m, HttpServletRequest requ) {
		HttpSession sesh = requ.getSession();

		UserDataService.getUserData(m, sesh);
		return "garage";

	}
	
	@RequestMapping(value = "toSharedRockets", method = RequestMethod.POST)
	public String toSharedRockets(Model m, HttpServletRequest requ) {
		
		RocketDAO rocketDao = (RocketDAO) ac.getBean("rocketDao");
		List<Rocket> rockets = rocketDao.getRockets();
		List<Rocket> sharedRockets = new ArrayList<Rocket>();
		
		for(Rocket r : rockets){
			if(r.isShared()){
				sharedRockets.add(r);
			}
		}
		
		m.addAttribute("sharedRockets", sharedRockets);
		
		
		return "shared";

	}

	@RequestMapping(value = "newrocket", method = RequestMethod.POST)
	public String newRocket(Model m, @RequestParam(value = "id") int level) {

		m.addAttribute("level", level);

		return "build";
	}
	
	
	@RequestMapping(value = "fly", method = RequestMethod.GET)
	public String fly(Model m) {

		return "fly";
	}

	@RequestMapping(value = "fly", method = RequestMethod.POST)
	public String flyPost(Model m, @RequestParam(value = "id") int rocketID) {

		RocketDAO rocketDao = (RocketDAO) ac.getBean("rocketDao");
		Rocket rocket = rocketDao.getRocket(rocketID);
		
		m.addAttribute("rocket", rocket.getRocketPic());
		
		return "fly";
	}
	
	@RequestMapping(value = "removeRocket", method = RequestMethod.POST)
	public String removeRocket(Model m, @RequestParam(value = "id") int rocketID) {

		RocketDAO rocketDao = (RocketDAO) ac.getBean("rocketDao");

		rocketDao.deleteRocket(rocketID);

		return "garage";

	}

	@RequestMapping(value = "share", method = RequestMethod.POST)
	public String shareRocket(Model m, @RequestParam(value = "id") int rocketID) {

		RocketDAO rocketDao = (RocketDAO) ac.getBean("rocketDao");

		Rocket updatedRocket = rocketDao.getRocket(rocketID);
		updatedRocket.setShared(true);
		rocketDao.updateRocket(updatedRocket);

		return "garage";

	}
	
	
	@RequestMapping(value = "sendtoGarage", method = RequestMethod.POST)
	public String sendToGarage(Model m, @RequestParam(value = "id") int rocketID,  HttpServletRequest requ) {

		RocketDAO rocketDao = (RocketDAO) ac.getBean("rocketDao");
		UserDAO userDao = (UserDAO) ac.getBean("userDao");
		Rocket rocket = rocketDao.getRocket(rocketID);
		HttpSession sesh = requ.getSession();		
		String username = (String) sesh.getAttribute("userName");
		User user = userDao.getUser(username);
		
		Rocket newRocket = new Rocket();
		newRocket.setLayout(rocket.getLayout());
		newRocket.setRocketName(rocket.getRocketName());
		newRocket.setRocketPic(rocket.getRocketPic());
		newRocket.setShared(false);
		newRocket.setOwner(user);
		
		rocketDao.createRocket(newRocket);

		return "shared";

	}

	@RequestMapping(value = "sendtoView", method = RequestMethod.POST)
	public String sendtoView(Model m, @RequestParam(value = "id") int id, HttpServletRequest requ) {
		HttpSession sesh = requ.getSession();
		RocketDAO rocketDao = (RocketDAO) ac.getBean("rocketDao");

		Rocket rocket = rocketDao.getRocket(id);

		List<Comment> comments = rocket.getRocketComments();
		Collections.sort(comments, new Comparator<Comment>() {
			public int compare(Comment o1, Comment o2) {
				return o2.getDate().compareTo(o1.getDate());
			}
		});

		m.addAttribute("rocketURL", rocket.getRocketPic());
		m.addAttribute("rocketComments", comments);
		m.addAttribute("rocketName", rocket.getRocketName());
		m.addAttribute("rocketAuthor", rocket.getOwner().getUsername());
		m.addAttribute("rocketId", rocket.getRocketId());
		List<PeerOpinion> lD = rocket.getRocketOpinions();

		Boolean hasOpinion = false;

		String user = (String) sesh.getAttribute("userName");

		int like = 0;
		int dLike = 0;
		for (int i = 0; i < lD.size(); i++) {

			if (lD.get(i).getAuthor().getUsername().equals(user)) {
				hasOpinion = true;
			}

			if (lD.get(i).getOpinion().equals("like")) {
				like++;
			} else if (lD.get(i).getOpinion().equals("dislike")) {
				dLike++;
			}

		}

		m.addAttribute("rocketLikes", like);
		m.addAttribute("rocketDislikes", dLike);
		m.addAttribute("hasOpinion", hasOpinion);

		System.out.println(like + " " + dLike + " " + rocket.getRocketPic());

		return "view";
	}

	@RequestMapping(value = "like", method = RequestMethod.POST)
	public String likeRocket(Model m, @RequestParam(value = "id") int rocketID, HttpServletRequest request) {
		PeerOpinionDAO peerDao = (PeerOpinionDAO) ac.getBean("peerOpinionDao");
		UserDAO userDao = (UserDAO) ac.getBean("userDao");
		HttpSession sesh = request.getSession();
		RocketDAO rocketDao = (RocketDAO) ac.getBean("rocketDao");

		String username = (String) sesh.getAttribute("userName");

		User user = userDao.getUser(username);
		Rocket rocket = rocketDao.getRocket(rocketID);

		PeerOpinion opinion = new PeerOpinion();

		opinion.setAuthor(user);
		opinion.setOpinion("like");
		opinion.setRocket(rocket);

		peerDao.createOpinion(opinion);

		return "view";

	}

	@RequestMapping(value = "dislike", method = RequestMethod.POST)
	public String dislikeRocket(Model m, @RequestParam(value = "id") int rocketID, HttpServletRequest request) {
		PeerOpinionDAO peerDao = (PeerOpinionDAO) ac.getBean("peerOpinionDao");
		UserDAO userDao = (UserDAO) ac.getBean("userDao");
		HttpSession sesh = request.getSession();
		RocketDAO rocketDao = (RocketDAO) ac.getBean("rocketDao");

		String username = (String) sesh.getAttribute("userName");

		User user = userDao.getUser(username);
		Rocket rocket = rocketDao.getRocket(rocketID);

		PeerOpinion opinion = new PeerOpinion();

		opinion.setAuthor(user);
		opinion.setOpinion("dislike");
		opinion.setRocket(rocket);

		peerDao.createOpinion(opinion);

		return "view";

	}

	@RequestMapping(value = "comment", method = RequestMethod.POST)
	public String commentRocket(Model m, @RequestParam(value = "id") int rocketID,
			@RequestParam(value = "comment") String userComment, HttpServletRequest request) {
		PeerOpinionDAO peerDao = (PeerOpinionDAO) ac.getBean("peerOpinionDao");
		UserDAO userDao = (UserDAO) ac.getBean("userDao");
		HttpSession sesh = request.getSession();
		RocketDAO rocketDao = (RocketDAO) ac.getBean("rocketDao");
		CommentDAO commentDao = (CommentDAO) ac.getBean("commentDao");

		String username = (String) sesh.getAttribute("userName");

		User user = userDao.getUser(username);
		Rocket rocket = rocketDao.getRocket(rocketID);

		Comment comment = new Comment();
		comment.setAuthor(user);
		comment.setRocket(rocket);
		comment.setComment(userComment);

		java.util.Date utilDate = new java.util.Date();
		Calendar cal = Calendar.getInstance();
		cal.setTime(utilDate);
		cal.set(Calendar.MILLISECOND, 0);

		comment.setDate(new java.sql.Timestamp(cal.getTimeInMillis()));

		commentDao.createComment(comment);

		return "view";

	}

	@RequestMapping(value = "flag", method = RequestMethod.POST)
	public String flagRocket(Model m, @RequestParam(value = "id") int rocketID, HttpServletRequest request) {
		PeerOpinionDAO peerDao = (PeerOpinionDAO) ac.getBean("peerOpinionDao");
		UserDAO userDao = (UserDAO) ac.getBean("userDao");
		HttpSession sesh = request.getSession();
		RocketDAO rocketDao = (RocketDAO) ac.getBean("rocketDao");

		String username = (String) sesh.getAttribute("userName");

		User user = userDao.getUser(username);
		Rocket rocket = rocketDao.getRocket(rocketID);

		PeerOpinion opinion = new PeerOpinion();

		opinion.setAuthor(user);
		opinion.setOpinion("flag");
		opinion.setRocket(rocket);

		peerDao.createOpinion(opinion);

		return "view";

	}

	@RequestMapping(value="save", method=RequestMethod.POST)
	public String saveRocket(Model m, HttpServletRequest request)
	{	
			SaveRocketService.SaveRocket(m,request);
			return "build";
	}



	@RequestMapping(value="removeFlag", method=RequestMethod.POST)
	public String pardonRocket(Model m, @RequestParam(value = "id") int rocketId, HttpServletRequest request)
	{
		PardonService.pardon(rocketId);
		return "garage";
	}
	

}
