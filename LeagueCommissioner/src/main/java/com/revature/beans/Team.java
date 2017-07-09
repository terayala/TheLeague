package com.revature.beans;

import java.sql.Blob;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

@Entity
@Table(name = "TEAMS")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE, region = "myAwesomeCache")
public class Team {

	@Id
	@Column(name = "TEAM_ID")
	@SequenceGenerator(name = "TEAMID_SEQ", sequenceName = "TEAMID_SEQ")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "TEAMID_SEQ")
	private int teamID;
	
	@Column(name = "TEAM_NAME")
	private String name;
	
	@Column(name = "TEAM_NICKNAME")
	private String nickname;
	
	@Column(name = "LOGO")
	private Blob logo;
	
	@OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "LEAGUE_ID")
	private int leagueID;
	
	@Column(name = "COLOR_PRIMARY")
	private int primaryColor;
	
	@Column(name = "COLOR_SECONDARY")
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
