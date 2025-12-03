package com.demo.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.demo.bean.Product;

public class ProductDaoImpl implements ProductDao{

	static SessionFactory sf=null;
    static {
    	sf=HibernateUtil.getMySessionFactory();
    }
	
    
	@Override
	public void save(Product p) {
		Session session = sf.openSession();
		Transaction tr = session.beginTransaction();
		session.save(p);
		tr.commit();
		session.close();
	}

	@Override
	public List<Product> DisplayAll() {
		// TODO Auto-generated method stub
		Session session = sf.openSession();
		Transaction tr = session.beginTransaction();
		List<Product> plist= session.createQuery("from Product",Product.class).list();
		
		tr.commit();
		session.close();
		
		
		return plist;
	}

	@Override
	public boolean ModifyById(int pid, Double price) {
		// TODO Auto-generated method stub
		
		 Session session = sf.openSession();
		    Transaction tr = session.beginTransaction();
		    Product p = session.get(Product.class, pid);
		    if (p != null) {
		        p.setPrice(price);
		        tr.commit();
		        session.close();
		        return true;
		    }
		    tr.commit();
		    session.close();
		    return false;
	}

	@Override
	public Product findById(int pid) {
		// TODO Auto-generated method stub
		Session session = sf.openSession();
		Transaction tr = session.beginTransaction();
		Product p = session.get(Product.class, pid);
		if(p!=null) {

			return p;
		}
		
		tr.commit();
		session.close();
		return null;
	}



}
