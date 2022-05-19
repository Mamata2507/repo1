package com.qianfeng.ssm.service;

import java.util.List;

import com.qianfeng.ssm.domain.Permission;

public interface IPermissionService {

	List<Permission> findAll();

	void addPermission(Permission permission);

}
