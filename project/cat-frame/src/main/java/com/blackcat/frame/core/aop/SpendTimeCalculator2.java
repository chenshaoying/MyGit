package com.blackcat.frame.core.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.blackcat.frame.core.annotation.Calculator;

public class SpendTimeCalculator2 {
	
	private static Logger log = LoggerFactory.getLogger(SpendTimeCalculator2.class);
	

	public Object around(ProceedingJoinPoint pjp, Calculator calculator) throws Throwable {
		log.info(calculator.message());
		long start = System.currentTimeMillis();
		log.info("start at:" + start);
		Object obj = pjp.proceed();
		log.info("spend time:" + (System.currentTimeMillis() - start));
		return obj;
	}

}
