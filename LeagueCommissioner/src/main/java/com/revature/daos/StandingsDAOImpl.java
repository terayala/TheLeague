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
			session.createSQLQuery("SELECT Teams.Team_ID AS Team_Num," +
				"Teams.Team_Name AS Team," +
				"SUM(Tot.Game_Played) AS Games," +
				"SUM(Tot.Win) AS Wins," +
				"SUM(Tot.Draw) AS Draws," +
				"SUM(Tot.Loss) AS Losses," +
				"" +
				"" +
				"" +
				"" +
				"" +
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