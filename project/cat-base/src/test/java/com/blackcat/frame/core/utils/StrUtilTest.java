package com.blackcat.frame.core.utils;

import org.junit.Test;

public class StrUtilTest {
	@Test
	public void l_padTest() {
		String msg = "1111";
		System.out.println(StrUtil.l_pad(msg, '0', 20));	
	}
}
