package com.qianfeng.ssm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.qianfeng.ssm.domain.Role;
import com.qianfeng.ssm.domain.UserInfo;
import com.qianfeng.ssm.service.IUserService;

@Controller
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private IUserService userService;
	
	@RequestMapping("/findAll")
	public ModelAndView findAll() {
		List<UserInfo> users = userService.findAll();
		ModelAndView mav = new ModelAndView();
		mav.addObject("userList",users);
		mav.setViewName("/user-list");
		return mav;
	}
	
	@RequestMapping("/save")
	public String addUserInfo(UserInfo userInfo) {
		userService.addUserInfo(userInfo);
		return "redirect:/user/findAll";
	}
	
	@RequestMapping("/findById")
	public ModelAndView findById(String id) {
		UserInfo userInfo = userService.findById(id);
		ModelAndView mav = new ModelAndView();
		mav.addObject("user",userInfo);
		mav.setViewName("/user-show");
		return mav;
	}
	
	@RequestMapping("/findUserByIdAndAllRole")
	public ModelAndView findUserByIdAndAllRole(@RequestParam("id")String userId) {
		List<Role> roles = userService.findUserByIdAndAllRole(userId);
		UserInfo userInfo = userService.findById(userId);
		ModelAndView mav = new ModelAndView();
		mav.addObject("roleList",roles);
		mav.addObject("user",userInfo);
		mav.setViewName("/user-role-add");
		return mav;
	}
	
	@RequestMapping("/addRoleToUser")
	public String addRoleToUser(@RequestParam("userId")String userId,@RequestParam("ids")String[] roleIds) {
		userService.addRoleToUser(userId,roleIds);
		return "redirect:/user/findAll";
	}

}
