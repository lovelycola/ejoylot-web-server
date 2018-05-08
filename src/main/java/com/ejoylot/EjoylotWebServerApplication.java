package com.ejoylot;

import com.ejoylot.util.SpringContextUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@SpringBootApplication
@Configuration
@ComponentScan(basePackages = {"com.ejoylot"})
@EnableAutoConfiguration
//@MapperScan("com.ejoylot.mapper.**")
//@EnableEurekaClient
@EnableFeignClients
@EnableDiscoveryClient
public class EjoylotWebServerApplication {


    protected static final Logger logger = LoggerFactory.getLogger(EjoylotWebServerApplication.class);


    public static void main(String[] args) {
        ApplicationContext app = SpringApplication.run(EjoylotWebServerApplication.class, args);
        SpringContextUtil.setApplicationContext(app);
    }
}
