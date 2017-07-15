package com.revature.daos;

import java.util.List;

import com.revature.beans.Game;
import com.revature.beans.Team;

public interface GameDAO {

	public List<Game> getScheduleByLeague(List<Team> teams);
	public List<Game> viewScheduleByTeam(Integer teamId);
	public void updateGame(Game game);
	public void createGame(Game game);
	public Game selectGameById(Integer id);
}
