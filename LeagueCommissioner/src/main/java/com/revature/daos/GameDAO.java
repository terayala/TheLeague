package com.revature.daos;

import java.sql.Timestamp;
import java.util.List;

import com.revature.beans.Game;

public interface GameDAO {

	public List<Game> getScheduleByDate(Timestamp date);
	public List<Game> viewScheduleByTeam(Integer teamID);
	public void updateGame(Game game);
	public void createGame(Game game);
	public Game selectGameById(Integer id);
}
