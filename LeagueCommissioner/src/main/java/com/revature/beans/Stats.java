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
import org.springframework.stereotype.Component;

@Entity
@Table(name = "PLAYER_STATS")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE, region = "myAwesomeCache")
@AssociationOverrides({
	@AssociationOverride(name = "gameID",
		joinColumns = @JoinColumn(name="GAME_ID")),
	@AssociationOverride(name = "userID",
		joinColumns = @JoinColumn(name="PLAYER_ID")) })
@Component
public class Stats {
	
	private StatsID pk = new StatsID();
	
	@Column(name = "POINTS_SCORED")
	private int pointsScored;
	
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
	 public Game getGame() {
	 	return getPk().getGame();
	}
	
	public void setGame(Game game) {
		 getPk().setGame(game);
	}
	
	@Transient
	 public User getUser() {
	 	return getPk().getPlayer();
	}
	
	public void setUser(User player) {
		 getPk().setPlayer(player);
	}

	public int getPointsScored() {
		return pointsScored;
	}

	public void setPointsScored(int pointsScored) {
		this.pointsScored = pointsScored;
	}
}
