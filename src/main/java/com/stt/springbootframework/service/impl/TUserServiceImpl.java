package com.stt.springbootframework.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.stt.springbootframework.dao.TUserDao;
import com.stt.springbootframework.entity.TUser;
import com.stt.springbootframework.service.TUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class TUserServiceImpl implements TUserService {

    @Autowired
    TUserDao tUserDao;

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public int addTUser(TUser tUser) {
        return tUserDao.insert(tUser);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public void saveTUserTransactional(TUser tUser) {
        tUserDao.insert(tUser);
        //int i = 1/0;
        TUser t = new TUser();
        t.setUserid(1008);
        t.setUsername("zhangsan");
        tUserDao.updateByPrimaryKeySelective(t);
    }

    /**
     * @param pageNum  开始页数
     * @param pageSize 每页显示的数据条数
     * @return
     */
    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public PageInfo<TUser> findAllUser(int pageNum, int pageSize) {
        //将参数传给这个方法就可以实现物理分页了，非常简单。
        PageHelper.startPage(pageNum, pageSize);
        List<TUser> tUsers = tUserDao.selectAll();
        PageInfo result = new PageInfo(tUsers);
        return result;
    }

//    @Override
//    public PageInfo<TUser> findUsersByUser(int pageNum, int pageSize, TUser tUser) {
//        PageHelper.startPage(pageNum, pageSize);
//        Example example = new Example(TUser.class);
//        Example.Criteria criteria = example.createCriteria();
//        if (!StringUtils.isEmptyOrWhitespace(tUser.getUsername())) {
//            criteria.andLike("username", "%" + tUser.getUsername() + "%");
//        }
//        if (!StringUtils.isEmptyOrWhitespace(tUser.getPassword())) {
//            criteria.andLike("password", "%" + tUser.getPassword() + "%");
//        }
//        example.orderBy("username").desc();
//        List<TUser> tUsers = tUserDao.selectByExample(example);
//        PageInfo result = new PageInfo(tUsers);
//        return result;
//    }
}
