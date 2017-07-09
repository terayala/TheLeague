package com.revature.daos;

import com.revature.beans.Team;

public interface TeamDAO {
	
	public void createTeam(Team team);
	public void updateTeam(Team team);
	public Team selectTeamById(Integer id);
}
