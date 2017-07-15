package com.revature.daos;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;

import com.revature.beans.Game;
import com.revature.beans.Team;
import com.revature.util.HibernateUtil;

public class GameDAOImpl implements GameDAO {

	public List<Game> getScheduleByLeague(List<Team> teams) {
		List<Game> games = new ArrayList<Game>();
		Session session= HibernateUtil.getSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			for (Team t : teams) {
				List<Game> tempList = ((Criteria)session.createCriteria(Game.class)).add(Restrictions.eq("homeTeam.teamID", t.getTeamID())).list();
				games.addAll( tempList );
			}
		} catch (Exception e) {
			if(tx != null){
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
		return games;
	}

	@Override
	public List<Game> viewScheduleByTeam(Integer teamID) {
		List<Game> list = null;
		Session session = HibernateUtil.getSession();
		Transaction tran = null;
		Criterion crit1 = Restrictions.eq("homeTeam.teamID", teamID);
		Criterion crit2 = Restrictions.eq("awayTeam.teamID", teamID);
		try {
			tran = session.beginTransaction();
			list = ((Criteria) session.createCriteria(Game.class)).add(Restrictions.or(crit1, crit2)).list();
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

	@Override
	public void createGame(Game game) {
		Session session = HibernateUtil.getSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			session.save(game);
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
	public Game selectGameById(Integer id) {
		Game game = null;
		Session session = HibernateUtil.getSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			game = (Game) session.get(Game.class, id);
		} catch(HibernateException e) {
			if(tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
		return game;
	}
}