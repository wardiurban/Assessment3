package com.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.bean.Product_prj;
import com.bean.Purchase;
import com.service.ProductService;
import com.service.PurchaseService;

@Controller
public class PurchaseController {
	@Autowired
	PurchaseService purchaseService;
	
	@RequestMapping(value = "getPurchased",method = RequestMethod.POST)
	public ModelAndView searchPurchaseByDate(HttpServletRequest req) {
		String pudate = req.getParameter("pudate");
		
		ModelAndView mav = new ModelAndView();
		//List<Purchase> listOfPurchase  = purchaseService.getPurchaseByDate(pudate);
		List<Object[]> listOfPurchase  = purchaseService.getPurchaseByDate(pudate);
		
		mav.setViewName("displayPurchase1.jsp");
		mav.addObject("listOfPurchase", listOfPurchase);
		return mav;
	}

}
