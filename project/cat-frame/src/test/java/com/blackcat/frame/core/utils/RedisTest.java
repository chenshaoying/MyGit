/*package com.blackcat.frame.core.utils;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.blackcat.frame.core.model.SysUser;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath*:spring-config.xml"})  
public class RedisTest extends AbstractJUnit4SpringContextTests {  
    
	@Autowired
	private RedisClient redisClient;
	
	@Test
	public void testGetSeq() {
		System.out.print(redisClient.getSeq("xxxx"));
	}
    
	@Test
	public void test2() {
		redisClient.addKeyString("key1", "1111");
	}
	
	@Test
	public void test3() {
		System.out.println("-----------" + redisClient.getKeyString("key1"));
	}
	
	@Test
	public void test4() {
		String key = "mapkey2";
		redisClient.addMap(key, "k1", "1");
		redisClient.addMap(key, "k2", "2");
		
		Map<Object,Object> m = new HashMap<Object,Object>();
		m.put("k1", "1");
		m.put("k2", "2");
		redisClient.addMap(key, m);
		Map<Object,Object> r =  redisClient.getMap(key);
		if(r != null) {
			for(Object o:r.keySet()) {
				System.out.println(o + "：" + r.get(o));
			}
		}
	}
	
	@Test
	public void test5() {
		SysUser user = new SysUser();
		user.setUserid("000000");
		redisClient.addObject("user1", user);
		
		SysUser r = (SysUser) redisClient.getObject("user1");
		System.out.println("----------" + r.getUserid());
	}
	
	@Test
	public void test6() {
		SysUser user = new SysUser();
		user.setUserid("000000");
		redisClient.addList("list1", user);
		redisClient.addList("list2", user,user,user);
	}
	
	@Test
	public void test7() {
		System.out.println(redisClient.contains("shiro_session"));
	}
}
*/