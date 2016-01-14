package com.blackcat.frame.core.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.blackcat.frame.core.model.SysDict;
import com.blackcat.frame.core.model.SysDictKey;

public interface SysDictMapper {
    int deleteByPrimaryKey(SysDictKey key);

    int insert(SysDict record);

    int insertSelective(SysDict record);

    SysDict selectByPrimaryKey(SysDictKey key);

    int updateByPrimaryKeySelective(SysDict record);

    int updateByPrimaryKey(SysDict record);
    
    List<SysDict> selectByCodeAndField(@Param("dictcd") String dictcd, @Param("fildcd") String fildcd);
}