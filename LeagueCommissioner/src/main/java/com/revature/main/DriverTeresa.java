package com.revature.main;

import com.revature.beans.League;
import com.revature.daos.LeagueDAO;
import com.revature.daos.LeagueDAOImpl;

public class DriverTeresa {

	public static void main(String[] args) {
		/*GameDAO dao = new GameDAOImpl();
		List<Game> games = dao.viewScheduleByTeam(new Integer(5));
		for (Game g : games) {
			System.out.println(g.toString());
		}*/
		LeagueDAO dao = new LeagueDAOImpl();
		League league = dao.selectLeagueById(new Integer(2));
		System.out.println(league.getName() + " " + league.getSportID());
	}
}
