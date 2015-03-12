package com.sapient.springapp.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.sapient.springapp.web.controller.CustomerController;

@Aspect
public class SpringAppLoggingAspect {

	final Logger logger = LoggerFactory.getLogger(SpringAppLoggingAspect.class);	

    //@Before("execution(* com.sapient.springapp.jpa.PolicyServiceImpl.*(..))")
	//@Before("within(com.sapient.springapp..*)")
    public void logBefore(JoinPoint joinPoint)
    {
        logger.info("Aspect.logBefore() : " + joinPoint.getSignature());
    }
     
    //@After("within(com.sapient.springapp..*)")
    public void logAfter(JoinPoint joinPoint)
    {
    	logger.info("Aspect.logAfter() : " + joinPoint.getSignature());
    }	
	
}
