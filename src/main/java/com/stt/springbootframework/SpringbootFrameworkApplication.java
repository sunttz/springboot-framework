package com.stt.springbootframework;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@MapperScan("com.stt.springbootframework.dao")
//开启定时任务
@EnableScheduling
//开启异步调用方法
@EnableAsync
public class SpringbootFrameworkApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootFrameworkApplication.class, args);
    }
}
