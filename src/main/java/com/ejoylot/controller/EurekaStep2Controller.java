package com.ejoylot.controller;

import com.ejoylot.entry.SysUser;
import com.ejoylot.service.EurekaStep2ClientFeign;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RequestMapping("eureka2")
@RestController
public class EurekaStep2Controller implements EurekaStep2ClientFeign {

    protected static final Logger logger = LoggerFactory.getLogger(EurekaStep2Controller.class);


//    @Autowired
//    RestTemplate restTemplate;

    @RequestMapping(value = "/step2",method = RequestMethod.POST)
    @ApiOperation(value="创建用户", notes="根据User对象创建用户")
    @ApiImplicitParam(name = "paramMap", value = "创建的用户实体", required = true, dataType = "Map<String,Object> ")
    @ResponseBody
    @Override
    public Object step2(@RequestBody Map<String,Object> paramMap) {
        logger.info("execut step2 method");
        SysUser sysUser=new SysUser();
        sysUser.setUsername("Step2UserName");
        return sysUser;
    }
    @RequestMapping(value = "/step3",method = RequestMethod.GET)
    @ApiOperation(value="创建用户", notes="根据User对象创建用户")
    @ApiImplicitParam(name = "paramMap", value = "创建的用户实体", required = true, dataType = "Map<String,Object> ")
    @ResponseBody
    public Object step3(@RequestBody Map<String,Object> paramMap) {
        logger.info("execut step2 method");
        SysUser sysUser=new SysUser();
        sysUser.setUsername("Stepe3UserName");
        return sysUser;
    }
}