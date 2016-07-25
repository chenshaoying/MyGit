package com.blackcat.frame.core.dao;

import com.blackcat.frame.core.model.SysMenu;

public interface SysMenuMapper {
    int deleteByPrimaryKey(String menucd);

    int insert(SysMenu record);

    int insertSelective(SysMenu record);

    SysMenu selectByPrimaryKey(String menucd);

    int updateByPrimaryKeySelective(SysMenu record);

    int updateByPrimaryKey(SysMenu record);
}