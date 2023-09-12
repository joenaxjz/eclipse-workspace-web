package com.demo.models;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.demo.entities.Category;


public class CategoryModel {
	private SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
	
	public List<Category> findAll(){
		List<Category> categories = null;
		Session session = null ;
		Transaction trans = null;
		try {
			session = sessionFactory.openSession(); // mở kết nối vào database
			trans = session.beginTransaction();
			// dùng câu truy vấn cho SQL, HQL đều được
			categories = session.createQuery("from Category").getResultList();
			trans.commit();
		} catch (Exception e){
			
				e.printStackTrace();
				categories = null;
				
				if(trans != null) {
					trans.rollback();
				}
				
		} finally {
			if(session != null) {
				session.close();
			}
		}
		return categories;
	}
	
	public boolean create(Category category){
		boolean rs = true;
		Session session = null ;
		Transaction trans = null;
		try {
			session = sessionFactory.openSession(); // mở kết nối vào database
			trans = session.beginTransaction();
			// dùng câu truy vấn cho SQL, HQL đều được
			session.save(category);
			trans.commit();
			System.out.println("category id: " + category.getId());
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
	
	public boolean delete(Category category){
		boolean rs = true;
		Session session = null ;
		Transaction trans = null;
		try {
			session = sessionFactory.openSession(); // mở kết nối vào database
			trans = session.beginTransaction();
			// dùng câu truy vấn cho SQL, HQL đều được
			session.delete(category);
			trans.commit();
			System.out.println("category id: " + category.getId());
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
	
	
	public Category find(int id){
		Category category = null;
		Session session = null ;
		Transaction trans = null;
		try {
			session = sessionFactory.openSession(); // mở kết nối vào database
			trans = session.beginTransaction();
			// dùng câu truy vấn cho SQL, HQL đều được
			category = (Category) session.createQuery("from Category where id = :id")
					.setParameter("id", id)
					.getSingleResult();
			trans.commit();
		} catch (Exception e){
			
				e.printStackTrace();
				category = null;
				if(trans != null) {
					trans.rollback();
				}
				
		} finally {
			if(session != null) {
				session.close();
			}
		}
		return category;
	}
	
	public boolean update(Category category){
		boolean rs = true;
		Session session = null ;
		Transaction trans = null;
		try {
			session = sessionFactory.openSession(); // mở kết nối vào database
			trans = session.beginTransaction();
			// dùng câu truy vấn cho SQL, HQL đều được
			session.update(category);
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
