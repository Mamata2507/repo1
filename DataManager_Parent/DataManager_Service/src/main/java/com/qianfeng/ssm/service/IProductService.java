package com.qianfeng.ssm.service;

import java.util.List;

import com.qianfeng.ssm.domain.Product;

public interface IProductService {
	
	public List<Product> findAll();

	public void addProduct(Product product);

	public Product findById(String id);
 
	public void editProduct(Product product);

}
