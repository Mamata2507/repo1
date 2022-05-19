package com.qianfeng.ssm.dao;



import java.util.List;

import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.mapping.FetchType;
import org.springframework.stereotype.Repository;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.Param;

import com.qianfeng.ssm.domain.Role;
import com.qianfeng.ssm.domain.UserInfo;

@Repository
public interface IUserDao {
	
	@Select("select * from users where username = #{username}")
	@Results({
		@Result(id=true,column = "id",property = "id"),
		@Result(column = "email",property = "email"),
		@Result(column = "username",property = "username"),
		@Result(column = "password",property = "password"),
		@Result(column = "phoneNum",property = "phoneNum"),
		@Result(column = "status",property = "status"),
		@Result(column = "id",property = "roles",javaType = List.class,many = @Many(select = "com.qianfeng.ssm.dao.IRoleDao.findByUserId",fetchType = FetchType.LAZY))
	})
	public UserInfo findByUsername(String username);
    
	@Select("select * from users")
	public List<UserInfo> findAll();
    
	@Insert("insert into users(id,email,username,password,phoneNum,status) values(#{id},#{email},#{username},#{password},#{phoneNum},#{status})")
	public void insertUserInfo(UserInfo userInfo);
    
	@Select("select * from users where id = #{id}")
	@Results({
		@Result(id=true,column = "id",property = "id"),
		@Result(column = "email",property = "email"),
		@Result(column = "username",property = "username"),
		@Result(column = "password",property = "password"),
		@Result(column = "phoneNum",property = "phoneNum"),
		@Result(column = "status",property = "status"),
		@Result(column = "id",property = "roles",javaType = List.class,many = @Many(select = "com.qianfeng.ssm.dao.IRoleDao.findByUserId",fetchType = FetchType.LAZY))
	})
	public UserInfo findById(String id);
    
	@Select("SELECT * FROM role WHERE id NOT IN (SELECT roleId FROM users_role WHERE userId = #{userId})")
	public List<Role> findUserByIdAndAllRole(String userId);
    
	@Insert("insert into users_role(userId,roleId) values(#{userId},#{roleId})")
	public void insertUsersAndRole(@Param("userId")String userId, @Param("roleId")String roleId);
	/*
	 * mybaits在执行这个sql语句的时候  取值的时候，优先从userId这个参数上去取
	 * 怎么取的？ userId.getUserId()  userId.getRoleId()
	 */

}
