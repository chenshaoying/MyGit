package com.blackcat.frame.core.aop;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.blackcat.frame.core.annotation.Calculator;
import com.blackcat.frame.core.annotation.NotAuth;
import com.blackcat.frame.core.annotation.NotNullable;

@Service
public class AuthService {
	private static Logger log = LoggerFactory.getLogger(AuthService.class);
	/*private static AuthService singleton;
	
	private AuthService() {
		
	}
	
	public static AuthService getInstance() {
		if(singleton == null) {
			synchronized(AuthService.class) {
				if(singleton == null) {
					singleton = new AuthService();
				}
			}
		} 
		return singleton;
	}
	*/
	//@Auth
	@Calculator
	public boolean auth() {
		log.info("testing auth...");
		return false;
	}
	
	@NotAuth
	public boolean notAuth() {
		log.info("testing not auth...");
		return false;
	}
	
	public boolean auth(@NotNullable String s) {
		log.info("testing not auth...");
		return false;
	}
}
