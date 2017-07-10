package com.revature.daos;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.revature.beans.Sport;
import com.revature.util.HibernateUtil;

public class SportDAOImpl implements SportDAO {

	@Override
	public void createSport(Sport sport) {
		Session session = HibernateUtil.getSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			session.save(sport);
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
	public void updateSport(Sport sport) {
		Session session = HibernateUtil.getSession();
		Transaction tx = null;		
		try {
			tx = session.beginTransaction();
			session.update(sport);
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

	@Override
	public Sport selectSportById(Integer id) {
		Sport sport = null;
		Session session = HibernateUtil.getSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			sport = (Sport) session.get(Sport.class, id);
		} catch(HibernateException e) {
			if(tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
		return sport;
	}

}
