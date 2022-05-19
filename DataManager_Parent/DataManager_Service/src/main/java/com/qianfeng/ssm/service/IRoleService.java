package com.qianfeng.ssm.service;

import java.util.List;

import com.qianfeng.ssm.domain.Permission;
import com.qianfeng.ssm.domain.Role;

public interface IRoleService {

	List<Role> findAll();

	void addRole(Role role);

	List<Permission> findRoleByIdAndAllPermission(String roleId);

	Role findById(String roleId);

	void addRoleToPermission(String roleId, String[] permissionIds);

}
