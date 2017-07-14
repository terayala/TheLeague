package com.revature.services;

import java.util.List;

import org.springframework.stereotype.Component;

import com.revature.beans.League;
import com.revature.daos.LeagueDAO;
import com.revature.daos.LeagueDAOImpl;

@Component
public class LeagueService {
	public List<League> getAllLeagues() {
		LeagueDAO leagueDao = new LeagueDAOImpl();
		
		return leagueDao.selectAllLeagues();
	}
}
