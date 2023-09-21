package com.demo.models;

import java.util.Date;
import java.util.List;

import javax.persistence.TemporalType;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.demo.entities.Bacsi;
import com.demo.entities.Benhnhan;
import com.demo.entities.Lichkham;

public class LichkhamModel {
private SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

	
	public List<Lichkham> findAll() {
		List<Lichkham> lichkhams = null;
		Session session = null;
		Transaction trans = null;
		try {
			session = sessionFactory.openSession(); // mở kết nối vào database
			trans = session.beginTransaction();
			// dùng câu truy vấn cho SQL, HQL đều được
			lichkhams = session.createQuery("from Lichkham").getResultList();
		} catch (Exception e) {

			e.printStackTrace();
			lichkhams = null;

			if (trans != null) {
				trans.rollback();
			}
		} finally {
			if (session != null) {
				session.close();
			}
		}
		return lichkhams;
	}
	
	public List<Lichkham> findLichkhamBacsi(int mabs) {
		List<Lichkham> lichkhams = null;
		Session session = null;
		Transaction trans = null;
		try {
			session = sessionFactory.openSession(); // mở kết nối vào database
			trans = session.beginTransaction();
			// dùng câu truy vấn cho SQL, HQL đều được
			lichkhams = (List<Lichkham>) session.createQuery("from Lichkham where bacsi.mabs =:mabs ").setParameter("mabs", mabs)
					.getResultList();
			trans.commit();
		} catch (Exception e) {

			e.printStackTrace();
			lichkhams = null;

			if (trans != null) {
				trans.rollback();
			}
		} finally {
			if (session != null) {
				session.close();
			}
		}
		return lichkhams;
	}
	
	public List<Lichkham> findLichkhamBenhnhan(int mabn) {
		List<Lichkham> lichkhams = null;
		Session session = null;
		Transaction trans = null;
		try {
			session = sessionFactory.openSession(); // mở kết nối vào database
			trans = session.beginTransaction();
			// dùng câu truy vấn cho SQL, HQL đều được
			lichkhams = (List<Lichkham>) session.createQuery("from Lichkham where benhnhan.mabn =:mabn ").setParameter("mabn", mabn)
					.getResultList();
			trans.commit();
		} catch (Exception e) {

			e.printStackTrace();
			lichkhams = null;

			if (trans != null) {
				trans.rollback();
			}
		} finally {
			if (session != null) {
				session.close();
			}
		}
		return lichkhams;
	}
	
	public List<Lichkham> findByDates(Date from, Date to, int mabs) {
		List<Lichkham> lichkhams = null;
		Session session = null;
		Transaction trans = null;
		try {
			session = sessionFactory.openSession(); // mở kết nối vào database
			trans = session.beginTransaction();
			// dùng câu truy vấn cho SQL, HQL đều được
			lichkhams = session.createQuery("from Lichkham where ngaykham >= :from and ngaykham <= :to and bacsi.mabs = :mabs")
					.setParameter("from", from, TemporalType.DATE)
					.setParameter("to", to, TemporalType.DATE)
					.setParameter("mabs", mabs)
					.getResultList();
		} catch (Exception e) {

			e.printStackTrace();
			lichkhams = null;

			if (trans != null) {
				trans.rollback();
			}
		} finally {
			if (session != null) {
				session.close();
			}
		}
		return lichkhams;
	}
}
