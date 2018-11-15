package com.neo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringBootShiroApplication {

//    SpringBoot--实现shiro（权限）框架
    public static void main(String[] args) {
        System.out.println("-----------" + System.getProperty("user.dir"));
        SpringApplication.run(SpringBootShiroApplication.class, args);
    }
}