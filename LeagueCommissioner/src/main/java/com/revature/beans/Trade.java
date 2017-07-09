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
	
	@OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "USER_ID")
	private int player;
	
	@OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "TEAM_ID")
	private int toTeam;
	
	@Column(name = "FROM_TEAM_APPROVAL")
	private int fromTeamApproval;
	
	@Column(name = "TO_TEAM_APPROVAL")
	private int toTeamApproval;
	
	@Column(name = "COMMISSIONER_APPROVAL")
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
