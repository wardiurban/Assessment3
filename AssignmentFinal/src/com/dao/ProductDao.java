package com.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bean.Product_prj;

@Repository
public class ProductDao {

	@Autowired
	SessionFactory sf;
	
	public int storeProduct(Product_prj product_prj) {
		try {
			Session session = sf.openSession();
			Transaction tran = session.getTransaction();
			tran.begin();
					session.save(product_prj);
			tran.commit();
			return 1;
		} catch (Exception e) {
			System.out.println(e);
			return 0;
		}
	}
	
	public List<Product_prj> getAllProducts() {
		Session session = sf.openSession();
		Query qry = session.createQuery("select p from Product_prj p");
		List<Product_prj> listOfProduct = qry.list();
		return listOfProduct;
	}
	
	public List<Product_prj> getAllProductsByCategory(String category) {
		Session session = sf.openSession();
		Query qry = session.createQuery("select p from Product_prj p where p.category = :category");
		qry.setParameter("category", category);
		List<Product_prj> listOfProduct = qry.list();
		return listOfProduct;
	}
}