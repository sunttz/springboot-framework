package com.stt.springbootframework.dao;

import com.stt.springbootframework.entity.TUser;

import java.util.List;

public interface TUserDao {
    int deleteByPrimaryKey(Integer userid);

    int insert(TUser record);

    int insertSelective(TUser record);

    TUser selectByPrimaryKey(Integer userid);

    int updateByPrimaryKeySelective(TUser record);

    int updateByPrimaryKey(TUser record);

    List<TUser> selectAll();
}