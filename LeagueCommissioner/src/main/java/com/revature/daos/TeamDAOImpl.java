package com.revature.daos;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
<<<<<<< HEAD
import org.hibernate.criterion.Projections;
=======
import org.hibernate.criterion.Restrictions;
>>>>>>> branch 'master' of https://github.com/terayala/TheLeague.git

import com.revature.beans.Team;
import com.revature.util.HibernateUtil;

public class TeamDAOImpl implements TeamDAO {
int count=0;
	@Override
	public void createTeam(Team team) {
		count++;
		System.out.println("count************: " + count);
		Session session= HibernateUtil.getSession();
		
		
		Criteria cr = session.createCriteria(TeamDAOImpl.class);

		// To get total row count.
		//cr.setProjection(Projections.rowCount());
		Transaction tx = null;
		try {
	        cr.setProjection(Projections.rowCount());
	         List rowCount = cr.list();

	         System.out.println("Total Count: " + rowCount.size());
			tx = session.beginTransaction();
			
			session.save(team);
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
	public void updateTeam(Team team) {
		Session session = HibernateUtil.getSession();
		Transaction tx = null;		
		try {
			tx = session.beginTransaction();
			session.update(team);
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
	public Team selectTeamById(Integer id) {
		Session session = HibernateUtil.getSession();
		Transaction tx = null;
		Team team = null;
		try {
			tx = session.beginTransaction();
			team = (Team) session.get(Team.class, id);
		} catch(HibernateException e) {
			if(tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
		return team;
	}

	@Override
	public int getAllTeams() {
			List<Team> teams = null;
			Session session = HibernateUtil.getSession();
			Transaction tx = null;
			
			try{
				tx = session.beginTransaction();
				teams = session.createQuery("FROM TEAM").list();
			}catch(HibernateException e){
				if(tx!=null){
					tx.rollback();
				}
				e.printStackTrace();
			}finally{
				session.close();
			}		
			
			return teams.size();
		
	}

	@Override
	public List<Team> selectTeamsByLeague(Integer leagueId) {
		List<Team> teams = null;
		Session session = HibernateUtil.getSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			teams = ((Criteria)session.createCriteria(Team.class)).add(Restrictions.eq("league.leagueID", leagueId)).list();
		} catch(HibernateException e) {
			if(tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}		
		return teams;
	}
}
