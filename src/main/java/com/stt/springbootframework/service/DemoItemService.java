package com.stt.springbootframework.service;

import com.stt.springbootframework.entity.DemoItem;

import java.util.List;

public interface DemoItemService {

    void saveDemoItem(DemoItem demoItem);

    void updateDemoItem(DemoItem demoItem);

    void deleteDemoItem(String demoItemId);

    DemoItem queryDemoItemById(String demoItemId);

    List<DemoItem> queryDemoItemList(DemoItem demoItem);

    List<DemoItem> queryDemoItemListPaged(DemoItem demoItem, Integer page, Integer pageSize);

    DemoItem queryDemoItemByIdCustom(String demoItemId);

    void saveDemoItemTransactional(DemoItem demoItem);
}
