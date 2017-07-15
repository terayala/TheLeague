package com.revature.daos;

import java.util.List;

import com.revature.beans.Stats;
import com.revature.beans.User;

public interface StatsDAO {

	public void createStat(Stats stats);
	public void updateStat(Stats stats);
	public List<Stats> selectStatsByPlayerId(Integer playerId);
	public List<List<Stats>> selectStatsListByPlayers(List<User> users);
}
