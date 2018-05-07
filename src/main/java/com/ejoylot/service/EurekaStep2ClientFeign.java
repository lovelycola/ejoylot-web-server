package com.ejoylot.service;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Map;

@FeignClient("ejoylot-api-demo-server")
public interface EurekaStep2ClientFeign {
    @RequestMapping(method = RequestMethod.POST, value = "/eureka2/step2", consumes = "application/json")
    Object step2(Map<String, Object> paramMap);

    @RequestMapping(method = RequestMethod.GET, value = "/eureka2/step3", consumes = "application/json")
    Object step3(Map<String, Object> paramMap);
}