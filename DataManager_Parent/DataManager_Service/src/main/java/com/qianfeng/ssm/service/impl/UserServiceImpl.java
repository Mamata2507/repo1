package com.qianfeng.ssm.service.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.qianfeng.ssm.dao.IUserDao;
import com.qianfeng.ssm.domain.Role;
import com.qianfeng.ssm.domain.UserInfo;
import com.qianfeng.ssm.service.IUserService;

/*
 * 认证服务类
 */
@Service("userService")
@Transactional(propagation = Propagation.REQUIRED,readOnly = false)
public class UserServiceImpl implements IUserService {
	
	@Autowired
	private IUserDao userDao;
	
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		UserInfo userInfo = userDao.findByUsername(username);
		User user = null;
		if(userInfo != null) {//明文  密文
			user = new User(userInfo.getUsername(),userInfo.getPassword(),userInfo.getStatus() == 1 ? true : false,true,true,true,getGrantedAuthority(userInfo.getRoles()));
		}else {
			throw new RuntimeException("用户不存在!!!");
		}
		
		//	public User(String username, String password,Collection<? extends GrantedAuthority> authorities)
		return user;
	}

	private Collection<? extends GrantedAuthority> getGrantedAuthority(List<Role> roles) {
		// TODO Auto-generated method stub
		//原本应该根据用户名去数据库中查询  先暂时写死
		//ROLE_ADMIN','ROLE_USER
		ArrayList<GrantedAuthority> list = new ArrayList<>();
		for (Role role : roles) {
			list.add(new SimpleGrantedAuthority("ROLE_"+role.getRoleName()));
		}
		return list;
	}

	@Override
	public List<UserInfo> findAll() {
		// TODO Auto-generated method stub
		return userDao.findAll();
	}

	@Override
	public void addUserInfo(UserInfo userInfo) {
		String password = bCryptPasswordEncoder.encode(userInfo.getPassword());
		userInfo.setPassword(password);
		// TODO Auto-generated method stub
		String id = UUID.randomUUID().toString();
		userInfo.setId(id);
		userDao.insertUserInfo(userInfo);
	}

	@Override
	public UserInfo findById(String id) {
		// TODO Auto-generated method stub
		return userDao.findById(id);
	}

	@Override
	public List<Role> findUserByIdAndAllRole(String userId) {
		// TODO Auto-generated method stub
		return userDao.findUserByIdAndAllRole(userId);
	}

	@Override
	public void addRoleToUser(String userId, String[] roleIds) {
		// TODO Auto-generated method stub
		//遍历数组 遍历一次往中间表插入一次
		for (String roleId : roleIds) {
			userDao.insertUsersAndRole(userId,roleId);
		}
	}

}
