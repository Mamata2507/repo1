package com.qianfeng.ssm.service;

import java.util.List;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.qianfeng.ssm.domain.Role;
import com.qianfeng.ssm.domain.UserInfo;

public interface IUserService extends UserDetailsService {

	List<UserInfo> findAll();

	void addUserInfo(UserInfo userInfo);

	UserInfo findById(String id);

	List<Role> findUserByIdAndAllRole(String userId);

	void addRoleToUser(String userId, String[] roleIds);

}
