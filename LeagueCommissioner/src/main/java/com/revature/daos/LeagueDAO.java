package com.revature.daos;

import java.util.List;

import com.revature.beans.League;

public interface LeagueDAO {

	public Integer createLeague(League league);
	public void updateLeague(League league);
	public League selectLeagueById(Integer id);
	public List<League> selectAllLeagues();
}
