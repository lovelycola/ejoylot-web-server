package com.ejoylot.util;

//import feign.Retryer;

import feign.Retryer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.concurrent.TimeUnit;

/**
 * Copyright (c) 2018 ZheJiang Ejoylot Technology Co., Ltd.  All rights reserved.
 * Project: ejoylot-api-server
 * Package: com.ejoylot.util
 * Date: 18-5-5
 * User: dennis
 */
@Configuration
public class FeignConfig {

    @Bean
    public Retryer feigRetryer(){
        return new Retryer.Default(100, TimeUnit.SECONDS.toMillis(1L),5);
    }

    //用户处理，在后面的调用不会出现权限控制，所以隐藏掉这样代码，如果需要调用，再启用即可
//    @Bean
//    public BasicAuthRequestInterceptor basicAuthRequestInterceptor() {
//        return new BasicAuthRequestInterceptor("user", "password");
//    }

//    @Bean
//    public Decoder feignDecoder() {
//        HttpMessageConverter jacksonConverter = new MappingJackson2HttpMessageConverter(customObjectMapper());
//        ObjectFactory<HttpMessageConverters> objectFactory = () -> new HttpMessageConverters(jacksonConverter);
//        return new ResponseEntityDecoder(new SpringDecoder(objectFactory));
//    }
//
//    public ObjectMapper customObjectMapper(){
//        ObjectMapper objectMapper = new ObjectMapper();
//        //Customize as much as you want
//        return objectMapper;
//    }

}
