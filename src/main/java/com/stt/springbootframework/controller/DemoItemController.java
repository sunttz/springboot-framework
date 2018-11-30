package com.stt.springbootframework.controller;

import com.stt.springbootframework.entity.DemoItem;
import com.stt.springbootframework.entity.JsonResult;
import com.stt.springbootframework.service.DemoItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/demoItem")
public class DemoItemController {

    @Autowired
    DemoItemService demoItemService;

    @RequestMapping("/findById")
    public JsonResult findById(String id) {
        DemoItem demoItem = demoItemService.queryDemoItemById(id);
        return JsonResult.ok(demoItem);
    }

    @RequestMapping("/custom")
    public JsonResult queryDemoItemByIdCustom(String id){
        DemoItem demoItem = demoItemService.queryDemoItemByIdCustom(id);
        return JsonResult.ok(demoItem);
    }

    @RequestMapping("/saveDemoItemTransactional")
    public JsonResult saveDemoItemTransactional(){
        DemoItem demoItem = new DemoItem();
        demoItem.setId("20003");
        demoItem.setName("红翼");
        demoItem.setAmount(12);
        demoItemService.saveDemoItemTransactional(demoItem);
        return JsonResult.ok();
    }

    @RequestMapping("/findAll")
    public JsonResult findAll(Integer page, Integer pageSize) {
        DemoItem demoItem = new DemoItem();
        demoItem.setName("红翼");
        List<DemoItem> demoItems = demoItemService.queryDemoItemListPaged(demoItem, page, pageSize);
        return JsonResult.ok(demoItems);
    }

    @RequestMapping("/save")
    public JsonResult save() {
        DemoItem demoItem = new DemoItem();
        demoItem.setId("10000");
        demoItem.setName("stt");
        demoItem.setAmount(23);
        demoItemService.saveDemoItem(demoItem);
        return JsonResult.ok();
    }

    @RequestMapping("/update")
    public JsonResult update() {
        DemoItem demoItem = new DemoItem();
        demoItem.setId("170909FRHBS3K680");
        demoItem.setAmount(23);
        demoItemService.updateDemoItem(demoItem);
        return JsonResult.ok();
    }

    @RequestMapping("/delete")
    public JsonResult delete() {
        demoItemService.deleteDemoItem("170909FRF2P18ARP");
        return JsonResult.ok();
    }


}
