package com.revature.beans;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Embeddable;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Embeddable
public class StatsID implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "USER_ID")
	protected User player;
	
	@OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "GAME_ID")
	protected Game game;
	
	public StatsID() {
		
	}

	public int getPlayer() {
		return player.getUserID();
	}

	public void setPlayer(User player) {
		this.player = player;
	}

	public int getGame() {
		return game.getGameID();
	}

	public void setGame(Game game) {
		this.game = game;
	}
}
