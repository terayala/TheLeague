package com.revature.daos;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.hibernate.Criteria;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.revature.services.StandingsPOJO;
import com.revature.util.HibernateUtil;

public class StandingsDAOImpl implements StandingsDAO {
	
	/*
	 * Access the stored SQL function that sorts the table by points
	 */
	public ArrayList<StandingsPOJO> fetchStandingsByPoints (int leagueId) {
		
		ArrayList<StandingsPOJO> standings = new ArrayList<StandingsPOJO>();
		Session session = HibernateUtil.getSession();
		Transaction tx = session.beginTransaction();
		
		int ppw, ppt, ppow, ppol;
		/*
		 * TO DO: Get the league info from the session
		 */
		ppw = 3;ppt = 1; ppow = 0; ppol = 0; // <---- TEMPORARY
		
		/*
		 * The following will create a SQL query to query the database for the
		 * league standings
		 */
		SQLQuery query =
			session.createSQLQuery("SELECT Teams.Team_ID AS Team_Num, " +
				"Teams.Team_Name AS Team, " +
				"SUM(Tot.GP) AS Games, " +
				"SUM(Tot.Win) AS Wins, " +
				"SUM(Tot.Draw) AS Draws, " +
				"SUM(Tot.Loss) AS Losses, " +
				"SUM(Tot.OT_Win) AS OT_Wins, " +
				"SUM(Tot.OT_Loss) AS OT_Loss, " +
				"SUM(Tot.Goals_For) AS Goals_For, " +
				"SUM(Tot.Goals_Allowed) AS Goals_Allowed, " +
				"SUM(Tot.Goal_Diff) AS Goal_Differential, " +
				"SUM(Tot.Pts) AS Points " +
				
				"FROM (SELECT Home_Team Team, " +
				"CASE WHEN Home_Score IS NOT NULL THEN 1 ELSE 0 END GP, " +
				"CASE WHEN Home_Score > Away_Score AND Is_Overtime = 0 THEN 1 ELSE 0 END Win, " +
				"CASE WHEN Home_Score = Away_Score THEN 1 ELSE 0 END Draw, " +
				"CASE WHEN Home_Score < Away_Score AND Is_Overtime = 0 THEN 1 ELSE 0 END Loss, " +
				"CASE WHEN Home_Score > Away_Score AND Is_Overtime = 1 THEN 1 ELSE 0 END OT_Win, " +
				"CASE WHEN Home_Score < Away_Score AND Is_Overtime = 1 THEN 1 ELSE 0 END OT_Loss, " +
				"Home_Score Goals_For, " +
				"Away_Score Goals_Allowed, " +
				"(Home_Score - Games.Away_Score) Goal_Diff, " +
				"CASE WHEN Home_Score > Away_Score AND Is_Overtime = 0 THEN " + ppw +
				" WHEN Home_Score = Away_Score THEN " + ppt +
				" WHEN Home_Score > Away_Score AND Is_Overtime = 1 THEN " + ppow +
				" WHEN Home_Score < Away_Score AND Is_Overtime = 0 THEN 0 " +
				"ELSE " + ppol + " END Pts FROM Games UNION ALL SELECT Away_Team, " +
				"CASE WHEN Home_Score IS NOT NULL THEN 1 ELSE 0 END, " +
				"CASE WHEN Home_Score < Away_Score AND Is_Overtime = 0 THEN 1 ELSE 0 END, " +
				"CASE WHEN Home_Score = Away_Score THEN 1 ELSE 0 END, " +
				"CASE WHEN Home_Score > Away_Score AND Is_Overtime = 0 THEN 1 ELSE 0 END, " +
				"CASE WHEN Home_Score < Away_Score AND Is_Overtime = 1 THEN 1 ELSE 0 END, " +
				"CASE WHEN Home_Score > Away_Score AND Is_Overtime = 1 THEN 1 ELSE 0 END, " +
				"Away_Score, Home_Score, (Away_Score - Home_Score), " +
				"CASE WHEN Home_Score < Away_Score AND Is_Overtime = 0 THEN " + ppw +
				" WHEN Home_Score = Away_Score THEN " + ppt +
				" WHEN Home_Score < Away_Score AND Is_Overtime = 1 THEN " + ppow +
				" WHEN Home_Score > Away_Score AND Is_Overtime = 0 THEN 0 " +
				"ELSE " + ppol + " END FROM Games) Tot " +
				"INNER JOIN Teams ON Tot.Team = Teams.Team_ID " +
				"WHERE Teams.League_ID = " + leagueId + " " +
				"GROUP BY Teams.Team_ID, Team_Name " +
				"ORDER BY Points DESC, Goal_Differential DESC, Goals_For DESC"
			);
		
		query.setResultTransformer(Criteria.ALIAS_TO_ENTITY_MAP);
		//query.addEntity(StandingsPOJO.class);
        
        List s = query.list();
        
        for(Object object : s)
        {
        	StandingsPOJO standingsRow = new StandingsPOJO();
        	String string = object.toString();
        	String[] parts = string.split(", ");
        	
        	int teamId = Integer.parseInt(parts[1].split("=")[1]);
        	String teamName = parts[7].split("=")[1];
        	int played = Integer.parseInt(parts[3].split("=")[1]);
        	int wins = Integer.parseInt(parts[11].split("=")[1].substring(0, parts[11].split("=")[1].length() - 1));
        	int draws = Integer.parseInt(parts[8].split("=")[1]);
        	int losses = Integer.parseInt(parts[2].split("=")[1]);
        	int otWins = Integer.parseInt(parts[4].split("=")[1]);
        	int otLosses = Integer.parseInt(parts[9].split("=")[1]);
        	int gf = Integer.parseInt(parts[0].split("=")[1]);
        	int ga = Integer.parseInt(parts[6].split("=")[1]);
        	int gd = Integer.parseInt(parts[5].split("=")[1]);
        	int pts = Integer.parseInt(parts[10].split("=")[1]);
        	
        	standingsRow.setTeamId(teamId);
        	standingsRow.setTeamName(teamName);
        	standingsRow.setPlayed(played);
        	standingsRow.setWins(wins);
        	standingsRow.setDraws(draws);
        	standingsRow.setLosses(losses);
        	standingsRow.setOtWins(otWins);
        	standingsRow.setOtLosses(otLosses);
        	standingsRow.setGoalsFor(gf);
        	standingsRow.setGoalsAllowed(ga);
        	standingsRow.setGoalDiff(gd);
        	standingsRow.setPtsPct(pts);
        	
        	standings.add(standingsRow);
        }

		return standings;
		
	};
	
	/*
	 * Access the stored SQL function that sorts the table by win percentage
	 */
	public ArrayList<StandingsPOJO> fetchStandingsByPct (int leagueId) {
		
		ArrayList<StandingsPOJO> standings = new ArrayList<StandingsPOJO>();
		
		return standings;
		
	};

}