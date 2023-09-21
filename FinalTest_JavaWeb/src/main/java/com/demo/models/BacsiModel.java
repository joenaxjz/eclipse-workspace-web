package com.demo.models;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.demo.entities.Bacsi;
import com.demo.entities.Khoa;


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
	
	public Bacsi find(int mabs) {
		Bacsi doctor = null;
		Session session = null;
		Transaction trans = null;
		try {
			session = sessionFactory.openSession(); // mở kết nối vào database
			trans = session.beginTransaction();
			// dùng câu truy vấn cho SQL, HQL đều được
			doctor = (Bacsi) session.createQuery("from Bacsi where mabs =:mabs ").setParameter("mabs", mabs)
					.getSingleResult();
			trans.commit();
		} catch (Exception e) {

			e.printStackTrace();
			doctor = null;

			if (trans != null) {
				trans.rollback();
			}
		} finally {
			if (session != null) {
				session.close();
			}
		}
		return doctor;
	}
	
	public List<Bacsi> findKhoa(int makhoa) {
		List<Bacsi> doctors = null;
		Session session = null;
		Transaction trans = null;
		try {
			session = sessionFactory.openSession(); // mở kết nối vào database
			trans = session.beginTransaction();
			// dùng câu truy vấn cho SQL, HQL đều được
			doctors = (List<Bacsi>) session.createQuery("from Bacsi where khoa.makhoa =:makhoa ").setParameter("makhoa", makhoa)
					.getResultList();
			trans.commit();
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
	
	public boolean create(Bacsi bacsi){
		boolean rs = true;
		Session session = null ;
		Transaction trans = null;
		try {
			session = sessionFactory.openSession(); // mở kết nối vào database
			trans = session.beginTransaction();
			// dùng câu truy vấn cho SQL, HQL đều được
			session.save(bacsi);
			trans.commit();
			System.out.println("bacsi id: " + bacsi.getMabs());
		} catch (Exception e){
			
				e.printStackTrace();
				rs = false;
				if(trans != null) {
					trans.rollback();
				}
				
		} finally {
			if(session != null) {
				session.close();
			}
		}
		return rs;
	}
	
	
	public boolean delete(Bacsi bacsi){
		boolean rs = true;
		Session session = null ;
		Transaction trans = null;
		try {
			session = sessionFactory.openSession(); // mở kết nối vào database
			trans = session.beginTransaction();
			// dùng câu truy vấn cho SQL, HQL đều được
			session.delete(bacsi);
			trans.commit();
			System.out.println("Ma bac si: " + bacsi.getMabs());
		} catch (Exception e){
			
				e.printStackTrace();
				rs = false;
				if(trans != null) {
					trans.rollback();
				}
				
		} finally {
			if(session != null) {
				session.close();
			}
		}
		return rs;
	}
	
	public boolean update(Bacsi bacsi){
		boolean rs = true;
		Session session = null ;
		Transaction trans = null;
		try {
			session = sessionFactory.openSession(); // mở kết nối vào database
			trans = session.beginTransaction();
			// dùng câu truy vấn cho SQL, HQL đều được
			session.update(bacsi);
			trans.commit();
		} catch (Exception e){
			
				e.printStackTrace();
				rs = false;
				if(trans != null) {
					trans.rollback();
				}
				
		} finally {
			if(session != null) {
				session.close();
			}
		}
		return rs;
	}
}
