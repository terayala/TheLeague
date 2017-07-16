package com.revature.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.revature.beans.Game;
import com.revature.beans.League;
import com.revature.beans.Team;
import com.revature.beans.User;
import com.revature.daos.GameDAO;
import com.revature.daos.GameDAOImpl;
import com.revature.daos.TeamDAO;
import com.revature.daos.TeamDAOImpl;

@Service
public class SchedulePageService {

	public List<Game> getGames(User user, League league) {
		TeamDAO teamDAO = new TeamDAOImpl();
		GameDAO gameDAO = new GameDAOImpl();
		List<Game> list = null;
		if (user.getRole() == 3) {
			List<Team> teams = teamDAO.selectTeamsByLeague(league.getLeagueID());
			list = gameDAO.getScheduleByLeague(teams);
		} else {
			list = gameDAO.viewScheduleByTeam(user.getTeam().getTeamID());
		}
		return list;
	}
}
