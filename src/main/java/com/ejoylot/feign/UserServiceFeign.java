package com.ejoylot.feign;

//import org.springframework.cloud.netflix.feign.FeignClient;

import com.ejoylot.entry.SysRole;
import com.ejoylot.entry.SysUser;
import com.ejoylot.exception.BaseException;
import com.ejoylot.exception.SercurityException;
import com.ejoylot.hystrix.AccountServerFeignClientFallback;
import com.ejoylot.util.FeignConfig;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(name="ejoylot-account-server", configuration = FeignConfig.class,fallback = AccountServerFeignClientFallback.class)
public interface UserServiceFeign {
    @RequestMapping(method = RequestMethod.POST, value = "/user", consumes = "application/json")
    Object addAccount(@RequestBody(required = true) SysUser sysUser) throws BaseException;

    @RequestMapping(method = RequestMethod.DELETE, value = "/user/{id}", consumes = "application/json")
    Object deleteAccount(@PathVariable("id") int id) throws BaseException;

    @RequestMapping(method = RequestMethod.GET, value = "/user", consumes = "application/json")
    SysUser loadUserByUsername(@RequestParam (value="userName",required=false) String userName) throws SercurityException;

    @RequestMapping(method = RequestMethod.POST, value = "/user/{id}/role", consumes = "application/json")
    List<SysRole> selectUserRoleByUserId(@PathVariable("id") int id) throws SercurityException;
}