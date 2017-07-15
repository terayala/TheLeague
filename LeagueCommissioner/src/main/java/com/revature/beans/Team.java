package com.revature.beans;

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
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Entity
@Table(name = "TEAMS")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE, region = "myAwesomeCache")
@Component
public class Team {

	@Id
	@Column(name = "TEAM_ID")
	@SequenceGenerator(name = "TEAMID_SEQ", sequenceName = "TEAMID_SEQ")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "TEAMID_SEQ")
	private int teamID;
	
	@Column(name = "TEAM_NAME")
	@NotEmpty(message="name cannot be empty")
	private String name;
	
	@Column(name = "TEAM_NICKNAME")
	@NotEmpty(message="nickname cannot be empty")
	private String nickname;
	
	@OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name="LEAGUE_ID", referencedColumnName = "LEAGUE_ID")
	@Autowired
	private League league;
	
	@Column(name = "COLOR_PRIMARY")
	
	private int primaryColor;
	
	@Column(name = "COLOR_SECONDARY")
	private int secondaryColor;
	
	public Team() {
		
	}

	public Team(String name, String nickname, League leagueID, int primaryColor, int secondaryColor) {
		this.name = name;
		this.nickname = nickname;
		this.league = leagueID;
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

	public League getLeague() {
		return league;
	}

	public void setLeague(League leagueID) {
		this.league = leagueID;
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

	@Override
	public String toString() {
		return "Team [teamID=" + teamID + ", name=" + name + ", nickname=" + nickname + ", leagueID=" + league
				+ ", primaryColor=" + primaryColor + ", secondaryColor=" + secondaryColor + "]";
	}
}
