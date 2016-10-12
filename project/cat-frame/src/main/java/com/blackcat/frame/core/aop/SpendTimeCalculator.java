package com.blackcat.frame.core.aop;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.blackcat.frame.core.annotation.Calculator;

public class SpendTimeCalculator {
	
	private static Logger log = LoggerFactory.getLogger(SpendTimeCalculator.class);
	
	private static ThreadLocal<Long> local = new ThreadLocal<Long>();
	public void after(Calculator calculator) {
		long end = System.currentTimeMillis();
		log.info("spend time:" + (end - local.get()) + "ms");
	}
	
	public void before(Calculator calculator) {
		long start = System.currentTimeMillis();
		log.info("start at:" + start);
		local.set(start);
	}

}
