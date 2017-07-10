package com.revature.main;

import org.hibernate.Session;

import com.revature.beans.User;
import com.revature.util.HibernateUtil;

public class DriverTeresa {

	public static void main(String[] args) {
		/*GameDAO dao = new GameDAOImpl();
		List<Game> games = dao.viewScheduleByTeam(new Integer(5));
		for (Game g : games) {
			System.out.println(g.toString());
		}*/
		
		Session session = HibernateUtil.getSession();
		User user = (User) session.get(User.class, new Integer(5));
		System.out.println(user.toString());
	}

}
