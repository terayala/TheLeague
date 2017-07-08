package com.revature.beans;

public class Stats {

	private int gameID;
	private int playerID;
	private int pointsScored;
	
	public Stats() {
		
	}

	public Stats(int gameID, int playerID, int pointsScored) {
		this.gameID = gameID;
		this.playerID = playerID;
		this.pointsScored = pointsScored;
	}

	public int getGameID() {
		return gameID;
	}

	public void setGameID(int gameID) {
		this.gameID = gameID;
	}

	public int getPlayerID() {
		return playerID;
	}

	public void setPlayerID(int playerID) {
		this.playerID = playerID;
	}

	public int getPointsScored() {
		return pointsScored;
	}

	public void setPointsScored(int pointsScored) {
		this.pointsScored = pointsScored;
	}
}
