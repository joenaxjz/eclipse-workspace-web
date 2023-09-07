package com.demo.models;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.demo.entities.Product;

public class ProductModel {
	private SessionFactory sF = HibernateUtil.getSessionFactory();

	public List<Product> findAll() {
		List<Product> products = null;
		Session session = null;
		Transaction trans = null;
		try {
			session = sF.openSession(); // mở kết nối vào database
			trans = session.beginTransaction();
			// dùng câu truy vấn cho SQL, HQL đều được
			products = session.createQuery("from Product").getResultList();
		} catch (Exception e) {

			e.printStackTrace();
			products = null;

			if (trans != null) {
				trans.rollback();
			}
		} finally {
			if (session != null) {
				session.close();
			}
		}
		return products;
	}
	
	public List<Product> findByStatus(boolean status) {
		List<Product> products = null;
		Session session = null;
		Transaction trans = null;
		try {
			session = sF.openSession(); // mở kết nối vào database
			trans = session.beginTransaction();
			// dùng câu truy vấn cho SQL, HQL đều được
			products = session.createQuery("from Product where status = :status")
					.setParameter("status", status)
					.getResultList();
		} catch (Exception e) {

			e.printStackTrace();
			products = null;

			if (trans != null) {
				trans.rollback();
			}
		} finally {
			if (session != null) {
				session.close();
			}
		}
		return products;
	}
	
	public List<Product> findByPrice(double min, double max) {
		List<Product> products = null;
		Session session = null;
		Transaction trans = null;
		try {
			session = sF.openSession(); // mở kết nối vào database
			trans = session.beginTransaction();
			// dùng câu truy vấn cho SQL, HQL đều được
			products = session.createQuery("from Product where price >= :min and price <= :max")
					.setParameter("min", min)
					.setParameter("max", max)
					.getResultList();
		} catch (Exception e) {

			e.printStackTrace();
			products = null;

			if (trans != null) {
				trans.rollback();
			}
		} finally {
			if (session != null) {
				session.close();
			}
		}
		return products;
	}
}
