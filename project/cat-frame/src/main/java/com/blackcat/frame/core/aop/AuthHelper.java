package com.blackcat.frame.core.aop;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.blackcat.frame.core.annotation.Auth;

public class AuthHelper {
	
	private static Logger log = LoggerFactory.getLogger(AuthHelper.class);
	
	private AuthHelper() {
		log.info("create authHelper");
	}
	public void after(Auth auth) {
		// TODO Auto-generated method stub
		log.info("after returning" + auth.message());
	}
	
	public void before(Auth auth) {
		// TODO Auto-generated method stub
		log.info("before ..." + auth.message());
		
		
	}

}
