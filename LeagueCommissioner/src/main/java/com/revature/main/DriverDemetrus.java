package com.revature.main;



import com.revature.beans.Team;

import com.revature.daos.TeamDAOImpl;


public class DriverDemetrus {

	public static void main(String[] args) {
		TeamDAOImpl td = new TeamDAOImpl();
		Team t= new Team();
		t=td.selectTeamById(3);
		System.out.println("****************t**********************: " + t.toString());

	}

}
