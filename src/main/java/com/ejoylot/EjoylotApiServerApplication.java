package com.ejoylot;

import com.ejoylot.util.SpringContextUtil;
import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@SpringBootApplication
@Configuration
@ComponentScan(basePackages = {"com.ejoylot"})
@EnableAutoConfiguration
@MapperScan("com.ejoylot.mapper.**")
//@EnableEurekaClient
@EnableFeignClients
public class EjoylotApiServerApplication {

    protected static final Logger logger = LoggerFactory.getLogger(EjoylotApiServerApplication.class);


    public static void main(String[] args) {
        ApplicationContext app = SpringApplication.run(EjoylotApiServerApplication.class, args);
        SpringContextUtil.setApplicationContext(app);
    }
}
