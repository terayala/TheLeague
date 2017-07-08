package com.revature.beans;

import java.sql.Blob;

public class League {

	private int leagueID;
	private String name;
	private Blob logo;
	private int ptsOrPct;
	private int tiesAllowed;
	private int winPts;
	private int tiePts;
	private int winOTPts;
	private int lossOTPts;
	private String sportID;
	
	public League() {
		
	}

	public League(String name, Blob logo, int ptsOrPct, int tiesAllowed, int winPts, int tiePts, int winOTPts,
			int lossOTPts, String sportID) {
		this.name = name;
		this.logo = logo;
		this.ptsOrPct = ptsOrPct;
		this.tiesAllowed = tiesAllowed;
		this.winPts = winPts;
		this.tiePts = tiePts;
		this.winOTPts = winOTPts;
		this.lossOTPts = lossOTPts;
		this.sportID = sportID;
	}

	public int getLeagueID() {
		return leagueID;
	}

	public void setLeagueID(int leagueID) {
		this.leagueID = leagueID;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Blob getLogo() {
		return logo;
	}

	public void setLogo(Blob logo) {
		this.logo = logo;
	}

	public int getPtsOrPct() {
		return ptsOrPct;
	}

	public void setPtsOrPct(int ptsOrPct) {
		this.ptsOrPct = ptsOrPct;
	}

	public int getTiesAllowed() {
		return tiesAllowed;
	}

	public void setTiesAllowed(int tiesAllowed) {
		this.tiesAllowed = tiesAllowed;
	}

	public int getWinPts() {
		return winPts;
	}

	public void setWinPts(int winPts) {
		this.winPts = winPts;
	}

	public int getTiePts() {
		return tiePts;
	}

	public void setTiePts(int tiePts) {
		this.tiePts = tiePts;
	}

	public int getWinOTPts() {
		return winOTPts;
	}

	public void setWinOTPts(int winOTPts) {
		this.winOTPts = winOTPts;
	}

	public int getLossOTPts() {
		return lossOTPts;
	}

	public void setLossOTPts(int lossOTPts) {
		this.lossOTPts = lossOTPts;
	}

	public String getSportID() {
		return sportID;
	}

	public void setSportID(String sportID) {
		this.sportID = sportID;
	}
}
