package com.revature.daos;

import java.util.ArrayList;

import com.revature.services.StandingsPOJO;

public interface StandingsDAO {
	
	public ArrayList<StandingsPOJO> fetchStandingsByPoints (int leagueId, ArrayList<StandingsPOJO> standings);
	public ArrayList<StandingsPOJO> fetchStandingsByPct (int leagueId, ArrayList<StandingsPOJO> standings);

}
