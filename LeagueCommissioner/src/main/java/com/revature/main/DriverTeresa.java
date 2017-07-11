package com.revature.main;

import com.revature.beans.Stats;
import com.revature.daos.StatsDAO;
import com.revature.daos.StatsDAOImpl;

public class DriverTeresa {

	public static void main(String[] args) {			
		StatsDAO dao = new StatsDAOImpl();
		Stats stat = dao.selectStatById(new Integer(1));
		System.out.println(stat.toString());
	}
}
