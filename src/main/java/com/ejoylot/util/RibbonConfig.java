package com.ejoylot.util;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * Copyright (c) 2018 ZheJiang Ejoylot Technology Co., Ltd.  All rights reserved.
 * Project: ejoylot-api-server
 * Package: com.ejoylot.util
 * Date: 18-5-5
 * User: dennis
 */
@Configuration
public class RibbonConfig {
    @Bean
    @LoadBalanced
    RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
