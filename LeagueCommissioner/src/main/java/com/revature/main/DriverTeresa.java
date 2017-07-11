package com.revature.main;

import com.revature.beans.Trade;
import com.revature.beans.User;
import com.revature.daos.TradeDAO;
import com.revature.daos.TradeDAOImpl;
import com.revature.daos.UserDAO;
import com.revature.daos.UserDAOImpl;

public class DriverTeresa {

	public static void main(String[] args) {			
		TradeDAO dao = new TradeDAOImpl();
		UserDAO daoU = new UserDAOImpl();
		User user = daoU.selectUserById(new Integer(3));
		dao.createTrade(new Trade(user, user.getTeam(),0,0,0));
	}
}
