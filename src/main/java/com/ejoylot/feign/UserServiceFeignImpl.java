package com.ejoylot.feign;

//import org.springframework.cloud.netflix.feign.FeignClient;

import com.ejoylot.entry.SysUser;
import com.ejoylot.util.FeignConfig;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name="ejoylot-account-server", configuration = FeignConfig.class)
public interface UserServiceFeignImpl {
    @RequestMapping(method = RequestMethod.POST, value = "/user", consumes = "application/json")
    Object addAccount(@RequestParam("sysUser") SysUser sysUser);

    @RequestMapping(method = RequestMethod.DELETE, value = "/user/{id}", consumes = "application/json")
    Object deleteAccount(@PathVariable("id") int id);
}