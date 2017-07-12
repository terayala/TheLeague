package com.revature.beans;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Entity
@Table(name = "USERS")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE, region = "myAwesomeCache")
@Component
public class User {

	@Id
	@Column(name = "USER_ID")
	@SequenceGenerator(name = "USERID_SEQ", sequenceName = "USERID_SEQ")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "USERID_SEQ")
	private int userID;
	
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name="TEAM_ID",referencedColumnName = "TEAM_ID")
	@Autowired
	@NotEmpty(message="Team cannot be empty")
	private Team team;
	
	@Column(name = "FIRST_NAME")
	@NotEmpty(message="first name cannot be empty")
	private String firstName;
	
	@Column(name = "LAST_NAME")
	@NotEmpty(message="last name cannot be empty")
	private String lastName;
	
	@Column(name = "ROLE")
	private int role;
	
	@Column(name = "EMAIL")
	@NotEmpty(message="email cannot be empty")
	private String email;
	
	@Column(name = "USERNAME")
	@NotEmpty(message="Username cannot be empty")
	private String username;
	
	@Column(name = "PASSWORD")
	@NotEmpty(message="Password cannot be empty")
	private String password;
	
	@Column(name = "UNIFORM_NUMBER")
	private int uniform;
	
	@Column(name = "ACTIVE")
	private int active;
	
	public User() {
		
	}

	public User(Team team, String firstName, String lastName, int role, String email, String username, String password,
			int uniform, int active) {
		this.team = team;
		this.firstName = firstName;
		this.lastName = lastName;
		this.role = role;
		this.email = email;
		this.username = username;
		this.password = password;
		this.uniform = uniform;
		this.active = active;
	}

	public int getUserID() {
		return userID;
	}

	public void setUserID(int userID) {
		this.userID = userID;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public int getRole() {
		return role;
	}

	public void setRole(int role) {
		this.role = role;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getUniform() {
		return uniform;
	}

	public void setUniform(int uniform) {
		this.uniform = uniform;
	}

	public boolean getActive() {
		if (active == 0) {
			return false;
		} else {
			return true;
		}
	}

	public void setActive(int active) {
		this.active = active;
	}

	public Team getTeam() {
		return team;
	}

	public void setTeam(Team team) {
		this.team = team;
	}

	@Override
	public String toString() {
		return "User [userID=" + userID + ", team=" + team + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", role=" + role + ", email=" + email + ", username=" + username + ", password=" + password
				+ ", uniform=" + uniform + ", active=" + active + "]";
	}
}
