package com.revature.main;

import java.util.List;

import com.revature.beans.Team;
import com.revature.daos.TeamDAO;
import com.revature.daos.TeamDAOImpl;

public class DriverTeresa {

	public static void main(String[] args) {			
		TeamDAO dao = new TeamDAOImpl();
		List<Team> list = dao.selectTeamsByLeague(1);
	}
}
