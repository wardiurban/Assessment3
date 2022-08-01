package com.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.bean.Product_prj;
import com.service.ProductService;

@Controller
public class ProductController {

	@Autowired
	ProductService productService;
	
	@RequestMapping(value = "addProduct",method = RequestMethod.POST)
	public ModelAndView addProduct(HttpServletRequest req, Product_prj product_prj) {
			int pid = Integer.parseInt(req.getParameter("pid"));
			String pname = req.getParameter("pname");
			float price = Float.parseFloat(req.getParameter("price"));
			String category = req.getParameter("category");
			
			product_prj.setPid(pid);
			product_prj.setPname(pname);
			product_prj.setPrice(price);
			product_prj.setCategory(category);
			
			String result = productService.storeProduct(product_prj);
			ModelAndView mav = new ModelAndView();
			mav.setViewName("addProduct.jsp");
			mav.addObject("msg", result);
			return mav;
	}
	
	@RequestMapping(value = "getProduct",method = RequestMethod.GET)
	public ModelAndView getAllProducts() {
		ModelAndView mav = new ModelAndView();
		List<Product_prj> listOfProduct  = productService.getAllProducts();
		
		mav.setViewName("displayProduct.jsp");
		mav.addObject("listOfProduct", listOfProduct);
		return mav;
	}
	
	@RequestMapping(value = "findProductByCategory",method = RequestMethod.POST)
	public ModelAndView searchProductByCategory(HttpServletRequest req) {
		String category = req.getParameter("category");
		
		ModelAndView mav = new ModelAndView();
		List<Product_prj> listOfProduct  = productService.getProductByCategory(category);
		
		mav.setViewName("displayProduct.jsp");
		mav.addObject("listOfProduct", listOfProduct);
		return mav;
	}
	
		
	
}