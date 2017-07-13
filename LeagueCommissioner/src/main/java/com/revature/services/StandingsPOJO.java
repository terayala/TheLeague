package com.revature.services;

public class StandingsPOJO {

	private int teamId;
	private String teamName;
	private int wins;
	private int draws;
	private int losses;
	private int otWins;
	private int otLosses;
	private int goalsFor;
	private int goalsAllowed;
	private int goalDiff;
	private int ptsPct;
	
	// No-args constructor
	public StandingsPOJO() {
		
	}
	
	// This constructor will pass in all of the fields
	public StandingsPOJO(int teamId, String teamName, int wins, int draws, int losses, int otWins, int otLosses,
			int goalsFor, int goalsAllowed, int goalDiff, int ptsPct) {
		super();
		this.teamId = teamId;
		this.teamName = teamName;
		this.wins = wins;
		this.draws = draws;
		this.losses = losses;
		this.otWins = otWins;
		this.otLosses = otLosses;
		this.goalsFor = goalsFor;
		this.goalsAllowed = goalsAllowed;
		this.goalDiff = goalDiff;
		this.ptsPct = ptsPct;
	}

	// This constructor will pass in all of the fields except for OT Wins and Losses
	public StandingsPOJO(int teamId, String teamName, int wins, int draws, int losses, int goalsFor, int goalsAllowed,
			int goalDiff, int ptsPct) {
		super();
		this.teamId = teamId;
		this.teamName = teamName;
		this.wins = wins;
		this.draws = draws;
		this.losses = losses;
		this.goalsFor = goalsFor;
		this.goalsAllowed = goalsAllowed;
		this.goalDiff = goalDiff;
		this.ptsPct = ptsPct;
	}

	public int getTeamId() {
		return teamId;
	}
	public void setTeamId(int teamId) {
		this.teamId = teamId;
	}
	public String getTeamName() {
		return teamName;
	}
	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}
	public int getWins() {
		return wins;
	}
	public void setWins(int wins) {
		this.wins = wins;
	}
	public int getDraws() {
		return draws;
	}
	public void setDraws(int draws) {
		this.draws = draws;
	}
	public int getLosses() {
		return losses;
	}
	public void setLosses(int losses) {
		this.losses = losses;
	}
	public int getOtWins() {
		return otWins;
	}
	public void setOtWins(int otWins) {
		this.otWins = otWins;
	}
	public int getOtLosses() {
		return otLosses;
	}
	public void setOtLosses(int otLosses) {
		this.otLosses = otLosses;
	}
	public int getGoalsFor() {
		return goalsFor;
	}
	public void setGoalsFor(int goalsFor) {
		this.goalsFor = goalsFor;
	}
	public int getGoalsAllowed() {
		return goalsAllowed;
	}
	public void setGoalsAllowed(int goalsAllowed) {
		this.goalsAllowed = goalsAllowed;
	}
	public int getGoalDiff() {
		return goalDiff;
	}
	public void setGoalDiff(int goalDiff) {
		this.goalDiff = goalDiff;
	}
	public int getPtsPct() {
		return ptsPct;
	}
	public void setPtsPct(int ptsPct) {
		this.ptsPct = ptsPct;
	}

	@Override
	public String toString() {
		return teamName + "  W:" + wins + " D:" + draws
				+ " L:" + losses + "  OTW:" + otWins + "  OTL:" + otLosses + "  GF:" + goalsFor
				+ "  GA:" + goalsAllowed + "  GD:" + goalDiff + "  Pts:" + ptsPct;
	}
	
}
