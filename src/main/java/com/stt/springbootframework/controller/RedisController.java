package com.stt.springbootframework.controller;

import com.stt.springbootframework.entity.JsonResult;
import com.stt.springbootframework.entity.TUser;
import com.stt.springbootframework.utils.JsonUtils;
import com.stt.springbootframework.utils.RedisOperator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/redis")
public class RedisController {
    @Autowired
    private StringRedisTemplate strRedis;

    @Autowired
    RedisOperator redisOperator;

    @RequestMapping("/test")
    public JsonResult test() {

        //strRedis.opsForValue().set("stt-cache", "hello stt2~~~~~~");

        TUser t = new TUser();
        t.setUsername("zhangsan");
        t.setPassword("123");
        t.setPhone("110");
        strRedis.opsForValue().set("json:tuser", JsonUtils.objectToJson(t));

        TUser tUser = JsonUtils.jsonToPojo(strRedis.opsForValue().get("json:tuser"), TUser.class);

        return JsonResult.ok(tUser);
    }

    @RequestMapping("test2")
    public JsonResult test2() {
        TUser t = new TUser();
        t.setUsername("lisi");
        t.setPassword("123");
        t.setPhone("110");
        redisOperator.set("user", JsonUtils.objectToJson(t), 60);
        TUser tUser = JsonUtils.jsonToPojo(redisOperator.get("user"), TUser.class);
        return JsonResult.ok(tUser);
    }

}
