package com.revature.daos;

import java.util.ArrayList;

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
				
				"FROM (SELECT Home_Team Team," +
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
				"ELSE " + ppol + " END Pts FROM Games UNION ALL SELECT" +
				"" +
				"" +
				"" +
				"" +
				"" +
				"" +
				""
			);

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