package com.ejoylot.feign;

import com.ejoylot.util.FeignConfig;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Copyright (c) 2018 ZheJiang Ejoylot Technology Co., Ltd.  All rights reserved.
 * Project: ejoylot-web-server
 * Package: com.ejoylot.feign
 * Date: 18-5-8
 * User: dennis
 */
@FeignClient(name="ejoylot-account-server", configuration = FeignConfig.class)
public interface LoginServiceFeign {

    @RequestMapping(method = RequestMethod.POST, value = "/user/login", consumes = "application/json")
    Object login(@RequestParam("userName") String userName, @RequestParam("passwd") String passwd);
}
