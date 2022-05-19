package com.qianfeng.ssm.service.impl;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.qianfeng.ssm.dao.IProductDao;
import com.qianfeng.ssm.domain.Product;
import com.qianfeng.ssm.service.IProductService;

@Service
@Transactional(propagation = Propagation.REQUIRED,readOnly = false)
public class ProductServiceImpl implements IProductService{
    
	@Autowired
	private IProductDao prductDao;
	
	@Override
	public List<Product> findAll() {
		// TODO Auto-generated method stub
		return prductDao.findAll();
	}

	@Override
	public void addProduct(Product product) {
		// TODO Auto-generated method stub
		String id = UUID.randomUUID().toString(); 
		product.setId(id);
		prductDao.addProduct(product);
	}

	@Override
	public Product findById(String id) {
		// TODO Auto-generated method stub
		return prductDao.findById(id);
	}

	@Override
	public void editProduct(Product product) {
		// TODO Auto-generated method stub
		prductDao.deleteById(product.getId());
		prductDao.addProduct(product);
	}

}
