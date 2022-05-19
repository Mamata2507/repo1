package com.qianfeng.ssm.service.impl;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.qianfeng.ssm.dao.IPermissionDao;
import com.qianfeng.ssm.domain.Permission;
import com.qianfeng.ssm.service.IPermissionService;

@Service
@Transactional(propagation = Propagation.REQUIRED,readOnly = false)
public class PermissionServiceImpl implements IPermissionService {
   
	@Autowired
	private IPermissionDao permissionDao;
	
	@Override
	public List<Permission> findAll() {
		// TODO Auto-generated method stub
		return permissionDao.findAll();
	}

	@Override
	public void addPermission(Permission permission) {
		// TODO Auto-generated method stub
		String permissionId = UUID.randomUUID().toString();
		permission.setId(permissionId);
		permissionDao.insertPermission(permission);

	}

}
