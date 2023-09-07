package com.demo.models;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.demo.entities.Account;
import com.demo.entities.Role;

public class RoleModel {
	private SessionFactory sF = HibernateUtil.getSessionFactory();

	public List<Role> findAll() {
		List<Role> roles = null;
		Session session = null;
		Transaction trans = null;
		try {
			session = sF.openSession(); // mở kết nối vào database
			trans = session.beginTransaction();
			// dùng câu truy vấn cho SQL, HQL đều được
			roles = session.createQuery("from Role").getResultList();
		} catch (Exception e) {

			e.printStackTrace();
			roles = null;

			if (trans != null) {
				trans.rollback();
			}
		} finally {
			if (session != null) {
				session.close();
			}
		}
		return roles;
	}
}

			
