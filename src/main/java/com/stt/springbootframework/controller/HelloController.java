package com.stt.springbootframework.controller;

import com.stt.springbootframework.entity.JsonResult;
import com.stt.springbootframework.entity.Resource;
import com.stt.springbootframework.entity.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
public class HelloController {

    private static final Logger log = LoggerFactory.getLogger(HelloController.class);
    @Autowired
    Resource resource;

    @RequestMapping("/hello")
    public JsonResult Hello() {
        List<User> users = new ArrayList<>();
        User user = new User();
        user.setId("1");
        user.setAge(24);
        user.setName("zhangsan");
        user.setPassword("123456");
        user.setSex("1");
        user.setBirthday(new Date());
        users.add(user);

        User user2 = new User();
        user2.setId("3");
        user2.setAge(24);
        user2.setName("zhangsan");
        user2.setPassword("123456");
        user2.setSex("1");
        user2.setBirthday(new Date());
        user2.setDesc("desc");
        users.add(user2);
        log.info("success");
        return JsonResult.ok(users);
    }

    @RequestMapping("/getResource")
    public JsonResult getResource() {
        Resource res = new Resource();
        BeanUtils.copyProperties(resource, res);
        return JsonResult.ok(res);
    }
}
