package com.demo.models;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.demo.entities.Bacsi;
import com.demo.entities.Benhnhan;
import com.demo.entities.Khoa;

public class BenhnhanModel {
private SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

	
	public List<Benhnhan> findAll() {
		List<Benhnhan> benhnhans = null;
		Session session = null;
		Transaction trans = null;
		try {
			session = sessionFactory.openSession(); // mở kết nối vào database
			trans = session.beginTransaction();
			// dùng câu truy vấn cho SQL, HQL đều được
			benhnhans = session.createQuery("from Benhnhan").getResultList();
		} catch (Exception e) {

			e.printStackTrace();
			benhnhans = null;

			if (trans != null) {
				trans.rollback();
			}
		} finally {
			if (session != null) {
				session.close();
			}
		}
		return benhnhans;
	}
	
	public Benhnhan find(int mabn) {
		Benhnhan benhnhan = null;
		Session session = null;
		Transaction trans = null;
		try {
			session = sessionFactory.openSession(); // mở kết nối vào database
			trans = session.beginTransaction();
			// dùng câu truy vấn cho SQL, HQL đều được
			benhnhan = (Benhnhan) session.createQuery("from Benhnhan where mabn =:mabn ").setParameter("mabn", mabn)
					.getSingleResult();
			trans.commit();
		} catch (Exception e) {

			e.printStackTrace();
			benhnhan = null;

			if (trans != null) {
				trans.rollback();
			}
		} finally {
			if (session != null) {
				session.close();
			}
		}
		return benhnhan;
	}
}
