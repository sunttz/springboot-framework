package com.stt.springbootframework.controller;

import com.github.pagehelper.PageInfo;
import com.stt.springbootframework.entity.TUser;
import com.stt.springbootframework.service.TUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/tUser")
public class TUserController {

    @Autowired
    TUserService tUserService;

    @RequestMapping("/addTUser")
    public String addTUser(){
        TUser t1 = new TUser();
        t1.setUsername("test");
        t1.setPassword("123");
        t1.setPhone("110");
        tUserService.addTUser(t1);
        TUser t2 = new TUser();
        t2.setUsername("stt");
        t2.setPassword("456");
        t2.setPhone("911");
        tUserService.addTUser(t2);
        return "success";
    }

    @RequestMapping("/findAll")
    public Object findAll(@RequestParam(name = "pageNum", required = false, defaultValue = "1")
                                      int pageNum,
                          @RequestParam(name = "pageSize", required = false, defaultValue = "2")
                                      int pageSize){
        PageInfo<TUser> users = tUserService.findAllUser(pageNum, pageSize);
        return users;
    }

//    @RequestMapping("/findByUser")
//    public Object findByUser(@RequestParam(name = "pageNum", required = false, defaultValue = "1")
//                                  int pageNum,
//                          @RequestParam(name = "pageSize", required = false, defaultValue = "2")
//                                  int pageSize){
//        TUser tUser = new TUser();
//        tUser.setUsername("stt2");
//        PageInfo<TUser> users = tUserService.findUsersByUser(pageNum, pageSize, tUser);
//        return users;
//    }
}
