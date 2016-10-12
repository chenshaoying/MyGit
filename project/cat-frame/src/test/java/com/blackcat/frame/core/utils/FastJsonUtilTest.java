package com.blackcat.frame.core.utils;

import org.junit.Assert;
import org.junit.Test;

import com.blackcat.frame.core.model.SysUser;

public class FastJsonUtilTest {
	@Test
	public void test1() {
		SysUser user = new SysUser();
		user.setUserid("111111");
		user.setUserna("小明");
		System.out.println(FastJsonUtil.toJsonString(user));
	} 
	
	@Test
	public void test2() {
		String text = "{'userid':'111111','userna':'小明'}";		
		SysUser user = FastJsonUtil.stringToObject(text, SysUser.class);
		Assert.assertEquals("111111", user.getUserid());
	}
	
}
