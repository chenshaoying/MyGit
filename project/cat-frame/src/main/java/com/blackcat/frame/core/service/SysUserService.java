package com.blackcat.frame.core.service;

import java.util.List;

import com.blackcat.frame.core.model.SysUser;

public interface SysUserService {
	
	//
	boolean validateUser(SysUser user);
	
	//
	SysUser queryUserDetail(String userid);
	
	//
	List<SysUser> getUsersSelective(SysUser condition);
	
	//
	void addUser(SysUser user);
}
