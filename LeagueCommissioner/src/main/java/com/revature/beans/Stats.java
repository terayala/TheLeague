package com.revature.beans;

import javax.persistence.AssociationOverride;
import javax.persistence.AssociationOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

@Entity
@Table(name = "PLAYER_STATS")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE, region = "myAwesomeCache")
@AssociationOverrides({
		@AssociationOverride(name = "pk.gameID",
			joinColumns = @JoinColumn(referencedColumnName = "GAME_ID")),
		@AssociationOverride(name = "pk.playerID",
			joinColumns = @JoinColumn(referencedColumnName = "PLAYER_ID")) })
public class Stats {
	
	private StatsID pk = new StatsID();
	
	@Column(name = "POINTS_SCORED")
	private int POINTS_SCORED;
	
	public Stats() {
		
	}
	
	@EmbeddedId
	public StatsID getPk() {
		return pk;
	}
	
	public void setPk(StatsID pk) {
		this.pk = pk;
	}

	@Transient
	public int getGame() {
		return getPk().getGame();
	}

	public void setGame(Game game) {
		getPk().setGame(game);
	}

	@Transient
	public int getUser() {
		return getPk().getPlayer();
	}

	public void setUser(User player) {
		getPk().setPlayer(player);;
	}
	
	public int getPointsScored() {
		return POINTS_SCORED;
	}

	public void setPointsScored(int pointsScored) {
		this.POINTS_SCORED = pointsScored;
	}

	@Override
	public String toString() {
		return "Stats [game_id=" + pk.getGame() + ", player_id=" + pk.getPlayer() + ", pointsScored=" + POINTS_SCORED + "]";
	}
	
	
}
