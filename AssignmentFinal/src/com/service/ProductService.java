package com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bean.Product_prj;
import com.dao.ProductDao;

@Service
public class ProductService {

	@Autowired
	ProductDao productDao;
	
	public String storeProduct(Product_prj product_prj) {
		if(productDao.storeProduct(product_prj)>0) {
			return "Record stored successfully";
		}else {
			return "Record didn't store";
		}
	}
	
	
	public List<Product_prj> getAllProducts() {
		return productDao.getAllProducts();
	}
	
	public List<Product_prj> getProductByCategory(String category){
		return productDao.getAllProductsByCategory(category);
	}
}