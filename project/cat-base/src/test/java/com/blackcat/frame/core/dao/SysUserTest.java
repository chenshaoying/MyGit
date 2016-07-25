package com.blackcat.frame.core.dao;

import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.blackcat.frame.core.model.SysUser;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath*:spring-config.xml"})  
public class SysUserTest extends AbstractJUnit4SpringContextTests {  
    
	@Autowired
	private SysUserMapper sysUserMapper;
	
	@Test
	public void testAddUser() {
		SysUser sysUser = new SysUser();
		sysUser.setUserid("admina");
		sysUser.setUserna("管理员A");
		sysUser.setPasswd("123456");
		sysUser.setGender("M");
		sysUser.setEmail("123456@qq.com");
		sysUser.setStatus("N");
		sysUser.setLastLoginTime(new Date(System.currentTimeMillis()));
		sysUserMapper.insert(sysUser);
	}
    @Test
	@Transactional(propagation=Propagation.REQUIRED)
    public void test() {
    	try {
			test1() ;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	SysUser sysUser = new SysUser();
		sysUser.setUserid("admina");
		sysUser.setUserna("管理员A");
		sysUser.setPasswd("123456");
		sysUser.setGender("M");
		sysUser.setEmail("123456@qq.com");
		sysUser.setStatus("N");
		sysUser.setLastLoginTime(new Date(System.currentTimeMillis()));
		sysUserMapper.insert(sysUser);
    }
    
    @Transactional(propagation=Propagation.REQUIRED)
    public void test1() {
    	SysUser sysUser = new SysUser();
		sysUser.setUserid("admina");
		sysUser.setUserna("管理员A");
		sysUser.setPasswd("123456");
		sysUser.setGender("M");
		sysUser.setEmail("123456@qq.com");
		sysUser.setStatus("N");
		sysUser.setLastLoginTime(new Date(System.currentTimeMillis()));
		sysUserMapper.insert(sysUser);
    }
}
