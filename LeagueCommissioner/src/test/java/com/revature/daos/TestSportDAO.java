package com.revature.daos;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.revature.beans.Sport;

public class TestSportDAO {
	
	SportDAOImpl sportDao = new SportDAOImpl();
	
	@Test
	public void testCreateUser() {
		Sport sport = new Sport("This Is A Sport");
		//sportDao.createSport(sport);
		assertEquals("This Is A Sport", sport.getName());
		//sportDao.deleteSport(sport);
	}
}
