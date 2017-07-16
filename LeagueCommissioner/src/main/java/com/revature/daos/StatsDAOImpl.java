package com.revature.daos;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import com.revature.beans.Stats;
import com.revature.beans.User;
import com.revature.util.HibernateUtil;

public class StatsDAOImpl implements StatsDAO {

	@Override
	public void createStat(Stats stats) {
		Session session = HibernateUtil.getSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			session.save(stats);
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
	public void updateStat(Stats stats) {
		Session session = HibernateUtil.getSession();
		Transaction tx = null;		
		try {
			tx = session.beginTransaction();
			session.update(stats);
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
	public List<Stats> selectStatsByPlayerId(Integer playerId) {
		List<Stats> stats = null;
		Session session = HibernateUtil.getSession();
		stats = session.createCriteria(Stats.class)
				.add(Restrictions.eq("player.userID", playerId))
				.list();
		session.close();
		return stats;
	}

	@Override
	public List<List<Stats>> selectStatsListByPlayers(List<User> users) {
		List<List<Stats>> stats = new ArrayList<>();
		Session session = HibernateUtil.getSession();
		for(User user : users) {
			List<Stats> temp = session.createCriteria(Stats.class)
					.add(Restrictions.eq("player.userID", user.getUserID()))
					.list();
			stats.add(temp);
		}
		session.close();
		return stats;
	}

}
