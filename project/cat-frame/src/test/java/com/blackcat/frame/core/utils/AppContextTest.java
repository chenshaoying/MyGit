package com.blackcat.frame.core.utils;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.blackcat.frame.core.context.AppContext;
import com.blackcat.frame.core.service.SysUserService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath*:spring-config.xml"})  
public class AppContextTest {
	@Test
	public void getBeanByNameTest() {
		String beanName = "sysUserService";
		SysUserService sys = (SysUserService) AppContext.getBeanByName(beanName);
		sys.queryUserDetail("admina");
	}
}
