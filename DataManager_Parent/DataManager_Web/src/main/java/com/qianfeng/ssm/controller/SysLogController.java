package com.qianfeng.ssm.controller;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.qianfeng.ssm.domain.SysLog;
import com.qianfeng.ssm.service.ISysLogService;

/*
 * 通知类
 */
@Component
@Aspect
@RequestMapping("/sysLog")
public class SysLogController {
	
	
	
	@Autowired
	private ISysLogService sysLogService;
	
	@Autowired
	private HttpServletRequest request;
	
	/*
	 * visitTime	timestamp	访问时间  前置
	 * username	VARCHAR2	操作者用户名  后置
	 * ip	VARCHAR2	访问ip 后置
	 * url	VARCHAR2	访问资源url  后置
	 * executionTime	int	执行时长 后置
	 * method	VARCHAR	访问方法  前置
	 */
	private Date visitTime;//记录访问的时间
	private Class clazz;//获取被访问的controller的class对象
	private String methodName;//获取用户发起请求对应Controller的方法名称
	private Method method;////获取用户发起请求对应Controller的方法对象
	
	//前置通知
	@Before("execution(* com.qianfeng.ssm.controller.*.*(..))")
	public void beforeLog(JoinPoint  jp) throws Exception {//环绕 获取到真实对象 真实对象调用的方法 调用方法所需的参数
		//获取访问的时间
		visitTime = new Date();
		//获取用户发起请求对应的Controller
		clazz = jp.getTarget().getClass();
		//获取用户发起请求对应Controller的方法名称
		methodName = jp.getSignature().getName();
		//获取方法执行时的参数
		Object[] paramArgs = jp.getArgs();
		//获取用户发起请求对应Controller的方法对象
		if(paramArgs == null || paramArgs.length <= 0) {
			method = clazz.getMethod(methodName);
		}else {
			//创建数组存储方法参数的数据类型
			Class[] paramArgsClass = new Class[paramArgs.length];
			for (int i = 0;i < paramArgs.length;i++) {
				paramArgsClass[i] = paramArgs[i].getClass();
			}
			method = clazz.getMethod(methodName, paramArgsClass);
		}
	}
	
	//后置通知
	@After("execution(* com.qianfeng.ssm.controller.*.*(..))")
	public void afterLog() {
		//创建SysLog对象存储日志信息
		SysLog sysLog = new SysLog();
		//获取访问的ip
		String ip = request.getRemoteAddr();
		//记录访问的url
		String url = null;
		//得到操作者用户
		String username = null;
		//记录访问的时长
		long executionTime = 0;
		//获取url 判断clazz上方有没有RequestMapping 以及  method上方有没有RequestMapping
		if(clazz.isAnnotationPresent(RequestMapping.class)) {
			//获取Controller类上方的url
			RequestMapping requestMappingClass = (RequestMapping) clazz.getAnnotation(RequestMapping.class);
			String classUrl = requestMappingClass.value()[0];
			if(method.isAnnotationPresent(RequestMapping.class)) {
				//获取方法上方的url
				RequestMapping requestMappingMethod = (RequestMapping) method.getAnnotation(RequestMapping.class);
				String methodUrl = requestMappingMethod.value()[0];
				//记录访问的url
				url = classUrl + methodUrl;
				//得到操作者用户
				//依靠security的上下文对象
				SecurityContext context = SecurityContextHolder.getContext();
				username = context.getAuthentication().getName();
				//记录访问的时长
				executionTime = new Date().getTime() - visitTime.getTime();
			}
		}
		sysLog.setIp(ip);
		sysLog.setUrl(url);
		sysLog.setMethod("[类名]" + clazz.getName() + "[方法名]" + methodName);
		sysLog.setVisitTime(visitTime);
		sysLog.setUsername(username);
		sysLog.setExecutionTime(executionTime);
		sysLogService.addSysLog(sysLog);
		
	}
	
	@RequestMapping("/findAll")
	public ModelAndView findAll() {
		ModelAndView mav = new ModelAndView();
		List<SysLog> sysLogs = sysLogService.findAll();
		mav.addObject("sysLogs",sysLogs);
		mav.setViewName("/syslog-list");
		return mav;
	}

}
