package com.qianfeng.ssm.domain;

import java.util.List;

public class Role {
	
	private String id; 
	private String roleName; 
	private String roleDesc;
	private List<Permission> permissions; 
	private List<UserInfo> userInfos;
	public Role(String id, String roleName, String roleDesc, List<Permission> permissions, List<UserInfo> userInfos) {
		super();
		this.id = id;
		this.roleName = roleName;
		this.roleDesc = roleDesc;
		this.permissions = permissions;
		this.userInfos = userInfos;
	}
	public Role() {
		super();
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getRoleName() {
		return roleName;
	}
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	public String getRoleDesc() {
		return roleDesc;
	}
	public void setRoleDesc(String roleDesc) {
		this.roleDesc = roleDesc;
	}
	public List<Permission> getPermissions() {
		return permissions;
	}
	public void setPermissions(List<Permission> permissions) {
		this.permissions = permissions;
	}
	public List<UserInfo> getUserInfos() {
		return userInfos;
	}
	public void setUserInfos(List<UserInfo> userInfos) {
		this.userInfos = userInfos;
	}
	@Override
	public String toString() {
		return "Role [id=" + id + ", roleName=" + roleName + ", roleDesc=" + roleDesc + ", permissions=" + permissions
				+ ", userInfos=" + userInfos + "]";
	}
	
	


}
