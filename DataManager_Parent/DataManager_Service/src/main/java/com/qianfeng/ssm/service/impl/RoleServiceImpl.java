package com.qianfeng.ssm.service.impl;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.qianfeng.ssm.dao.IRoleDao;
import com.qianfeng.ssm.domain.Permission;
import com.qianfeng.ssm.domain.Role;
import com.qianfeng.ssm.service.IRoleService;

@Service
@Transactional(propagation = Propagation.REQUIRED,readOnly = false)
public class RoleServiceImpl implements IRoleService {
	
	@Autowired
	private IRoleDao roleDao;

	@Override
	public List<Role> findAll() {
		// TODO Auto-generated method stub
		return roleDao.findAll();
	}

	@Override
	public void addRole(Role role) {
		// TODO Auto-generated method stub
		String roleId = UUID.randomUUID().toString();
		role.setId(roleId);
		roleDao.insertRole(role);
	}

	@Override
	public List<Permission> findRoleByIdAndAllPermission(String roleId) {
		// TODO Auto-generated method stub
		return roleDao.findRoleByIdAndAllPermission(roleId);
	}

	@Override
	public Role findById(String roleId) {
		// TODO Auto-generated method stub
		return roleDao.findById(roleId);
	}

	@Override
	public void addRoleToPermission(String roleId, String[] permissionIds) {
		// TODO Auto-generated method stub
		for (String permissionId : permissionIds) {
			roleDao.insertRoleAndPermission(roleId,permissionId);
		}
	}

}
