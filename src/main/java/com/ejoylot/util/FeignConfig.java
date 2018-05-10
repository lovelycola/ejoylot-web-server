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

}
