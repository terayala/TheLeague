package com.revature.daos;

import static org.junit.Assert.assertEquals;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.junit.Test;

import com.revature.beans.Game;
import com.revature.beans.League;
import com.revature.beans.Team;

public class TestGameDAO {
	
	GameDAOImpl gameDao = new GameDAOImpl();
	TeamDAOImpl teamDao = new TeamDAOImpl();
	LeagueDAOImpl leagueDao = new LeagueDAOImpl();

	
/*	@Test
	public void testCreateGame() throws ParseException {
		SportDAO sportDao = new SportDAOImpl();
		DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy H:mm:ss");
		League league = new League("junit1234", 1, 1, 3, 1, 0, 0, sportDao.selectSportById(1));
		Team team1 = new Team("junit123", "junit123", league, 123123, 123123);
		Team team2 = new Team("junit123456", "junit123456", league, 123123, 123123);
		Game game = new Game(team1, team2, new Timestamp(dateFormat.parse("08/01/2017 18:00:00").getTime()));
		gameDao.createGame(game);
		
		assertEquals("junit123", game.getHomeTeam().getName());
		assertEquals("junit123456", game.getAwayTeam().getName());
		gameDao.deleteGame(game);
		teamDao.deleteTeam(team2);
		teamDao.deleteTeam(team1);
		leagueDao.deleteLeague(league);
		
		
		
	}*/
}
