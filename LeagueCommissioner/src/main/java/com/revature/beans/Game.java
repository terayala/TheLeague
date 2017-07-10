package com.revature.beans;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

@Entity
@Table(name = "GAMES")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE, region = "myAwesomeCache")
public class Game {
	
	@Id
	@Column(name = "GAME_ID")
	@SequenceGenerator(name = "GAMEID_SEQ", sequenceName = "GAMEID_SEQ")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "GAMEID_SEQ")
	private int gameID;
	
	@OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name="HOME_TEAM", referencedColumnName = "TEAM_ID")
	private Team homeTeam;
	
	@OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name="AWAY_TEAM", referencedColumnName = "TEAM_ID")
	private Team awayTeam;
	
	@Column(name = "GAME_DATE")
	private Timestamp gameDate;
	
	@Column(name = "HOME_SCORE")
	private Integer homeScore;
	
	@Column(name = "AWAY_SCORE")
	private Integer awayScore;
	
	@Column(name = "IS_OVERTIME")
	private int isOvertime;
	
	@Column(name = "HOME_APPROVED")
	private int homeApproved;
	
	@Column(name = "AWAY_APPROVED")
	private int awayApproved;
	
	@Column(name = "COMMISSIONER_APPROVED")
	private int commissionerApproved;
	
	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name="TEAM_ID",referencedColumnName = "TEAM_ID")
	private Team team_id;
	
	public Game() {
		
	}

	public Game(Team homeTeam, Team awayTeam, Timestamp gameDate) {
		this.homeTeam = homeTeam;
		this.awayTeam = awayTeam;
		this.gameDate = gameDate;
	}

	public int getGameID() {
		return gameID;
	}

	public void setGameID(int gameID) {
		this.gameID = gameID;
	}

	public int getHomeTeam() {
		return homeTeam.getTeamID();
	}

	public void setHomeTeam(Team homeTeam) {
		this.homeTeam = homeTeam;
	}

	public int getAwayTeam() {
		return awayTeam.getTeamID();
	}

	public void setAwayTeam(Team awayTeam) {
		this.awayTeam = awayTeam;
	}

	public String getGameDate() {
		DateFormat dateFormat = new SimpleDateFormat("MMM-dd-yyyy HH:mm:ss");
		return dateFormat.format(gameDate);
	}

	public void setGameDate(Timestamp gameDate) {
		this.gameDate = gameDate;
	}

	public Integer getHomeScore() {
		return homeScore;
	}

	public void setHomeScore(Integer homeScore) {
		this.homeScore = homeScore;
	}

	public Integer getAwayScore() {
		return awayScore;
	}

	public void setAwayScore(Integer awayScore) {
		this.awayScore = awayScore;
	}

	public boolean getIsOvertime() {
		if (isOvertime == 0) {
			return false;
		} else {
			return true;
		}
	}

	public void setIsOvertime(int isOvertime) {
		this.isOvertime = isOvertime;
	}

	public boolean getHomeApproved() {
		if (homeApproved == 0) {
			return false;
		} else {
			return true;
		}
	}

	public void setHomeApproved(int homeApproved) {
		this.homeApproved = homeApproved;
	}

	public boolean getAwayApproved() {
		if (awayApproved == 0) {
			return false;
		} else {
			return true;
		}
	}

	public void setAwayApproved(int awayApproved) {
		this.awayApproved = awayApproved;
	}

	public boolean getCommissionerApproved() {
		if (commissionerApproved == 0) {
			return false;
		} else {
			return true;
		}
	}

	public void setCommissionerApproved(int commissionerApproved) {
		this.commissionerApproved = commissionerApproved;
	}

	public Team getTeam() {
		return team_id;
	}

	public void setTeam(Team team) {
		this.team_id = team;
	}

	@Override
	public String toString() {
		return "Game [gameID=" + gameID + ", home_team=" + homeTeam + ", away_team=" + awayTeam + ", gameDate="
				+ gameDate + ", homeScore=" + homeScore + ", awayScore=" + awayScore + ", isOvertime=" + isOvertime
				+ ", homeApproved=" + homeApproved + ", awayApproved=" + awayApproved + ", commissionerApproved="
				+ commissionerApproved + ", team=" + team_id + "]";
	}	
}
