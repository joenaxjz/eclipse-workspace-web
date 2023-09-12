package com.demo.models;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.demo.entities.Account;
import com.demo.entities.Product;

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
	
	public Account find(int id) {
		Account account = null;
		Session session = null;
		Transaction trans = null;
		try {
			session = sF.openSession(); // mở kết nối vào database
			trans = session.beginTransaction();
			// dùng câu truy vấn cho SQL, HQL đều được
			account = (Account) session.createQuery("from Account where id = :id")
					.setParameter("id", id)
					.getSingleResult();
		} catch (Exception e) {

			e.printStackTrace();
			account = null;

			if (trans != null) {
				trans.rollback();
			}
		} finally {
			if (session != null) {
				session.close();
			}
		}
		return account;
	}
	
	public boolean create(Account account){
		boolean rs = true;
		Session session = null ;
		Transaction trans = null;
		try {
			session = sF.openSession(); // mở kết nối vào database
			trans = session.beginTransaction();
			// dùng câu truy vấn cho SQL, HQL đều được
			session.save(account);
			trans.commit();
			System.out.println("account id: " + account.getId());
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
	
	
	public boolean delete(Account account){
		boolean rs = true;
		Session session = null ;
		Transaction trans = null;
		try {
			session = sF.openSession(); // mở kết nối vào database
			trans = session.beginTransaction();
			// dùng câu truy vấn cho SQL, HQL đều được
			session.delete(account);
			trans.commit();
			System.out.println("account id: " + account.getId());
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
	
	public boolean update(Account account){
		boolean rs = true;
		Session session = null ;
		Transaction trans = null;
		try {
			session = sF.openSession(); // mở kết nối vào database
			trans = session.beginTransaction();
			// dùng câu truy vấn cho SQL, HQL đều được
			session.update(account);
			trans.commit();
			System.out.println("account id: " + account.getId());
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

			
