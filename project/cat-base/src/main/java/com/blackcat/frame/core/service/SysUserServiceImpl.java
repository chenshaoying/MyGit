package com.blackcat.frame.core.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.blackcat.frame.core.dao.SysUserMapper;
import com.blackcat.frame.core.exception.ServiceException;
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

	@Override
	public List<SysUser> getUsersSelective(SysUser condition) {		
		return sysUserMapper.querySelective(condition);
	}

	@Override
	@Transactional(propagation=Propagation.REQUIRED)
	public void addUser(SysUser user) {
		// TODO Auto-generated method stub
		if(sysUserMapper.selectByPrimaryKey(user.getUserid()) != null) {
			throw new ServiceException(user.getUserid() + "已经存在");
		}
		sysUserMapper.insert(user);
	}
}
