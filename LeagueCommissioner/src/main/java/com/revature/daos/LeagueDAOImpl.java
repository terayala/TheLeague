package com.revature.daos;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.revature.beans.League;
import com.revature.util.HibernateUtil;

public class LeagueDAOImpl implements LeagueDAO {

	@Override
	public void createLeague(League league) {
		Session session = HibernateUtil.getSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			session.save(league);
			tx.commit();
		} catch (HibernateException e) {
			if(tx != null){
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
	}

	@Override
	public void updateLeague(League league) {
		Session session = HibernateUtil.getSession();
		Transaction tx = null;		
		try {
			tx = session.beginTransaction();
			session.update(league);
			tx.commit();
		} catch (HibernateException e) {
			if(tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
	}

}
