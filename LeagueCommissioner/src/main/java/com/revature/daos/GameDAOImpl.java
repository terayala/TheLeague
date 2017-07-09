package com.revature.daos;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;


import com.revature.beans.Game;
import com.revature.util.HibernateUtil;

public class GameDAOImpl implements GameDAO {

	public List<Game> getSchedule() {
		
		List<Game> games = null;
		Session session= HibernateUtil.getSession();
		Transaction tx = null;
		
		try {
			tx = session.beginTransaction();
			games=session.createQuery("FROM GAMES").list(); //HQL
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



}
