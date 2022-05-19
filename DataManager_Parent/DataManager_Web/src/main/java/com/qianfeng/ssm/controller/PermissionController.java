package com.qianfeng.ssm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.qianfeng.ssm.domain.Permission;
import com.qianfeng.ssm.service.IPermissionService;

@Controller
@RequestMapping("/permission")
public class PermissionController {
	
	@Autowired
	private IPermissionService permissionService;
	
	@RequestMapping("/findAll")
	public ModelAndView findAll() {
		List<Permission> permissions = permissionService.findAll();
		ModelAndView mav = new ModelAndView();
		mav.addObject("permissionList",permissions);
		mav.setViewName("/permission-list");
		return mav;
	}
	
	@RequestMapping("/save")
	public String addPermission(Permission permission) {
		permissionService.addPermission(permission);
		return "redirect:/permission/findAll";
	}
	
	
	

}
