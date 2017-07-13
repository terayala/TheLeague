package com.revature.daos;

import java.util.ArrayList;

import com.revature.services.StandingsPOJO;

public interface StandingsDAO {
	
	public ArrayList<StandingsPOJO> fetchStandingsByPoints (int leagueId);
	public ArrayList<StandingsPOJO> fetchStandingsByPct (int leagueId);

}
