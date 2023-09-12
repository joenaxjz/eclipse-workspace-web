package com.demo.models;

import java.util.Date;
import java.util.List;

import javax.persistence.TemporalType;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.demo.entities.Category;
import com.demo.entities.Product;
import com.demo.entities.ProductInfo;

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

	public List<ProductInfo> findAll2() {
		List<ProductInfo> productInfos = null;
		Session session = null;
		Transaction trans = null;
		try {
			session = sF.openSession(); // mở kết nối vào database
			trans = session.beginTransaction();
			// dùng câu truy vấn cho SQL, HQL đều được
			productInfos = session.createQuery("select new com.demo.entities.ProductInfo(id, name, price) from Product")
					.getResultList();
		} catch (Exception e) {

			e.printStackTrace();
			productInfos = null;

			if (trans != null) {
				trans.rollback();
			}
		} finally {
			if (session != null) {
				session.close();
			}
		}
		return productInfos;
	}

	public List<Product> findByStatus(boolean status) {
		List<Product> products = null;
		Session session = null;
		Transaction trans = null;
		try {
			session = sF.openSession(); // mở kết nối vào database
			trans = session.beginTransaction();
			// dùng câu truy vấn cho SQL, HQL đều được
			products = session.createQuery("from Product where status = :status").setParameter("status", status)
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
					.setParameter("min", min).setParameter("max", max).getResultList();
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

	public List<Product> findByCategory(int categoryId) {
		List<Product> products = null;
		Session session = null;
		Transaction trans = null;
		try {
			session = sF.openSession(); // mở kết nối vào database
			trans = session.beginTransaction();
			// dùng câu truy vấn cho SQL, HQL đều được
			products = session.createQuery("from Product where category.id= :categoryId")
					.setParameter("categoryId", categoryId).getResultList();
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

	public List<Product> findByKeyword(String keyword) {
		List<Product> products = null;
		Session session = null;
		Transaction trans = null;
		try {
			session = sF.openSession(); // mở kết nối vào database
			trans = session.beginTransaction();
			// dùng câu truy vấn cho SQL, HQL đều được
			products = session.createQuery("from Product where name like :keyword")
					.setParameter("keyword", "%" + keyword + "%").getResultList();
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

	public List<Product> findByYear(int year) {
		List<Product> products = null;
		Session session = null;
		Transaction trans = null;
		try {
			session = sF.openSession(); // mở kết nối vào database
			trans = session.beginTransaction();
			// dùng câu truy vấn cho SQL, HQL đều được
			products = session.createQuery("from Product where year(created) = :year").setParameter("year", year)
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

	public List<Product> findByYearandMonth(int year, int month) {
		List<Product> products = null;
		Session session = null;
		Transaction trans = null;
		try {
			session = sF.openSession(); // mở kết nối vào database
			trans = session.beginTransaction();
			// dùng câu truy vấn cho SQL, HQL đều được
			products = session.createQuery("from Product where year(created) = :year and month(created) = :month")
					.setParameter("year", year).setParameter("month", month).getResultList();
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

	public List<Product> findByYearandMonthandDay(int year, int month, int day) {
		List<Product> products = null;
		Session session = null;
		Transaction trans = null;
		try {
			session = sF.openSession(); // mở kết nối vào database
			trans = session.beginTransaction();
			// dùng câu truy vấn cho SQL, HQL đều được
			products = session.createQuery(
					"from Product where year(created) = :year and month(created) = :month and day(created) = :day")
					.setParameter("year", year).setParameter("month", month).setParameter("day", day).getResultList();
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

	public List<Product> findByDate(Date date) {
		List<Product> products = null;
		Session session = null;
		Transaction trans = null;
		try {
			session = sF.openSession(); // mở kết nối vào database
			trans = session.beginTransaction();
			// dùng câu truy vấn cho SQL, HQL đều được
			products = session.createQuery("from Product where created = :date ")
					.setParameter("date", date, TemporalType.DATE).getResultList();
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

	public List<Product> findByDates(Date from, Date to) {
		List<Product> products = null;
		Session session = null;
		Transaction trans = null;
		try {
			session = sF.openSession(); // mở kết nối vào database
			trans = session.beginTransaction();
			// dùng câu truy vấn cho SQL, HQL đều được
			products = session.createQuery("from Product where created >= :from and created <= :to ")
					.setParameter("from", from, TemporalType.DATE).setParameter("to", to, TemporalType.DATE)
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

	public List<Product> sort1() {
		List<Product> products = null;
		Session session = null;
		Transaction trans = null;
		try {
			session = sF.openSession(); // mở kết nối vào database
			trans = session.beginTransaction();
			// dùng câu truy vấn cho SQL, HQL đều được
			products = session.createQuery("from Product order by price desc ").getResultList();
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

	public List<Product> sort2(boolean status) {
		List<Product> products = null;
		Session session = null;
		Transaction trans = null;
		try {
			session = sF.openSession(); // mở kết nối vào database
			trans = session.beginTransaction();
			// dùng câu truy vấn cho SQL, HQL đều được
			products = session.createQuery("from Product where status = :status order by price desc ")
					.setParameter("status", status).getResultList();
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

	public List<Product> limit1(int n) {
		List<Product> products = null;
		Session session = null;
		Transaction trans = null;
		try {
			session = sF.openSession(); // mở kết nối vào database
			trans = session.beginTransaction();
			// dùng câu truy vấn cho SQL, HQL đều được
			products = session.createQuery("from Product order by price desc ").setMaxResults(n).getResultList();
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

	public List<Product> limit2(boolean status, int n) {
		List<Product> products = null;
		Session session = null;
		Transaction trans = null;
		try {
			session = sF.openSession(); // mở kết nối vào database
			trans = session.beginTransaction();
			// dùng câu truy vấn cho SQL, HQL đều được
			products = session.createQuery("from Product where status = :status order by price desc ")
					.setParameter("status", status).setMaxResults(n).getResultList();
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

	public List<Product> limit3(boolean status, int start, int n) {
		List<Product> products = null;
		Session session = null;
		Transaction trans = null;
		try {
			session = sF.openSession(); // mở kết nối vào database
			trans = session.beginTransaction();
			// dùng câu truy vấn cho SQL, HQL đều được
			products = session.createQuery("from Product where status = :status order by price desc ")
					.setParameter("status", status).setFirstResult(start).setMaxResults(n).getResultList();
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

	public Product find(int id) {
		Product product = null;
		Session session = null;
		Transaction trans = null;
		try {
			session = sF.openSession(); // mở kết nối vào database
			trans = session.beginTransaction();
			// dùng câu truy vấn cho SQL, HQL đều được
			product = (Product) session.createQuery("from Product where id =:id ").setParameter("id", id)
					.getSingleResult();
			trans.commit();
		} catch (Exception e) {

			e.printStackTrace();
			product = null;

			if (trans != null) {
				trans.rollback();
			}
		} finally {
			if (session != null) {
				session.close();
			}
		}
		return product;
	}

	public Long sum1() {
		Long rs = null;
		Session session = null;
		Transaction trans = null;
		try {
			session = sF.openSession(); // mở kết nối vào database
			trans = session.beginTransaction();
			// dùng câu truy vấn cho SQL, HQL đều được
			rs = (Long) session.createQuery("select sum(quantity) from Product").getSingleResult();
			trans.commit();
		} catch (Exception e) {
			e.printStackTrace();
			rs = null;

			if (trans != null) {
				trans.rollback();
			}
		} finally {
			if (session != null) {
				session.close();
			}
		}
		return rs;
	}
	
	public Long sum2(boolean status) {
		Long rs = null;
		Session session = null;
		Transaction trans = null;
		try {
			session = sF.openSession(); // mở kết nối vào database
			trans = session.beginTransaction();
			// dùng câu truy vấn cho SQL, HQL đều được
			rs = (Long) session.createQuery("select sum(quantity) from Product  where status = :status")
					.setParameter("status", status)
					.getSingleResult();
			trans.commit();
		} catch (Exception e) {
			e.printStackTrace();
			rs = null;

			if (trans != null) {
				trans.rollback();
			}
		} finally {
			if (session != null) {
				session.close();
			}
		}
		return rs;
	}
	
	public Double sum3(boolean status) {
		Double rs = null;
		Session session = null;
		Transaction trans = null;
		try {
			session = sF.openSession(); // mở kết nối vào database
			trans = session.beginTransaction();
			// dùng câu truy vấn cho SQL, HQL đều được
			rs = (Double) session.createQuery("select sum(quantity * price) from Product where status = :status")
					.setParameter("status", status)
					.getSingleResult();
			trans.commit();
		} catch (Exception e) {
			e.printStackTrace();
			rs = null;

			if (trans != null) {
				trans.rollback();
			}
		} finally {
			if (session != null) {
				session.close();
			}
		}
		return rs;
	}
	
	public Long count1() {
		Long rs = null;
		Session session = null;
		Transaction trans = null;
		try {
			session = sF.openSession(); // mở kết nối vào database
			trans = session.beginTransaction();
			// dùng câu truy vấn cho SQL, HQL đều được
			rs = (Long) session.createQuery("select count(quantity) from Product")
					.getSingleResult();
			trans.commit();
		} catch (Exception e) {
			e.printStackTrace();
			rs = null;

			if (trans != null) {
				trans.rollback();
			}
		} finally {
			if (session != null) {
				session.close();
			}
		}
		return rs;
	}
	
	public Double min() {
		Double rs = null;
		Session session = null;
		Transaction trans = null;
		try {
			session = sF.openSession(); // mở kết nối vào database
			trans = session.beginTransaction();
			// dùng câu truy vấn cho SQL, HQL đều được
			rs = (Double) session.createQuery("select min(price) from Product")
					.getSingleResult();
			trans.commit();
		} catch (Exception e) {
			e.printStackTrace();
			rs = null;

			if (trans != null) {
				trans.rollback();
			}
		} finally {
			if (session != null) {
				session.close();
			}
		}
		return rs;
	}
	
	public Double max() {
		Double rs = null;
		Session session = null;
		Transaction trans = null;
		try {
			session = sF.openSession(); // mở kết nối vào database
			trans = session.beginTransaction();
			// dùng câu truy vấn cho SQL, HQL đều được
			rs = (Double) session.createQuery("select max(price) from Product")
					.getSingleResult();
			trans.commit();
		} catch (Exception e) {
			e.printStackTrace();
			rs = null;

			if (trans != null) {
				trans.rollback();
			}
		} finally {
			if (session != null) {
				session.close();
			}
		}
		return rs;
	}
	
	public Double avg() {
		Double rs = null;
		Session session = null;
		Transaction trans = null;
		try {
			session = sF.openSession(); // mở kết nối vào database
			trans = session.beginTransaction();
			// dùng câu truy vấn cho SQL, HQL đều được
			rs = (Double) session.createQuery("select avg(price) from Product")
					.getSingleResult();
			trans.commit();
		} catch (Exception e) {
			e.printStackTrace();
			rs = null;

			if (trans != null) {
				trans.rollback();
			}
		} finally {
			if (session != null) {
				session.close();
			}
		}
		return rs;
	}
	
	public boolean create(Product product){
		boolean rs = true;
		Session session = null ;
		Transaction trans = null;
		try {
			session = sF.openSession(); // mở kết nối vào database
			trans = session.beginTransaction();
			// dùng câu truy vấn cho SQL, HQL đều được
			session.save(product);
			trans.commit();
			System.out.println("category id: " + product.getId());
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
	
	public boolean delete(Product product){
		boolean rs = true;
		Session session = null ;
		Transaction trans = null;
		try {
			session = sF.openSession(); // mở kết nối vào database
			trans = session.beginTransaction();
			// dùng câu truy vấn cho SQL, HQL đều được
			session.delete(product);
			trans.commit();
			System.out.println("product id: " + product.getId());
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
	
	
	public boolean update(Product product){
		boolean rs = true;
		Session session = null ;
		Transaction trans = null;
		try {
			session = sF.openSession(); // mở kết nối vào database
			trans = session.beginTransaction();
			// dùng câu truy vấn cho SQL, HQL đều được
			session.update(product);
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
