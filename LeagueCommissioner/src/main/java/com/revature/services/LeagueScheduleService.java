package com.revature.services;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Collections;

import org.springframework.stereotype.Component;

import com.revature.beans.Game;
import com.revature.beans.Team;
import com.revature.daos.TeamDAO;
import com.revature.daos.TeamDAOImpl;

@Component
public class LeagueScheduleService {
	
	public LeagueScheduleService() {
		
	}

	public ArrayList<Game> MakeSchedule(ArrayList<Integer> teams, ArrayList<Timestamp> dates) {
		
		/*
		 * Declare an ArrayList that will hold all of the games.  This is the array that
		 * will be returned to whatever called this method.
		 */
		ArrayList<Game> games = new ArrayList<Game>();
		
		// Declare an object that will hold the home and away teams for one match
		Team homeTeam = new Team();
		Team awayTeam = new Team();
		
		// Declare a variable that will be the number of teams to schedule
		int numberOfTeams = teams.size();
		
		// Declare an integer that will hold one of the values when looping
		int freeze;
		int loopRows;
		int rounds;
		
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

        TeamDAO getTeam = new TeamDAOImpl();
        for (int i = 0; i < numberOfTeams; i++) {
        	teamAssignment.add(getTeam.selectTeamById(teamShuffle.get(i)));
        }
        
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
			loopRows = (numberOfTeams + 1) / 2;
			rounds = numberOfTeams;
			
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
				for (int looper = 0; looper < loopRows - 1; looper++) {
					
					// Declare an object that will hold one game at a time
					Game gameEntry = new Game();
					Game gameEntryReturn = new Game();
					
					if (round % 2 == 0) {
						homeTeam = teamAssignment.get(schedLoop[0][looper]);
						awayTeam = teamAssignment.get(schedLoop[1][looper]);
					} else {
						homeTeam = teamAssignment.get(schedLoop[1][looper]);
						awayTeam = teamAssignment.get(schedLoop[0][looper]);
					}
					
					// This will add the match
					gameEntry.setHomeTeam(homeTeam);
					gameEntry.setAwayTeam(awayTeam);
					gameEntry.setGameDate(dates.get(round));
					
					games.add(gameEntry);
					
					// This will add the return match
					gameEntryReturn.setHomeTeam(awayTeam);
					gameEntryReturn.setAwayTeam(homeTeam);
					gameEntryReturn.setGameDate(dates.get(round + (numberOfTeams - 1)));
					
					games.add(gameEntryReturn);
					
					// The following will rotate the teams in the loop
					freeze = schedLoop[0][0];
					for (int i = 0; i < numberOfTeams - 1; i++) {
						int xCoord = Math.floorDiv(i, loopRows);
						int yCoord = i - xCoord * loopRows;
						
						int xCoord2 = Math.floorDiv(i + 1, loopRows);
						int yCoord2 = (i + 1) - xCoord2 * loopRows;
						
						schedLoop[xCoord][yCoord] = schedLoop[xCoord2][yCoord2];
						
					}
					schedLoop[1][loopRows - 2] = freeze;
					
				}
			}
			
			// This is the end of the code used if the number of teams is odd
			/////////////////////////////////////////////////////////////////
		} else {
			/////////////////////////////////////////////////////////////////
			// The following code will execute if the number of teams is even
			
			// This will create the number of rows for the looper that will
			// hold all of the team numbers
			loopRows = numberOfTeams / 2;
			rounds = numberOfTeams - 1;
			
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
					
					// Declare an object that will hold one game at a time
					Game gameEntry = new Game();
					Game gameEntryReturn = new Game();
					
					if (round % 2 == 0) {
						homeTeam = teamAssignment.get(schedLoop[0][looper]);
						awayTeam = teamAssignment.get(schedLoop[1][looper]);
					} else {
						homeTeam = teamAssignment.get(schedLoop[1][looper]);
						awayTeam = teamAssignment.get(schedLoop[0][looper]);
					}
					
					// This will add the match
					gameEntry.setHomeTeam(homeTeam);
					gameEntry.setAwayTeam(awayTeam);
					gameEntry.setGameDate(dates.get(round - 1));
					
					games.add(gameEntry);
					
					// This will add the return match
					gameEntryReturn.setHomeTeam(awayTeam);
					gameEntryReturn.setAwayTeam(homeTeam);
					gameEntryReturn.setGameDate(dates.get(round + (numberOfTeams - 2)));
					
					games.add(gameEntryReturn);
					
				}
				
				// The following will rotate the teams in the loop
				freeze = schedLoop[0][1];
				for (int i = 1; i < numberOfTeams - 1; i++) {
					int xCoord = Math.floorDiv(i, loopRows);
					int yCoord, yCoord2;
					if (xCoord == 0) {
						yCoord = i;
					} else {
						yCoord = (numberOfTeams) - (i + 1);
					}
					
					int xCoord2 = Math.floorDiv(i + 1, loopRows);
					if (xCoord2 == 0 && i < (numberOfTeams - 1)) {
						yCoord2 = i + 1;
					} else if (i == ((numberOfTeams / 2) - 1)) {
						yCoord2 = i;
					} else {
						yCoord2 = (numberOfTeams) - (i + 2);
					}
					
					schedLoop[xCoord][yCoord] = schedLoop[xCoord2][yCoord2];
					
				}
				schedLoop[1][0] = freeze;
				
			}
			
			// This is the end of the code used if the number of teams is even
			//////////////////////////////////////////////////////////////////
		}
		
		return games;
	}
	
}
