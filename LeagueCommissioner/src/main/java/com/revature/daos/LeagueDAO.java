package com.revature.daos;

import com.revature.beans.League;

public interface LeagueDAO {

	public void createLeague(League league);
	public void updateLeague(League league);
	public League selectLeagueById(Integer id);
}
