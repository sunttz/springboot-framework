package com.stt.springbootframework.service.impl;

import com.github.pagehelper.PageHelper;
import com.stt.springbootframework.dao.DemoItemCustomDao;
import com.stt.springbootframework.dao.DemoItemDao;
import com.stt.springbootframework.entity.DemoItem;
import com.stt.springbootframework.service.DemoItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.thymeleaf.util.StringUtils;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

@Service
public class DemoItemServiceImpl implements DemoItemService {

    @Autowired
    DemoItemDao demoItemDao;

    @Autowired
    DemoItemCustomDao demoItemCustomDao;

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public void saveDemoItem(DemoItem demoItem) {
        demoItemDao.insert(demoItem);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public void updateDemoItem(DemoItem demoItem) {
        demoItemDao.updateByPrimaryKeySelective(demoItem); // 只更新设置字段
        // demoItemDao.updateByPrimaryKey(demoItem);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public void deleteDemoItem(String demoItemId) {
        demoItemDao.deleteByPrimaryKey(demoItemId);
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public DemoItem queryDemoItemById(String demoItemId) {
        return demoItemDao.selectByPrimaryKey(demoItemId);
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public List<DemoItem> queryDemoItemList(DemoItem demoItem) {
        Example example = new Example(DemoItem.class);
        Example.Criteria criteria = example.createCriteria();

        if (!StringUtils.isEmptyOrWhitespace(demoItem.getName())) {
//			criteria.andEqualTo("username", user.getUsername());
            criteria.andLike("name", "%" + demoItem.getName() + "%");
        }
        List<DemoItem> userList = demoItemDao.selectByExample(example);
        return userList;
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public List<DemoItem> queryDemoItemListPaged(DemoItem demoItem, Integer page, Integer pageSize) {
        // 开始分页
        PageHelper.startPage(page, pageSize);

        Example example = new Example(DemoItem.class);
        Example.Criteria criteria = example.createCriteria();

        if (!StringUtils.isEmptyOrWhitespace(demoItem.getName())) {
            criteria.andLike("name", "%" + demoItem.getName() + "%");
        }
        example.orderBy("amount").desc();
        List<DemoItem> userList = demoItemDao.selectByExample(example);
        return userList;
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public DemoItem queryDemoItemByIdCustom(String demoItemId) {
        List<DemoItem> demoItems = demoItemCustomDao.queryDemoItemByIdCustom(demoItemId);
        if(demoItems != null && !demoItems.isEmpty()){
            return demoItems.get(0);
        }
        return null;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public void saveDemoItemTransactional(DemoItem demoItem) {
        demoItemDao.insert(demoItem);

        int a = 1 / 0;

        demoItem.setAmount(10000);
        demoItemDao.updateByPrimaryKeySelective(demoItem);
    }
}
