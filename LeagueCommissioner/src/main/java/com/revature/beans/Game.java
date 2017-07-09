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
	@JoinColumn(name = "TEAM_ID")
	private int homeTeam;
	
	@OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "TEAM_ID")
	private int awayTeam;
	
	@Column(name = "GAME_DATE")
	private String gameDate;
	
	@Column(name = "HOME_SCORE")
	private int homeScore;
	
	@Column(name = "AWAY_SCORE")
	private int awayScore;
	
	@Column(name = "IS_OVERTIME")
	private int isOvertime;
	
	@Column(name = "HOME_APPROVED")
	private int homeApproved;
	
	@Column(name = "AWAY_APPROVED")
	private int awayApproved;
	
	@Column(name = "COMMISSIONER_APPROVED")
	private int commissionerApproved;
	
	public Game() {
		
	}

	public Game(int homeTeam, int awayTeam, String gameDate) {
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
		return homeTeam;
	}

	public void setHomeTeam(int homeTeam) {
		this.homeTeam = homeTeam;
	}

	public int getAwayTeam() {
		return awayTeam;
	}

	public void setAwayTeam(int awayTeam) {
		this.awayTeam = awayTeam;
	}

	public String getGameDate() {
		return gameDate;
	}

	public void setGameDate(String gameDate) {
		this.gameDate = gameDate;
	}

	public int getHomeScore() {
		return homeScore;
	}

	public void setHomeScore(int homeScore) {
		this.homeScore = homeScore;
	}

	public int getAwayScore() {
		return awayScore;
	}

	public void setAwayScore(int awayScore) {
		this.awayScore = awayScore;
	}

	public int getIsOvertime() {
		return isOvertime;
	}

	public void setIsOvertime(int isOvertime) {
		this.isOvertime = isOvertime;
	}

	public int getHomeApproved() {
		return homeApproved;
	}

	public void setHomeApproved(int homeApproved) {
		this.homeApproved = homeApproved;
	}

	public int getAwayApproved() {
		return awayApproved;
	}

	public void setAwayApproved(int awayApproved) {
		this.awayApproved = awayApproved;
	}

	public int getCommissionerApproved() {
		return commissionerApproved;
	}

	public void setCommissionerApproved(int commissionerApproved) {
		this.commissionerApproved = commissionerApproved;
	}
	
}
