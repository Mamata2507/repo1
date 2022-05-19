package com.qianfeng.ssm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.qianfeng.ssm.domain.Permission;
import com.qianfeng.ssm.domain.Role;
import com.qianfeng.ssm.service.IRoleService;

@Controller
@RequestMapping("/role")
public class RoleController {
	
	@Autowired
	private IRoleService roleService;
	
	@RequestMapping("/findAll")
	public ModelAndView findAll() {
		List<Role> roles = roleService.findAll();
		ModelAndView mav = new ModelAndView();
		mav.addObject("roleList",roles);
		mav.setViewName("/role-list");
		return mav;
	}
	
	@RequestMapping("/save")
	public String addRole(Role role) {
		roleService.addRole(role);
		return "redirect:/role/findAll";
	}
	
	@RequestMapping("/findRoleByIdAndAllPermission")
	public ModelAndView findRoleByIdAndAllPermission(@RequestParam("id")String roleId) {
		List<Permission> permissions = roleService.findRoleByIdAndAllPermission(roleId);
		Role role = roleService.findById(roleId);
		ModelAndView mav = new ModelAndView();
		mav.addObject("permissionList",permissions);
		mav.addObject("role",role);
		mav.setViewName("/role-permission-add");
		return mav;
	}
	
	@RequestMapping("/addRoleToPermission")
	public String addRoleToPermission(@RequestParam("roleId")String roleId,@RequestParam("ids")String[] permissionIds ) {
		roleService.addRoleToPermission(roleId,permissionIds);
		return "redirect:/role/findAll";
	}

}
