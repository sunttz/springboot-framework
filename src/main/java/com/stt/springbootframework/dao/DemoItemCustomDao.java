package com.stt.springbootframework.dao;

import com.stt.springbootframework.entity.DemoItem;

import java.util.List;

public interface DemoItemCustomDao {
    List<DemoItem> queryDemoItemByIdCustom(String id);
}
