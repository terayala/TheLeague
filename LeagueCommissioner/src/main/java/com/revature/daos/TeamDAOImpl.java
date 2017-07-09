package com.revature.daos;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.revature.beans.Team;
import com.revature.util.HibernateUtil;

public class TeamDAOImpl implements TeamDAO {

	@Override
	public void createTeam(Team t) {
		Session session= HibernateUtil.getSession();
		Transaction tx = null;
		
		try {
			tx = session.beginTransaction();
			session.save(t); //This method persists the object
			tx.commit();
		} catch (Exception e) {
			if(tx != null){
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
		
	}

}
