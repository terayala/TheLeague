package com.revature.daos;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import com.revature.beans.User;
import com.revature.util.HibernateUtil;

public class UserDAOImpl implements UserDAO {

	@Override
	public void createUser(User user) {
		Session session = HibernateUtil.getSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			session.save(user);
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
	public User selectUserById(Integer id) {
		Session session = HibernateUtil.getSession();
		Transaction tx = null;
		User user = null;
		try {
			tx = session.beginTransaction();
			user = (User) session.get(User.class, id);
		} catch(HibernateException e) {
			if(tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
		return user;
	}

	@Override
	public void updateUser(User user) {
		Session session = HibernateUtil.getSession();
		Transaction tx = null;		
		try {
			tx = session.beginTransaction();
			session.update(user);
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
	public User selectUserByUsername(String username) {
		Session session = HibernateUtil.getSession();
		User user = null;
		
		String hql = "FROM User WHERE username = :username";
		Query query = session.createQuery(hql);
		query.setString("username", username);
		user = (User) query.uniqueResult();
			
		session.close();

		return user;
	}

	@Override
	public List<User> selectUsersByTeam(Integer id) {
		List<User> users = null;
		Session session = HibernateUtil.getSession();
		users = session.createCriteria(User.class)
				.add(Restrictions.eq("team.teamID", id))
				.list();
		session.close();
		return users;
	}
	
	public void deleteUser(User user) {
		Session session = HibernateUtil.getSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			session.delete(user);
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
}
