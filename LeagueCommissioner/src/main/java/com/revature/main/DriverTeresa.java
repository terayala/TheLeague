package com.revature.main;

import com.revature.beans.League;
import com.revature.daos.LeagueDAO;
import com.revature.daos.LeagueDAOImpl;

public class DriverTeresa {

	public static void main(String[] args) {			
		LeagueDAO dao = new LeagueDAOImpl();
		League league = dao.selectLeagueById(new Integer(1));
		System.out.println(league.toString());
	}
}
