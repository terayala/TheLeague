package com.revature.services;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;

import com.revature.beans.Stats;
import com.revature.beans.User;
import com.revature.daos.StatsDAO;
import com.revature.daos.StatsDAOImpl;
import com.revature.daos.UserDAO;
import com.revature.daos.UserDAOImpl;

@Service
public class StatsService {
	public ModelMap readyTables(ModelMap modelMap, HttpSession session) {
		User user = (User) session.getAttribute("user");
		StatsDAO statsDao = new StatsDAOImpl();
		List<Stats> stats = new ArrayList<>();
		List<List<Stats>> statsStats = new ArrayList<>();
		if (user.getRole() == 1) {
			stats = statsDao.selectStatsByPlayerId(user.getUserID());
			modelMap.addAttribute("stats", stats);
		}
		UserDAO usersDao = new UserDAOImpl();
		List<User> users = usersDao.selectUsersByTeam(user.getTeam().getTeamID());

		List<List<String>> aggTable = new ArrayList<>();

		statsStats = statsDao.selectStatsListByPlayers(users);
		
			List<String> nameTemp = new ArrayList<>();
			for (List<Stats> stats2 : statsStats) {
				for (Stats s : stats2) {
					nameTemp = new ArrayList<>();
					nameTemp.add(s.getPlayer().getFirstName() + " " + s.getPlayer().getLastName());
					aggTable.add(nameTemp);
					break;
				}
			}
			if (!aggTable.isEmpty()) {
			int aggNum = 0;
			int i = 0;
			List<String> allTemp = new ArrayList<>();
			for (List<Stats> stats2 : statsStats) {
				if((i) < aggTable.size()) {
					aggNum = 0;
					allTemp = new ArrayList<>();
					for (Stats s : stats2) {
						aggNum += s.getPointsScored();
					}
					allTemp = aggTable.get(i);
					allTemp.add(String.valueOf(aggNum));
					aggTable.set(i, allTemp);
					i++;
				}
			}
		}

		modelMap.addAttribute("aggTable", aggTable);
		
		return modelMap;
	}
}
