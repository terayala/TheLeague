package com.revature.daos;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;

import com.revature.beans.Game;
import com.revature.util.HibernateUtil;

public class GameDAOImpl implements GameDAO {

	@Override
	public List<Game> viewScheduleByTeam(Integer teamID) {
		List<Game> list = null;
		Session session = HibernateUtil.getSession();
		Transaction tran = null;
		Criterion crit1 = Restrictions.ilike("HOME_TEAM", teamID);
		Criterion crit2 = Restrictions.ilike("AWAY_TEAM", teamID);
		try {
			tran = session.beginTransaction();
			list = ((Criteria) session.createQuery("FROM GAMES")).add(Restrictions.or(crit1, crit2)).list();
		} catch(HibernateException exception) {
			if(tran != null) {
				tran.rollback();
			}
			exception.printStackTrace();
		} finally {
			session.close();
		}
		return list;
	}

	@Override
	public void updateGame(Game game) {
		Session session = HibernateUtil.getSession();
		Transaction tx = null;		
		try {
			tx = session.beginTransaction();
			session.update(game);
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
