package com.qianfeng.ssm.service;

import java.util.List;

import com.qianfeng.ssm.domain.SysLog;

public interface ISysLogService {

	void addSysLog(SysLog sysLog);

	List<SysLog> findAll();

}
