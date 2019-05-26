package com.revature.beans;

import java.util.*;

import javax.persistence.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Entity
@Table(name = "USERS")
@Component

public class User 
{
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "userSeq")
	@SequenceGenerator(allocationSize = 1, name = "userSeq", sequenceName = "USER_SEQ")
	@Column(name = "USER_ID")
	private int id;

	
	@Column(name = "USERNAME", unique = true, nullable = false)
	private String username;
	
	
	@Column(name = "PASSWORD", nullable = false)
	private String password;
	
	@Column(name = "FIRST_NAME")
	private String firstName;
	
	@Column(name = "LAST_NAME")
	private String lastName;
	
	@Column(name = "EMAIL", unique = true)
	private String email;
	
	@Column(name = "USER_ROLE")
	private String userRole;
	
	@OneToMany(cascade = CascadeType.REMOVE, fetch = FetchType.EAGER, orphanRemoval = true, mappedBy="owner")
	@Autowired
	private List<Rocket> userRockets = new ArrayList<Rocket>(0);

	
	public int getId() 
	{
		return id;
	}

	public void setId(int id) 
	{
		this.id = id;
	}

	public String getUsername() 
	{
		return username;
	}

	public void setUsername(String username) 
	{
		this.username = username;
	}

	public String getPassword() 
	{
		return password;
	}

	public void setPassword(String password) 
	{
		this.password = password;
	}

	public String getFirstName() 
	{
		return firstName;
	}

	public void setFirstName(String firstName) 
	{
		this.firstName = firstName;
	}

	public String getLastName()
	{
		return lastName;
	}

	public void setLastName(String lastName)
	{
		this.lastName = lastName;
	}

	public String getEmail()
	{
		return email;
	}

	public void setEmail(String email) 
	{
		this.email = email;
	}

	public String getUserRole() 
	{
		return userRole;
	}

	public void setUserRole(String userRole) 
	{
		this.userRole = userRole;
	}

	
	
	public List<Rocket> getUserRockets() 
	{
		return userRockets;
	}

	public void setUserRockets(List<Rocket> userRockets) 
	{
		this.userRockets = userRockets;
	}

	public User() 
	{
	}

	public User(int id, String username, String password, String firstName, String lastName, String email, String userRole) 
	{
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.userRole = userRole;
	}

	@Override
	public String toString()
	{
		return "User [id=" + id + ", username=" + username + ", password=" + password + ", firstName=" + firstName
				+ ", lastName=" + lastName + ", email=" + email + ", userRole=" + userRole + "]";
	}
	
	


	
}
