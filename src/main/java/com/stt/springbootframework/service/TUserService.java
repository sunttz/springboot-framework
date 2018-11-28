package com.stt.springbootframework.service;

import com.github.pagehelper.PageInfo;
import com.stt.springbootframework.entity.TUser;

public interface TUserService {

    int addTUser(TUser tUser);

    PageInfo<TUser> findAllUser(int pageNum, int pageSize);

//    PageInfo<TUser> findUsersByUser(int pageNum, int pageSize, TUser tUser);
}
