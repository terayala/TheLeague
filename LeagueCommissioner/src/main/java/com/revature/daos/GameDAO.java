package com.revature.daos;

import java.util.List;

import com.revature.beans.Game;

public interface GameDAO {

	public List<Game> viewScheduleByTeam(Integer teamID);
	public void updateGame(Game game);
	public void createGame(Game game);
}
