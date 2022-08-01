package com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bean.Product_prj;
import com.bean.Purchase;
import com.dao.PurchaseDao;


@Service
public class PurchaseService {
	
	@Autowired
	PurchaseDao purchaseDao;
	
	//public List<Purchase> getPurchaseByDate(String pudate){
	public List<Object[]> getPurchaseByDate(String pudate){
		return purchaseDao.getAllPurchaseByDate(pudate);
	}

}
