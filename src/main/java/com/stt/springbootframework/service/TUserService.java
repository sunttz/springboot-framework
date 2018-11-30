package com.stt.springbootframework.service;

import com.github.pagehelper.PageInfo;
import com.stt.springbootframework.entity.TUser;

public interface TUserService {

    int addTUser(TUser tUser);

    void saveTUserTransactional(TUser tUser);

    PageInfo<TUser> findAllUser(int pageNum, int pageSize);

}
