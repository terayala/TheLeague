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
@Table(name = "LEAGUES")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE, region = "myAwesomeCache")
public class League {
	
	@Id
	@Column(name = "LEAGUE_ID")
	@SequenceGenerator(name = "LEAGUEID_SEQ", sequenceName = "LEAGUEID_SEQ")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "LEAGUEID_SEQ")
	private int leagueID;
	
	@Column(name = "NAME")
	private String name;
	
	@Column(name = "PTS_OR_PCT")
	private int ptsOrPct;
	
	@Column(name = "TIES_ALLOWED")
	private int tiesAllowed;
	
	@Column(name = "PTS_PER_WIN")
	private int winPts;
	
	@Column(name = "PTS_PER_TIE")
	private int tiePts;
	
	@Column(name = "PTS_PER_OT_WIN")
	private int winOTPts;
	
	@Column(name = "PTS_PER_OT_LOSS")
	private int lossOTPts;
	
	@OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name="SPORT_ID", referencedColumnName = "SPORT_ID")
	private Sport sport_id;

	public League() {
		
	}

	public League(String name, int ptsOrPct, int tiesAllowed, int winPts, int tiePts, int winOTPts,
			int lossOTPts, Sport sportID) {
		this.name = name;
		this.ptsOrPct = ptsOrPct;
		this.tiesAllowed = tiesAllowed;
		this.winPts = winPts;
		this.tiePts = tiePts;
		this.winOTPts = winOTPts;
		this.lossOTPts = lossOTPts;
		this.sport_id = sportID;
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

	public int getPtsOrPct() {
		return ptsOrPct;
	}

	public void setPtsOrPct(int ptsOrPct) {
		this.ptsOrPct = ptsOrPct;
	}

	public boolean getTiesAllowed() {
		if (tiesAllowed == 0) {
			return false;
		} else {
			return true;
		}
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
		return sport_id.getName();
	}

	public void setSportID(Sport sportID) {
		this.sport_id = sportID;
	}

	@Override
	public String toString() {
		return "League [leagueID=" + leagueID + ", name=" + name + ", ptsOrPct=" + ptsOrPct + ", tiesAllowed="
				+ tiesAllowed + ", winPts=" + winPts + ", tiePts=" + tiePts + ", winOTPts=" + winOTPts + ", lossOTPts="
				+ lossOTPts + ", sportID=" + sport_id + "]";
	}
}
