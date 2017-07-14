package com.revature.daos;

import java.util.List;

import com.revature.beans.Sport;

public interface SportDAO {

	public void createSport(Sport sport);
	public void updateSport(Sport sport);
	public Sport selectSportById(Integer id);
	public List<Sport> selectAllSports();
}
