package com.blackcat.frame.core.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blackcat.frame.core.dao.SysUserMapper;
import com.blackcat.frame.core.model.SysUser;

@Service
public class SysUserServiceImpl implements SysUserService {
	
	@Autowired
	private SysUserMapper sysUserMapper;
	//
	@Override
	public boolean validateUser(SysUser user) {
		if(user == null) {
			return false;
		}
		SysUser chek = sysUserMapper.selectByPrimaryKey(user.getUserid());
		if(chek != null && chek.getPasswd().equalsIgnoreCase(user.getPasswd())) {
			return true;
		}
		return false;
	}
	
	@Override
	public SysUser queryUserDetail(String userid) {
		return sysUserMapper.selectByPrimaryKey(userid);
	}
}
