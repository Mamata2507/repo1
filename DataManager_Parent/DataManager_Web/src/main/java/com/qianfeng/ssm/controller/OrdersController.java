package com.qianfeng.ssm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.github.pagehelper.PageInfo;
import com.qianfeng.ssm.domain.Orders;
import com.qianfeng.ssm.service.IOrdersService;

@RequestMapping("/orders")
@Controller
public class OrdersController {
	
	@Autowired
	private IOrdersService ordersService;
	
	@RequestMapping("/findAll")
	@PreAuthorize("hasRole('ROLE_USER')")//spel表达式
	public ModelAndView findAll(@RequestParam(value = "page",defaultValue = "1",required = true)Integer pageNum,@RequestParam(value = "pageSize",defaultValue = "5",required = true)Integer pageSize) {
		ModelAndView mav = new ModelAndView();
		//列表数据
		List<Orders> ordersList = ordersService.findAll(pageNum, pageSize);
		PageInfo pageInfo = new PageInfo(ordersList);
		mav.addObject("pageInfo",pageInfo);
		mav.setViewName("orders-list");
		return mav;
	}
	
	@RequestMapping("/findById")
	@PreAuthorize("authentication.principal.username=='wanglaohu'")
	public ModelAndView findById(String id) {
		Orders orders = ordersService.findById(id);
		ModelAndView mav = new ModelAndView();
		mav.addObject("orders",orders);
		mav.setViewName("orders-show");
		return mav;
	}

}
