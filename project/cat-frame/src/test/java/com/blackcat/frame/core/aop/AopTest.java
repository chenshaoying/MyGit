package com.blackcat.frame.core.aop;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath*:spring-config.xml"})  
public class AopTest {
	@Autowired
	private AuthService authService;
	@Test
	public void auth() {
		authService.auth();
	}
	
	@Test
	public void notAuth() {
		authService.notAuth();
	}
	
	@Test
	public void authLoop() {
		for(int i=0; i < 5; i++) {
			authService.auth();			
		}
	}
	
	@Test
	public void authMutlipleThread() throws InterruptedException {
		Thread t1 = new Thread(new Runnable() {

			@Override
			public void run() {
				// TODO Auto-generated method stub
				authService.auth();	
			}
			
		});
		Thread t2 = new Thread(new Runnable() {

			@Override
			public void run() {
				// TODO Auto-generated method stub
				authService.auth();	
			}
			
		}, "t2");
		
		t1.start();
		t2.start();
		t1.join();
		t2.join();
	}
}
