package com.revature.beans;

public class Trade {

	private int tradeID;
	private int player;
	private int toTeam;
	private int fromTeamApproval;
	private int toTeamApproval;
	private int commissionerApproval;
	
	public Trade() {
		
	}

	public Trade(int player, int toTeam, int fromTeamApproval, int toTeamApproval, int commissionerApproval) {
		this.player = player;
		this.toTeam = toTeam;
		this.fromTeamApproval = fromTeamApproval;
		this.toTeamApproval = toTeamApproval;
		this.commissionerApproval = commissionerApproval;
	}

	public int getTradeID() {
		return tradeID;
	}

	public void setTradeID(int tradeID) {
		this.tradeID = tradeID;
	}

	public int getPlayer() {
		return player;
	}

	public void setPlayer(int player) {
		this.player = player;
	}

	public int getToTeam() {
		return toTeam;
	}

	public void setToTeam(int toTeam) {
		this.toTeam = toTeam;
	}

	public int getFromTeamApproval() {
		return fromTeamApproval;
	}

	public void setFromTeamApproval(int fromTeamApproval) {
		this.fromTeamApproval = fromTeamApproval;
	}

	public int getToTeamApproval() {
		return toTeamApproval;
	}

	public void setToTeamApproval(int toTeamApproval) {
		this.toTeamApproval = toTeamApproval;
	}

	public int getCommissionerApproval() {
		return commissionerApproval;
	}

	public void setCommissionerApproval(int commissionerApproval) {
		this.commissionerApproval = commissionerApproval;
	}
}
