package com.revature.beans;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Entity
@Table(name = "PLAYER_STATS", indexes = {
        @Index(name = "STATS_PK", columnList = "STATS_PK")})
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE, region = "myAwesomeCache")
@Component
public class Stats {
	@Id
	@Column(name="STATS_PK")
	private int STATS_PK;
	
	@OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
 	@JoinColumn(name="PLAYER_ID", referencedColumnName="USER_ID")
	@Autowired
 	protected User player;
 	
 	@OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
 	@JoinColumn(name="GAME_ID", referencedColumnName="GAME_ID")
 	@Autowired
 	protected Game game;
 	
	@Column(name = "POINTS_SCORED")
	private int pointsScored;
	
	public Stats() {
		
	}

	public int getSTATS_PK() {
		return STATS_PK;
	}

	public void setSTATS_PK(int sTATS_PK) {
		STATS_PK = sTATS_PK;
	}

	public User getPlayer() {
		return player;
	}

	public void setPlayer(User player) {
		this.player = player;
	}

	public Game getGame() {
		return game;
	}

	public void setGame(Game game) {
		this.game = game;
	}

	public int getPointsScored() {
		return pointsScored;
	}

	public void setPointsScored(int pointsScored) {
		this.pointsScored = pointsScored;
	}

	@Override
	public String toString() {
		return "Stats [STATS_PK=" + STATS_PK + ", player=" + player + ", game=" + game + ", pointsScored="
				+ pointsScored + "]";
	}
}
