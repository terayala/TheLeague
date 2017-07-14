package com.revature.daos;

import java.util.List;

import com.revature.beans.Stats;

public interface StatsDAO {

	public void createStat(Stats stats);
	public void updateStat(Stats stats);
	public List<Stats> selectStatsByPlayerId(int playerId);
}
