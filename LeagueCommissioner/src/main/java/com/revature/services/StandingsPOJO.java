package com.revature.services;

import javax.persistence.Column;

import org.hibernate.annotations.Entity;

@Entity
public class StandingsPOJO {

	@Column(name="teamId")
	private int teamId;
	@Column(name="teamName")
	private String teamName;
	@Column(name="wins")
	private int wins;
	@Column(name="draws")
	private int draws;
	@Column(name="losses")
	private int losses;
	@Column(name="otWins")
	private int otWins;
	@Column(name="otLosses")
	private int otLosses;
	@Column(name="goalsFor")
	private int goalsFor;
	@Column(name="goalsAllowed")
	private int goalsAllowed;
	@Column(name="goalDiff")
	private int goalDiff;
	@Column(name="ptsPct")
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
	
	
}
