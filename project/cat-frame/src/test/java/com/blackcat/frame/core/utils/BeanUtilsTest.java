package com.blackcat.frame.core.utils;

import static org.junit.Assert.assertEquals;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

import com.blackcat.frame.core.model.SysUser;

public class BeanUtilsTest {
	@Test
	public void test1() {
		SysUser user = new SysUser();
		user.setUserid("111111");
		user.setUserna("xxx");
		user.setEmail("123@qq.com");
		
		Map<String, Object> map = BeanUtils.toMap(user);
		
		long start = System.currentTimeMillis();
		SysUser newUser = BeanUtils.mapToBean(map, SysUser.class);
		System.out.println(System.currentTimeMillis() - start);
		/*assertEquals(user.getUserid(), newUser.getUserid());
		assertEquals(user.getUserna(), newUser.getUserna());
		assertEquals(user.getEmail(), newUser.getEmail());*/

	}
	
	@Test
	public void test2() {
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("x", "XX");
		map.put("y", "wrong date");		
		Ref ref = BeanUtils.mapToBean(map, Ref.class);
		
	}
	
	@Test
	public void test3() {
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("x", 1);
		map.put("z", "wrong date");		
		Ref ref = BeanUtils.mapToBean(map, Ref.class);
		
	}
	
}

 class Ref {
	private int x;
	private String y;
	public Ref() {
		
	}
}
