package com.ejoylot.controller;

import com.ejoylot.entry.SysUser;
import com.ejoylot.service.EurekaStep2ClientFeign;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@RequestMapping("eureka")
@RestController
public class EurekaController {

    protected static final Logger logger = LoggerFactory.getLogger(EurekaController.class);


    @Autowired
    private EurekaStep2ClientFeign eurekaStep2ClientFeign;

    @Autowired
    RestTemplate restTemplate;

    @Secured({"ROLE_ADMIN","ROLE_USER"})
    @RequestMapping(value = "/step1",method = RequestMethod.POST)
    @ApiOperation(value="创建用户", notes="根据User对象创建用户")
    @ApiImplicitParam(name = "user", value = "创建的用户实体", required = true, dataType = "SysUser")
    @ResponseBody
    public Object step1(@AuthenticationPrincipal SysUser loginedUser, @RequestBody SysUser user) {
        logger.info("execut admin ,user,insert method");

        Map<String,Object> paramMap=new HashMap<String,Object>();
        paramMap.put("name","sunchao");
        paramMap.put("age","31");
        paramMap.put("session",loginedUser);
        SysUser returnUser=(SysUser)eurekaStep2ClientFeign.step2(paramMap);
//        SysUser val=restTemplate.getForObject("http://ejoylot-api-demo-server/eureka/step2", SysUser.class,paramMap,1);

        System.out.println("getVal="+returnUser.getUsername());
        logger.info(loginedUser.getUsername() + " execute");
        return user;
    }
}