package com.qianfeng.ssm.service;

import java.util.List;

import com.qianfeng.ssm.domain.Orders;

public interface IOrdersService {
	
	public List<Orders> findAll(int page,int pageSize);

	public Orders findById(String id);

}
