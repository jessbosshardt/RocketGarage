package com.revature.beans;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Entity
@Table(name = "ROCKETS")
@Component
public class Rocket 
{
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "rocketSeq")
	@SequenceGenerator(allocationSize = 1, name = "rocketSeq", sequenceName = "ROCKET_SEQ")
	@Column(name = "ROCKET_ID")
	private int rocketId;
	
	@ManyToOne
	@JoinColumn(name="USER_ID", nullable = false)
	@Autowired
	private User owner;
	
	@Column(name = "ROCKET_NAME", nullable = false)
	private String rocketName;
	
	@Column(name = "LAYOUT", columnDefinition="CLOB NOT NULL")
	private String layout;
	
	@Column(name= "ROCKET_PIC")
	private String rocketPic;
	
	@Column(name= "SHARED_ROCKET")
	private boolean shared;
	
	@OneToMany(cascade = CascadeType.REMOVE, fetch = FetchType.EAGER, orphanRemoval = true, mappedBy="rocket")
	@Autowired
	private List<Comment> rocketComments = new ArrayList<Comment>(0);
	
	@OneToMany(cascade = CascadeType.REMOVE, fetch = FetchType.EAGER, orphanRemoval = true, mappedBy="rocket")
	@Autowired
	private List<PeerOpinion> rocketOpinions = new ArrayList<PeerOpinion>(0);

	public int getRocketId() 
	{
		return rocketId;
	}

	public void setRocketId(int rocketId) 
	{
		this.rocketId = rocketId;
	}

	public User getOwner() 
	{
		return owner;
	}

	public void setOwner(User owner)
	{
		this.owner = owner;
	}

	public String getLayout() 
	{
		return layout;
	}

	public void setLayout(String layout) 
	{
		this.layout = layout;
	}

	public String getRocketPic() 
	{
		return rocketPic;
	}

	public void setRocketPic(String rocketPic) 
	{
		this.rocketPic = rocketPic;
	}

	public boolean isShared() 
	{
		return shared;
	}

	public void setShared(boolean shared) 
	{
		this.shared = shared;
	}

	public List<Comment> getRocketComments() 
	{
		return rocketComments;
	}

	public void setRocketComments(List<Comment> rocketComments) 
	{
		this.rocketComments = rocketComments;
	}

	public List<PeerOpinion> getRocketOpinions() 
	{
		return rocketOpinions;
	}

	public void setRocketOpinions(List<PeerOpinion> rocketOpinions)
	{
		this.rocketOpinions = rocketOpinions;
	}

	public String getRocketName() 
	{
		return rocketName;
	}

	public void setRocketName(String rocketName) 
	{
		this.rocketName = rocketName;
	}



	@Override
	public String toString() {
		return "Rocket [rocketId=" + rocketId + ", owner=" + owner + ", rocketName=" + rocketName + ", layout=" + layout
				+ ", rocketPic=" + rocketPic + ", shared=" + shared + ", rocketComments=" + rocketComments
				+ ", rocketOpinions=" + rocketOpinions + "]";
	}



	public Rocket(int rocketId, User owner, String rocketName, String layout, String rocketPic, boolean shared,
			List<Comment> rocketComments, List<PeerOpinion> rocketOpinions) {
		super();
		this.rocketId = rocketId;
		this.owner = owner;
		this.rocketName = rocketName;
		this.layout = layout;
		this.rocketPic = rocketPic;
		this.shared = shared;
		this.rocketComments = rocketComments;
		this.rocketOpinions = rocketOpinions;
	}

	public Rocket() 
	{
		super();
	}
}
