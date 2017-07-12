package com.revature.daos;

import java.util.ArrayList;

import com.revature.beans.League;
import com.revature.services.StandingsPOJO;

public interface LeagueDAO {

	public void createLeague(League league);
	public void updateLeague(League league);
	public League selectLeagueById(Integer id);
	public ArrayList<StandingsPOJO> fetchStandingsByPoints (int leagueId, ArrayList<StandingsPOJO> standings);
	public ArrayList<StandingsPOJO> fetchStandingsByPct (int leagueId, ArrayList<StandingsPOJO> standings);
}
