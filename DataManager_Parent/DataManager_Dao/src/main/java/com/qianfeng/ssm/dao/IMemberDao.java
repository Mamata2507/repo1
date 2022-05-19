package com.qianfeng.ssm.dao;

import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import com.qianfeng.ssm.domain.Member;

@Repository
public interface IMemberDao {
	
	@Select("select * from member where id = #{id}")
	public Member findById(String id);

}
