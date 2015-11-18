package com.blackcat.frame.core.dao;

import com.blackcat.frame.core.model.KnpUser;

public interface KnpUserMapper {
    int deleteByPrimaryKey(String userid);

    int insert(KnpUser record);

    int insertSelective(KnpUser record);

    KnpUser selectByPrimaryKey(String userid);

    int updateByPrimaryKeySelective(KnpUser record);

    int updateByPrimaryKey(KnpUser record);
    
    
}