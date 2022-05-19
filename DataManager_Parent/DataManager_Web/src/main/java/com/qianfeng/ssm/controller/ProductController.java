package com.qianfeng.ssm.controller;

import java.util.List;

import javax.annotation.security.RolesAllowed;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.qianfeng.ssm.domain.Product;
import com.qianfeng.ssm.service.IProductService;


@RequestMapping("/product")
@Controller
public class ProductController {
	
	@Autowired
	private IProductService produtcService;
	
	@RequestMapping("/findAll")
	@Secured("ROLE_USER")
	public ModelAndView findAll() {
		List<Product> products = produtcService.findAll();
		ModelAndView mav = new ModelAndView(); 
		mav.addObject("productList",products);
		mav.setViewName("/product-list");
		return mav;
	}
	
	@RequestMapping("/save")
	public String saveProduct(Product product) {
		produtcService.addProduct(product);
		return "redirect:/product/findAll";
	}
	
	@RequestMapping("/findById")
	@RolesAllowed("USER")
	public ModelAndView findById(String id) {
		Product product = produtcService.findById(id);
		ModelAndView mav = new ModelAndView(); 
		mav.addObject("product",product);
		mav.setViewName("/product-update");
		return mav;
	}
	
	@RequestMapping("/update")
	public String updateProduct(Product product) {
		produtcService.editProduct(product);
		return "redirect:/product/findAll";
	}

}
