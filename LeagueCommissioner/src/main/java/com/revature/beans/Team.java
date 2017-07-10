package com.revature.beans;

import java.sql.Blob;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
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
	private League leagueID;
	
	@Column(name = "COLOR_PRIMARY")
	private int primaryColor;
	
	@Column(name = "COLOR_SECONDARY")
	private int secondaryColor;
	
	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "TEAMID")
	private League league;
	
	@OneToMany(mappedBy = "team")
	private List<User> players;
	
	@OneToMany(mappedBy = "team")
	private List<Game> games;
	
	public Team() {
		
	}

	public Team(String name, String nickname, Blob logo, League leagueID, int primaryColor, int secondaryColor) {
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
		return leagueID.getLeagueID();
	}

	public void setLeagueID(League leagueID) {
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

	public League getLeagueTeam() {
		return league;
	}

	public void setLeagueTeam(League leagueTeam) {
		this.league = leagueTeam;
	}

	public League getLeague() {
		return league;
	}

	public void setLeague(League league) {
		this.league = league;
	}

	public List<User> getPlayers() {
		return players;
	}

	public void setPlayers(List<User> players) {
		this.players = players;
	}

	public List<Game> getGames() {
		return games;
	}

	public void setGames(List<Game> games) {
		this.games = games;
	}
}
