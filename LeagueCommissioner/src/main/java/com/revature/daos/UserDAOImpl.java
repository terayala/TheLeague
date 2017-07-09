package com.revature.daos;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.revature.beans.User;
import com.revature.util.HibernateUtil;

public class UserDAOImpl implements UserDAO {

	@Override
	public void createUser(User user) {
		Session session = HibernateUtil.getSession();
		Transaction tx = session.beginTransaction();
		session.save(user);
		tx.commit();
		session.close();
	}
}
