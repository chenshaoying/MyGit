package com.blackcat.frame.core.service;

import com.blackcat.frame.core.model.SysUser;

public interface SysUserService {
	
	//
	boolean validateUser(SysUser user);
	
	//
	SysUser queryUserDetail(String userid);
}
