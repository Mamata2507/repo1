package com.qianfeng.ssm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.PageHelper;
import com.qianfeng.ssm.dao.IOrdersDao;
import com.qianfeng.ssm.domain.Orders;
import com.qianfeng.ssm.service.IOrdersService;

@Service
@Transactional(propagation = Propagation.REQUIRED,readOnly = false)
public class OrdersServiceImpl implements IOrdersService {
    
	@Autowired
	private IOrdersDao ordersDao;
	
	@Override
	public List<Orders> findAll(int page,int pageSize) {//页码  每页显示条数
		// TODO Auto-generated method stub
		//一定是在真正发起查询的第一行设置查询的页码以及显示条数
		PageHelper.startPage(page, pageSize);
		return ordersDao.findAll();
	}

	@Override
	public Orders findById(String id) {
		// TODO Auto-generated method stub
		return ordersDao.findById(id);
	}

}
