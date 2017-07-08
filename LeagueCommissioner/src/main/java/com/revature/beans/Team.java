package com.revature.beans;

import java.sql.Blob;

public class Team {

	private int teamID;
	private String name;
	private String nickname;
	private Blob logo;
	private int leagueID;
	private int primaryColor;
	private int secondaryColor;
	
	public Team() {
		
	}

	public Team(String name, String nickname, Blob logo, int leagueID, int primaryColor, int secondaryColor) {
		this.name = name;
		this.nickname = nickname;
		this.logo = logo;
		this.leagueID = leagueID;
		this.primaryColor = primaryColor;
		this.secondaryColor = secondaryColor;
	}

	public int getTeamID() {
		return teamID;
	}

	public void setTeamID(int teamID) {
		this.teamID = teamID;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public Blob getLogo() {
		return logo;
	}

	public void setLogo(Blob logo) {
		this.logo = logo;
	}

	public int getLeagueID() {
		return leagueID;
	}

	public void setLeagueID(int leagueID) {
		this.leagueID = leagueID;
	}

	public int getPrimaryColor() {
		return primaryColor;
	}

	public void setPrimaryColor(int primaryColor) {
		this.primaryColor = primaryColor;
	}

	public int getSecondaryColor() {
		return secondaryColor;
	}

	public void setSecondaryColor(int secondaryColor) {
		this.secondaryColor = secondaryColor;
	}
}
