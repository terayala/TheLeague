package com.revature.daos;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.revature.services.StandingsPOJO;
import com.revature.util.HibernateUtil;

public class StandingsDAOImpl implements StandingsDAO {
	
	/*
	 * Access the stored SQL function that sorts the table by points
	 */
	public ArrayList<StandingsPOJO> fetchStandingsByPoints (int leagueId, ArrayList<StandingsPOJO> standings) {
		
		Session session = HibernateUtil.getSession();
		Transaction tx = null;
		List rs = null;
		
		try {
			tx = session.beginTransaction();
			
			Query query = session.getNamedQuery("Get_League_Standings_Pts")
					.setParameter("lid", leagueId);
				rs = query.list();
			
			System.out.println(rs);
			
			standings = new ArrayList<StandingsPOJO>(rs);
		} catch(HibernateException e) {
			if(tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		}
		
		return standings;
		
	};
	
	/*
	 * Access the stored SQL function that sorts the table by win percentage
	 */
	public ArrayList<StandingsPOJO> fetchStandingsByPct (int leagueId, ArrayList<StandingsPOJO> standings) {
		
		Session session = HibernateUtil.getSession();
		Transaction tx = null;
		List rs = null;
		
		try {
			tx = session.beginTransaction();
			
			Query q = session.getNamedQuery("CALL Get_League_standings_Pct(?, :lid)");
			q.setParameter("lid", leagueId);
			rs = q.list();
			
			System.out.println(rs);
			
			standings = new ArrayList<StandingsPOJO>(rs);
		} catch(HibernateException e) {
			if(tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		}
		return standings;
		
	};

}