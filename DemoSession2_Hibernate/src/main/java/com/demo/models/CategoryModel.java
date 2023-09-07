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
}
