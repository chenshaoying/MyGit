package com.blackcat.frame.core.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blackcat.frame.core.dao.SysMenuMapper;
import com.blackcat.frame.core.model.SysMenu;

@Service("sysMenuService")
public class SysMenuServiceImpl implements SysMenuService {
	
	@Autowired
	private SysMenuMapper sysMenuMapper;

	@Override
	public List<SysMenu> getMenus(String userid) {
		// TODO Auto-generated method stub
		List<SysMenu> menus = sysMenuMapper.selectFirstLevelMenus(userid);
		return menus;
	}
	
}
