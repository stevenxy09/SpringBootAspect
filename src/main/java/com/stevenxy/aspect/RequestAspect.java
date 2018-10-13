package com.stevenxy.aspect;

import javax.servlet.http.HttpServletRequest;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.stevenxy.entity.Student;

/**
* @author stevenxy E-mail:random_xy@163.com
* @Date 2018年10月13日
* @Description 
*/
@Aspect
@Component
public class RequestAspect {
	
	private Logger logger=LogManager.getLogger("RequestAspect");
	
	@Pointcut("execution(public * com.stevenxy.controller.*.*(..))")
	public void log() {
		
	}
	
	@Before("log()")
	public void doBefore(JoinPoint joinPoint) {
		logger.info("方法执行前...");
		ServletRequestAttributes sra= (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
		HttpServletRequest request=sra.getRequest();
		logger.info("url:"+request.getRequestURI());
		logger.info("ip:"+request.getRemoteHost());
		logger.info("method:"+request.getMethod());
		logger.info("class_method:"+joinPoint.getSignature().getDeclaringTypeName()+"."+joinPoint.getSignature().getName());
		logger.info("args:"+joinPoint.getArgs());
		Student student=(Student) joinPoint.getArgs()[0];
		logger.info(student);
	}
	
	@After("log()")
	public void doAfter(JoinPoint joinPoint){
		logger.info("方法执行后...");
	}
	
	@AfterReturning(returning="result",pointcut="log()")
	public void doAfterReturning(Object result){
		logger.info("方法返回值："+result);
	}
}
