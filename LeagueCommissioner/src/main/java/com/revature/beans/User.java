package com.revature.beans;

public class User {

	private int userID;
	private int teamID;
	private String firstName;
	private String lastName;
	private int role;
	private String email;
	private String username;
	private String password;
	private int uniform;
	private int active;
	
	public User() {
		
	}

	public User(int teamID, String firstName, String lastName, int role, String email, String username, String password,
			int uniform, int active) {
		this.teamID = teamID;
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

	public int getTeamID() {
		return teamID;
	}

	public void setTeamID(int teamID) {
		this.teamID = teamID;
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

	public int getActive() {
		return active;
	}

	public void setActive(int active) {
		this.active = active;
	}
}
