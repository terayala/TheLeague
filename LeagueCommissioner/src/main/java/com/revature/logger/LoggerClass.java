package com.revature.logger;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.log4j.Logger;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class LoggerClass {
	
	final static Logger logger = Logger.getLogger(LoggerClass.class);

	@Pointcut("execution(public * create*(..))")
	public void logCreate() {
		
	}
	
	@Pointcut("execution(public * update*(..))")
	public void logUpdate() {
		
	}
	
	@After("logCreate()")
	public void createSuccess() {
		System.out.println("test print");
		SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss"); 
		logger.info("Inserted into database at " + sdf.format(new Date(System.currentTimeMillis())));
	}
	
	@After("logUpdate()")
	public void updateSuccess() {
		System.out.println("test print");
		SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss"); 
		logger.info("Updated database at " + sdf.format(new Date(System.currentTimeMillis())));
	}
}
