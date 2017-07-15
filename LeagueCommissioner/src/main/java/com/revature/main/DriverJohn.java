package com.revature.main;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import com.revature.beans.Game;
import com.revature.daos.GameDAO;
import com.revature.daos.GameDAOImpl;
import com.revature.services.LeagueScheduleService;

public class DriverJohn {

	// The code below is for testing only
	public static void main(String[] args) {
		
		/*FetchLeagueStandingsService f = new FetchLeagueStandingsService();
		
		ArrayList<StandingsPOJO> standings = new ArrayList<StandingsPOJO>();
		
		standings = f.currentStandings(1, 1);
		
		for(int i=0; i < standings.size(); i++) {
			System.out.println(standings.get(i));
		}*/
		
		ArrayList<Integer> teams = new ArrayList<Integer>();
		ArrayList<Timestamp> dates = new ArrayList<Timestamp>();
		ArrayList<Game> games = new ArrayList<Game>();
		DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
		
		GameDAO makeGame = new GameDAOImpl();
		
		for (int i = 16; i < 31; i++) {
			teams.add(i);
		}
		
		try {
			dates.add(new Timestamp(dateFormat.parse("08/01/2017").getTime()));
			dates.add(new Timestamp(dateFormat.parse("08/02/2017").getTime()));
			dates.add(new Timestamp(dateFormat.parse("08/03/2017").getTime()));
			dates.add(new Timestamp(dateFormat.parse("08/04/2017").getTime()));
			dates.add(new Timestamp(dateFormat.parse("08/05/2017").getTime()));
			dates.add(new Timestamp(dateFormat.parse("08/06/2017").getTime()));
			dates.add(new Timestamp(dateFormat.parse("08/07/2017").getTime()));
			dates.add(new Timestamp(dateFormat.parse("08/08/2017").getTime()));
			dates.add(new Timestamp(dateFormat.parse("08/09/2017").getTime()));
			dates.add(new Timestamp(dateFormat.parse("08/10/2017").getTime()));
			dates.add(new Timestamp(dateFormat.parse("08/11/2017").getTime()));
			dates.add(new Timestamp(dateFormat.parse("08/12/2017").getTime()));
			dates.add(new Timestamp(dateFormat.parse("08/13/2017").getTime()));
			dates.add(new Timestamp(dateFormat.parse("08/14/2017").getTime()));
			dates.add(new Timestamp(dateFormat.parse("08/15/2017").getTime()));
			dates.add(new Timestamp(dateFormat.parse("08/16/2017").getTime()));
			dates.add(new Timestamp(dateFormat.parse("08/17/2017").getTime()));
			dates.add(new Timestamp(dateFormat.parse("08/18/2017").getTime()));
			dates.add(new Timestamp(dateFormat.parse("08/19/2017").getTime()));
			dates.add(new Timestamp(dateFormat.parse("08/20/2017").getTime()));
			dates.add(new Timestamp(dateFormat.parse("08/21/2017").getTime()));
			dates.add(new Timestamp(dateFormat.parse("08/22/2017").getTime()));
			dates.add(new Timestamp(dateFormat.parse("08/23/2017").getTime()));
			dates.add(new Timestamp(dateFormat.parse("08/24/2017").getTime()));
			dates.add(new Timestamp(dateFormat.parse("08/25/2017").getTime()));
			dates.add(new Timestamp(dateFormat.parse("08/26/2017").getTime()));
			dates.add(new Timestamp(dateFormat.parse("08/27/2017").getTime()));
			dates.add(new Timestamp(dateFormat.parse("08/28/2017").getTime()));
			dates.add(new Timestamp(dateFormat.parse("08/29/2017").getTime()));
			dates.add(new Timestamp(dateFormat.parse("08/30/2017").getTime()));
		} catch (Exception e) {
			
		}
		
		LeagueScheduleService mls = new LeagueScheduleService();
		games = mls.MakeSchedule(teams, dates);
		
		int numTeams = teams.size();
		int numGames = numTeams * numTeams - numTeams;
		
		/*for (int i = 0; i < numGames; i++) {
			makeGame.createGame(games.get(i));
		}*/

		}
		
//>>>>>>> branch 'master' of https://github.com/terayala/TheLeague.git
	
}
