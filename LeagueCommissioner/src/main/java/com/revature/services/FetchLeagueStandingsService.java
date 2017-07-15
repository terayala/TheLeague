package com.revature.services;

import java.util.ArrayList;

import org.springframework.stereotype.Service;

import com.revature.daos.StandingsDAO;
import com.revature.daos.StandingsDAOImpl;

@Service
public class FetchLeagueStandingsService {

	public ArrayList<StandingsPOJO> currentStandings(int leagueId, int ptsOrPct) {
		
		ArrayList<StandingsPOJO> standings = new ArrayList<StandingsPOJO>();
		StandingsDAO getStandings = new StandingsDAOImpl();
		
		// Dispatch request based on whether points or win pct. is used for the league standings
		// 1 = points, 2 = percent
		if (ptsOrPct == 1) {
			standings = getStandings.fetchStandingsByPoints(leagueId);
		} else {
			standings = getStandings.fetchStandingsByPct(leagueId);
		}
		
		return standings;
		
	}
	
}