package com.stt.springbootframework;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.stt.springbootframework.dao")
public class SpringbootFrameworkApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootFrameworkApplication.class, args);
    }
}
