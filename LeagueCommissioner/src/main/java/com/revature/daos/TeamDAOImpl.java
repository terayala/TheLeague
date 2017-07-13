package com.revature.daos;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.revature.bean.Employee;
import com.revature.beans.Team;
import com.revature.util.HibernateUtil;

public class TeamDAOImpl implements TeamDAO {

	@Override
	public void createTeam(Team team) {
		Session session= HibernateUtil.getSession();
		Transaction tx = null;
		try {
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
	public List<Team> getAllTeams() {
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
			
			return teams;
		
	}
}
