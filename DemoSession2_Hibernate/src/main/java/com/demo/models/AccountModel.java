package com.demo.models;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.demo.entities.Account;

public class AccountModel {
	private SessionFactory sF = HibernateUtil.getSessionFactory();

	public List<Account> findAll() {
		List<Account> accounts = null;
		Session session = null;
		Transaction trans = null;
		try {
			session = sF.openSession(); // mở kết nối vào database
			trans = session.beginTransaction();
			// dùng câu truy vấn cho SQL, HQL đều được
			accounts = session.createQuery("from Account").getResultList();
		} catch (Exception e) {

			e.printStackTrace();
			accounts = null;

			if (trans != null) {
				trans.rollback();
			}
		} finally {
			if (session != null) {
				session.close();
			}
		}
		return accounts;
	}
}

			
