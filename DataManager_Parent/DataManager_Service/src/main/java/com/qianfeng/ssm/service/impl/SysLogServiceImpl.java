package com.qianfeng.ssm.service.impl;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.qianfeng.ssm.dao.ISysLogDao;
import com.qianfeng.ssm.domain.SysLog;
import com.qianfeng.ssm.service.ISysLogService;

@Service
@Transactional(propagation = Propagation.REQUIRED,readOnly = false)
public class SysLogServiceImpl implements ISysLogService {

	@Autowired
	private ISysLogDao sysLogDao;
	 
	@Override
	public void addSysLog(SysLog sysLog) {
		// TODO Auto-generated method stub
		String sysLogId = UUID.randomUUID().toString();
		sysLog.setId(sysLogId);
		sysLogDao.insertSysLog(sysLog);
	}

	@Override
	public List<SysLog> findAll() {
		// TODO Auto-generated method stub
		return sysLogDao.findAll();
	}

}
