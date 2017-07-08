package com.revature.beans;

public class Game {

	private int gameID;
	private int homeTeam;
	private int awayTeam;
	private String gameDate;
	private int homeScore;
	private int awayScore;
	private int isOvertime;
	private int homeApproved;
	private int awayApproved;
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
