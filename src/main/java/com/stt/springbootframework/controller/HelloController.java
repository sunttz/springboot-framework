package com.stt.springbootframework.controller;

import com.stt.springbootframework.entity.JsonResult;
import com.stt.springbootframework.entity.User;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class HelloController {

    @RequestMapping("/hello")
    public JsonResult Hello(){
        List<User> users = new ArrayList<>();
        User user = new User();
        user.setId("1");
        user.setAge(24);
        user.setName("zhangsan");
        user.setPassword("123456");
        user.setSex("1");
        users.add(user);

        User user2 = new User();
        user2.setId("1");
        user2.setAge(24);
        user2.setName("zhangsan");
        user2.setPassword("123456");
        user2.setSex("1");
        users.add(user2);
        return JsonResult.ok(users);
    }
}
