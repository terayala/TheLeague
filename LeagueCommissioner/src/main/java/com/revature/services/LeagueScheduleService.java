package com.revature.services;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;

import com.revature.beans.Game;
import com.revature.beans.Team;

public class LeagueScheduleService {

	public ArrayList<Game> MakeSchedule(ArrayList<Integer> teams, ArrayList<Timestamp> dates) {
		
		/*
		 * Declare an ArrayList that will hold all of the games.  This is the array that
		 * will be returned to whatever called this method.
		 */
		ArrayList<Game> games = new ArrayList<Game>();
		
		// Declare an object that will hold one game at a time
		Game gameEntry = new Game();
		
		// Declare a variable that will be the number of teams to schedule
		int numberOfTeams = teams.size();
		
		// Declare a team array that will store each team that will be scheduled.
		ArrayList<Team> teamAssignment = new ArrayList<Team>();
		
		// Create a variable that will store the number of rows in the table
		// NOTE: The actual number of rows in the final table will be twice
		// 		this number.  This number only stores half of the schedule.
		//		This is because this number will be used to create the second
		//		half of the schedule with the return matches.
		int numberOfRows = (numberOfTeams * numberOfTeams - numberOfTeams) / 2;
		
		/*
		 * The following will shuffle the list of teams that will be used,
		 * then query the database to assign Team objects to the teamAssignment ArrayList
		 */
		ArrayList<Integer> teamShuffle = new ArrayList<Integer>();
        for (int i = 0; i < numberOfTeams; i++) {
            teamShuffle.add(new Integer(teams.get(i)));
        }
        Collections.shuffle(teamShuffle);
        
        
        
        /*
         * The following loop will fetch the team objects from the database and
         * assign them to team objects.
         */
        
        // The following if statement will determine which scheduling method will be used
		if (numberOfTeams % 2 == 1) {
			////////////////////////////////////////////////////////////////
			// The following code will execute if the number of teams is odd
			
			// This will create the number of rows for the looper that will
			// hold all of the team numbers
			int loopRows = (numberOfTeams + 1) / 2;
			
			// This will create the loop with numbers 1..n where n is the number of teams
			int schedLoop[][] = new int[2][loopRows];
			for (int i = 0; i < loopRows; i++) {
				schedLoop[0][i] = i * 2;
				if(i < (loopRows - 1)) {
					schedLoop[1][i] = i * 2 + 1;
				}
			}
			
			// The following loop will create the first half of the season
			// by looping as many times as there are teams 
			for (int round = 0; round < numberOfTeams; round++) {
				
				// The following loop will create one round of games
				for (int looper = 0; looper < loopRows; looper++) {
					
				}
			}
			
			// This is the end of the code used if the number of teams is odd
			/////////////////////////////////////////////////////////////////
		} else {
			/////////////////////////////////////////////////////////////////
			// The following code will execute if the number of teams is even
			
			// This will create the number of rows for the looper that will
			// hold all of the team numbers
			int loopRows = numberOfTeams / 2;
			
			// This will create the loop with numbers 1..n where n is the number of teams
			int schedLoop[][] = new int[2][loopRows];
			for (int i = 0; i < loopRows; i++) {
				schedLoop[0][i] = i * 2;
				schedLoop[1][i] = i * 2 + 1;
			}
			
			// The following loop will create the first half of the season
			// by looping one less than the number of times 
			for (int round = 1; round < numberOfTeams; round++) {
				
				// The following loop will create one round of games
				for (int looper = 0; looper < loopRows; looper++) {
					System.out.println("Round:" + round + "  Game:" + looper + "  Date:" + dates.get(round - 1));
					
					
				}
			}
			
			// This is the end of the code used if the number of teams is even
			//////////////////////////////////////////////////////////////////
		}
		
		return games;
	}
	
	
	// The code below is for testing only
	public static void main(String[] args) {
		ArrayList<Integer> teams = new ArrayList<Integer>();
		ArrayList<Timestamp> dates = new ArrayList<Timestamp>();
		ArrayList<Game> games = new ArrayList<Game>();
		DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
		
		for (int i = 1; i < 17; i++) {
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
		
	}
	
}
