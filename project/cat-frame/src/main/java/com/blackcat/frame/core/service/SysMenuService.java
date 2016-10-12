package com.blackcat.frame.core.service;

import java.util.List;

import com.blackcat.frame.core.model.SysMenu;

public interface SysMenuService {
	
	List<SysMenu> getMenus(String userid);
}
