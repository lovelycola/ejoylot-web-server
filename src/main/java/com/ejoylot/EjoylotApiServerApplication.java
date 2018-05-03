package com.ejoylot;

import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@SpringBootApplication
@Configuration
@ComponentScan(basePackages = {"com.ejoylot"})
@EnableAutoConfiguration
@MapperScan("com.ejoylot.mapper.**")
//启动oauth校验
//@EnableAuthorizationServer
public class EjoylotApiServerApplication {

    protected static final Logger logger = LoggerFactory.getLogger(EjoylotApiServerApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(EjoylotApiServerApplication.class,args);
    }
}