package com.neo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;

@SpringBootApplication
public class SpringBootShiroApplication extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application){
        return application.sources(SpringBootShiroApplication.class);
    }

//    SpringBoot--实现shiro（权限）框架
    public static void main(String[] args) {
        System.out.println("-----------" + System.getProperty("user.dir"));
        SpringApplication.run(SpringBootShiroApplication.class, args);
    }
}