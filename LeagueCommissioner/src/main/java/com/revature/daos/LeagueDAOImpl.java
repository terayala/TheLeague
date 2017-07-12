package com.revature.daos;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.annotations.Entity;
import org.hibernate.annotations.NamedNativeQueries;
import org.hibernate.annotations.NamedNativeQuery;
import org.hibernate.annotations.Table;

import com.revature.beans.League;
import com.revature.services.StandingsPOJO;
import com.revature.util.HibernateUtil;

@NamedNativeQueries({
	@NamedNativeQuery(
	name = "Get_League_Standings_Pts",
	query = "CALL Get_League_Standings_Pts(:lid)",
	resultClass = StandingsPOJO.class
	)
})
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

	@Override
	public League selectLeagueById(Integer id) {
		League league = null;
		Session session = HibernateUtil.getSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			league = (League) session.get(League.class, id);
		} catch(HibernateException e) {
			if(tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
		return league;
	}
	
	public ArrayList<StandingsPOJO> fetchStandingsByPoints (int leagueId, ArrayList<StandingsPOJO> standings) {
		Session session = HibernateUtil.getSession();
		Transaction tx = null;
		List rs = null;
		
		try {
			tx = session.beginTransaction();
			
			Query query = session.getNamedQuery("Get_League_Standings_Pts")
					.setParameter("lid", leagueId);
				rs = query.list();
			
			/*Query q = session.getNamedQuery("CALL GET_LEAGUE_STANDINGS_PTS(?, :lid)");
			q.setParameter("lid", leagueId);
			rs = q.list();
			
			String functionCall = "{call Get_League_Standings_Pts (?, ?, ?)}"; 
			callstm = aConnection.prepareCall( functionCall ); 
			callstm.setString( 1, "MYOWNER" ); 
			callstm.setString( 2, "USER_TABLE" ); 
			callstm.registerOutParameter( 3, OracleTypes.CURSOR );*/
			
			System.out.println(rs);
			
			standings = new ArrayList<StandingsPOJO>(rs);
		} catch(HibernateException e) {
			if(tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		}
		
		return standings;
	}
	
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
	}

}
