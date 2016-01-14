package com.blackcat.frame.core.proxy;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.blackcat.frame.core.context.AppContext;
import com.blackcat.frame.core.model.SysUser;
import com.blackcat.frame.core.service.SysUserService;

import org.junit.Assert;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath*:spring-config.xml"})
public class ProxyTest {
	@Test
	public void generalProxyTest() {
		SysUserService sys = AppContext.getBean(SysUserService.class);
		GeneralProxy proxy = new GeneralProxy();
		SysUserService sysProxy = (SysUserService) proxy.bind(sys);
		sysProxy.validateUser(new SysUser());
	}
	
	@Test
	public void CglibProxyTest() {
		CglibProxy proxy = new CglibProxy();
		SysUser user = (SysUser) proxy.getInstance(new SysUser());
		user.setGender("U");
		System.out.println(user.getGender());
		Assert.assertEquals("U", user.getGender());	
	}
 }
