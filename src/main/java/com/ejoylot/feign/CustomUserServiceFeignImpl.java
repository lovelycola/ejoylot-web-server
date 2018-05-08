package com.ejoylot.feign;

import com.ejoylot.entry.SysRole;
import com.ejoylot.entry.SysUser;
import com.ejoylot.util.FeignConfig;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * Copyright (c) 2018 ZheJiang Ejoylot Technology Co., Ltd.  All rights reserved.
 * Project: ejoylot-web-server
 * Package: com.ejoylot.feign
 * Date: 18-5-7
 * User: dennis
 */
@FeignClient(name="ejoylot-account-server", configuration = FeignConfig.class)
public interface CustomUserServiceFeignImpl {
    @RequestMapping(method = RequestMethod.GET, value = "/user", consumes = "application/json")
    SysUser loadUserByUsername(@RequestParam (value="userName",required=false) String userName);
    @RequestMapping(method = RequestMethod.POST, value = "/user/{id}/role", consumes = "application/json")
    List<SysRole> selectUserRoleByUserId(@PathVariable("id") int id);

}
