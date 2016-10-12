package com.blackcat.frame.core.utils;

import org.junit.Test;

public class RedisUtilTest {
	
	@Test
	public void test1() {
		RedisUtil cli = new RedisUtil();
		cli.set("fuck", "fuck you");
	}
}
