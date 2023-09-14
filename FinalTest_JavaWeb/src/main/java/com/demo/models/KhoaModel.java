package com.demo.models;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.demo.entities.Khoa;

public class KhoaModel {
	private SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

	
	public List<Khoa> findAll() {
		List<Khoa> khoas = null;
		Session session = null;
		Transaction trans = null;
		try {
			session = sessionFactory.openSession(); // mở kết nối vào database
			trans = session.beginTransaction();
			// dùng câu truy vấn cho SQL, HQL đều được
			khoas = session.createQuery("from Khoa").getResultList();
		} catch (Exception e) {

			e.printStackTrace();
			khoas = null;

			if (trans != null) {
				trans.rollback();
			}
		} finally {
			if (session != null) {
				session.close();
			}
		}
		return khoas;
	}
	
	
	public Khoa find(int makhoa) {
		Khoa khoa = null;
		Session session = null;
		Transaction trans = null;
		try {
			session = sessionFactory.openSession(); // mở kết nối vào database
			trans = session.beginTransaction();
			// dùng câu truy vấn cho SQL, HQL đều được
			khoa = (Khoa) session.createQuery("from Khoa where makhoa =:makhoa ").setParameter("makhoa", makhoa)
					.getSingleResult();
			trans.commit();
		} catch (Exception e) {

			e.printStackTrace();
			khoa = null;

			if (trans != null) {
				trans.rollback();
			}
		} finally {
			if (session != null) {
				session.close();
			}
		}
		return khoa;
	}
	
	public boolean create(Khoa khoa){
		boolean rs = true;
		Session session = null ;
		Transaction trans = null;
		try {
			session = sessionFactory.openSession(); // mở kết nối vào database
			trans = session.beginTransaction();
			// dùng câu truy vấn cho SQL, HQL đều được
			session.save(khoa);
			trans.commit();
			System.out.println("khoa id: " + khoa.getMakhoa());
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
	
	
	public boolean delete(Khoa khoa){
		boolean rs = true;
		Session session = null ;
		Transaction trans = null;
		try {
			session = sessionFactory.openSession(); // mở kết nối vào database
			trans = session.beginTransaction();
			// dùng câu truy vấn cho SQL, HQL đều được
			session.delete(khoa);
			trans.commit();
			System.out.println("Ma khoa: " + khoa.getMakhoa());
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
	
	public boolean update(Khoa khoa){
		boolean rs = true;
		Session session = null ;
		Transaction trans = null;
		try {
			session = sessionFactory.openSession(); // mở kết nối vào database
			trans = session.beginTransaction();
			// dùng câu truy vấn cho SQL, HQL đều được
			session.update(khoa);
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
