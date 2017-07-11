package com.revature.main;



import com.revature.beans.Team;
import com.revature.beans.User;
import com.revature.daos.UserDAO;
import com.revature.daos.UserDAOImpl;


public class DriverDemetrus {

	public static void main(String[] args) {
		UserDAO ud = new UserDAOImpl();
		//Team t = new Team();
		User u= new User(null, "Test", "User", 2, "test@usertest.org", "testuser", "secret", 0, 1);
		//t=td.selectTeamById(3);
		//System.out.println("****************t**********************: " + t.toString());
		
		ud.createUser(u);
		System.out.println("ud: " + ud);
		
		
		

	}

}
