package com.demo.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.demo.bean.Cart;
import com.demo.bean.Product;

public class CartDaoImpl implements CartDao{
	
	static SessionFactory sf;
	static {
		sf=HibernateUtil.getMySessionFactory();
	}
	

	@Override
	public boolean save(Cart c) {
		Session session=sf.openSession();
		Transaction ts = session.beginTransaction();
		session.saveOrUpdate(c);
		ts.commit();
		session.close();
		return true;
	}


	@Override
	public List<Cart> findAllCart() {
		// TODO Auto-generated method stub
		Session session = sf.openSession();
		Transaction tr = session.beginTransaction();
		List<Cart> clist=session.createQuery("from Cart",Cart.class).list();
		
		tr.commit();
		session.close();	
		
		return clist;
	}


	@Override
	public void closeMySession() {
		// TODO Auto-generated method stub
		HibernateUtil.CloseMySession();
		
	}


	@Override
	public boolean RemoveById(int cid) {
		// TODO Auto-generated method stub
		Session session=sf.openSession();
		Transaction tr=session.beginTransaction();
		//bring it into session object
		boolean flag=false;
		Cart c=session.get(Cart.class, cid);
		if(c!=null) {
			//this will execute delete query for employee
			//session.remove(e);
			session.delete(c);
			flag=true;
		}
		tr.commit();
		session.close();
		return flag;
		
	}


	@Override
	public Cart findById(int cid) {
		// TODO Auto-generated method stub
		Session session=sf.openSession();
		Transaction tr=session.beginTransaction();
		//bring it into session object
		Cart c=session.get(Cart.class, cid);
		if(c!=null) {
			return c;
		}
		tr.commit();
		session.close();
		return null;
	}


	@Override
	public boolean addProductToCart(Cart c, Product p) {
		Session session = sf.openSession();
	    Transaction tr = session.beginTransaction();

	    if (c != null && p != null) {
	        c.getPset().add(p);
	        p.getCset().add(c);
	        session.update(c); // or just rely on cascade
	        tr.commit();
	        session.close();
	        return true;
	    }

	    tr.rollback();
	    session.close();
	    return false;

	}


	

}
