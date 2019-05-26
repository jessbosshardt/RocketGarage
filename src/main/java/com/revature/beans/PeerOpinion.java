package com.revature.beans;

import javax.persistence.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Entity
@Table(name = "PEER_OPINION")
@Component
public class PeerOpinion 
{
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "opinionSeq")
	@SequenceGenerator(allocationSize = 1, name = "opinionSeq", sequenceName = "OPINION_SEQ")
	@Column(name = "OPINION_ID")
	private int id;
	
	@Column(name = "OPINION", nullable = false)
	private String opinion;
	
	@ManyToOne
	@JoinColumn(name="USER_ID", nullable = false)
	@Autowired
	private User author;
	
	@ManyToOne
	@JoinColumn(name="ROCKET_ID", nullable = false)
	@Autowired
	private Rocket rocket;

	public int getId() 
	{
		return id;
	}

	public void setId(int id) 
	{
		this.id = id;
	}

	public String getOpinion() 
	{
		return opinion;
	}

	public void setOpinion(String opinion)
	{
		this.opinion = opinion;
	}

	public User getAuthor()
	{
		return author;
	}

	public void setAuthor(User author) 
	{
		this.author = author;
	}

	public Rocket getRocket() 
	{
		return rocket;
	}

	public void setRocket(Rocket rocket) 
	{
		this.rocket = rocket;
	}

	@Override
	public String toString() 
	{
		return "PeerOpinion [id=" + id + ", opinion=" + opinion + ", author=" + author.getId() + ", rocket=" + rocket.getRocketId() + "]";
	}

	public PeerOpinion(int id, String opinion, User author, Rocket rocket) 
	{
		super();
		this.id = id;
		this.opinion = opinion;
		this.author = author;
		this.rocket = rocket;
	}

	public PeerOpinion() 
	{
	}
	
	
}
