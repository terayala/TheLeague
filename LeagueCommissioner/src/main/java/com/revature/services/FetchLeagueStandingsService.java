package com.revature.services;

import java.util.ArrayList;

import com.revature.daos.StandingsDAO;
import com.revature.daos.StandingsDAOImpl;

public class FetchLeagueStandingsService {

	public ArrayList<StandingsPOJO> currentStandings(int leagueId, int ptsOrPct) {
		
		ArrayList<StandingsPOJO> standings = new ArrayList<StandingsPOJO>();
		StandingsDAO getStandings = new StandingsDAOImpl();
		
		// Dispatch request based on whether points or win pct. is used for the league standings
		if (ptsOrPct == 1) {
			standings = getStandings.fetchStandingsByPoints(leagueId, standings);
		} else {
			standings = getStandings.fetchStandingsByPct(leagueId, standings);
		}
		
		return standings;
		
	}
	
}