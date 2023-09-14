package com.demo.models;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.demo.entities.Bacsi;


public class BacsiModel {
private SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

	
	public List<Bacsi> findAll() {
		List<Bacsi> doctors = null;
		Session session = null;
		Transaction trans = null;
		try {
			session = sessionFactory.openSession(); // mở kết nối vào database
			trans = session.beginTransaction();
			// dùng câu truy vấn cho SQL, HQL đều được
			doctors = session.createQuery("from Bacsi").getResultList();
		} catch (Exception e) {

			e.printStackTrace();
			doctors = null;

			if (trans != null) {
				trans.rollback();
			}
		} finally {
			if (session != null) {
				session.close();
			}
		}
		return doctors;
	}
}
