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
@Table(name = "TRADES")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE, region = "myAwesomeCache")
public class Trade {

	@Id
	@Column(name = "TRADE_ID")
	@SequenceGenerator(name = "TRADEID_SEQ", sequenceName = "TRADEID_SEQ")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "TRADEID_SEQ")
	private int tradeID;
	
	@OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name="TRADED_PLAYER",referencedColumnName = "USER_ID")
	private User player;
	
	@OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name="TRADED_TO",referencedColumnName = "TEAM_ID")
	private Team toTeam;
	
	@Column(name = "FROM_TEAM_APPROVAL")
	private int fromTeamApproval;
	
	@Column(name = "TO_TEAM_APPROVAL")
	private int toTeamApproval;
	
	@Column(name = "COMMISSIONER_APPROVAL")
	private int commissionerApproval;
	
	public Trade() {
		
	}

	public Trade(User player, Team toTeam, int fromTeamApproval, int toTeamApproval, int commissionerApproval) {
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
		return player.getUserID();
	}

	public void setPlayer(User player) {
		this.player = player;
	}

	public int getToTeam() {
		return toTeam.getTeamID();
	}

	public void setToTeam(Team toTeam) {
		this.toTeam = toTeam;
	}

	public boolean getFromTeamApproval() {
		if (fromTeamApproval == 0) {
			return false;
		} else {
			return true;
		}
	}

	public void setFromTeamApproval(int fromTeamApproval) {
		this.fromTeamApproval = fromTeamApproval;
	}

	public boolean getToTeamApproval() {
		if (toTeamApproval == 0) {
			return false;
		} else {
			return true;
		}
	}

	public void setToTeamApproval(int toTeamApproval) {
		this.toTeamApproval = toTeamApproval;
	}

	public boolean getCommissionerApproval() {
		if (commissionerApproval == 0) {
			return false;
		} else {
			return true;
		}
	}

	public void setCommissionerApproval(int commissionerApproval) {
		this.commissionerApproval = commissionerApproval;
	}

	@Override
	public String toString() {
		return "Trade [tradeID=" + tradeID + ", player=" + player + ", toTeam=" + toTeam + ", fromTeamApproval="
				+ fromTeamApproval + ", toTeamApproval=" + toTeamApproval + ", commissionerApproval="
				+ commissionerApproval + "]";
	}
}
