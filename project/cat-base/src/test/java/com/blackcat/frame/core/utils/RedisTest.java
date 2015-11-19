package com.blackcat.frame.core.utils;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath*:spring-config.xml"})  
public class RedisTest extends AbstractJUnit4SpringContextTests {  
    
	@Autowired
	private RedisClient redisClient;
	
	@Test
	public void testGetSeq() {
		System.out.print(redisClient.getSeq("xxxx"));
	}
    
}
