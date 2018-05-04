package com.ejoylot.controller;

import com.ejoylot.entry.SysUser;
import com.ejoylot.mapper.SysUserMapper;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

@RequestMapping("user")
@RestController
public class UserController {

    protected static final Logger logger = LoggerFactory.getLogger(UserController.class);
    @Autowired
    private SysUserMapper userMapper;

//    @Autowired
//    private SysRoleMapper sysRoleMapper;
    @Secured({"ROLE_ADMIN","ROLE_USER"})
    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public String getUsers() {
        return "getUsers";
    }

    @Secured({"ROLE_ADMIN"})
    @RequestMapping(method = RequestMethod.POST)
    @ApiOperation(value="创建用户", notes="根据User对象创建用户")
    @ApiImplicitParam(name = "user", value = "创建的用户实体", required = true, dataType = "SysUser")
    @ResponseBody
    public Object save(@AuthenticationPrincipal SysUser loginedUser, @RequestBody SysUser user) {
        logger.info("execut admin ,user,insert method");
        logger.info(loginedUser.getUsername() + " execute");
        return userMapper.insert(user);
    }


    @Secured("ROLE_ADMIN")
    @RequestMapping(method = RequestMethod.PUT)
    @ResponseBody
    public String update(@AuthenticationPrincipal SysUser loginedUser) {
        logger.info("execut admin Update method");
        logger.info(loginedUser.getUsername() + " execute");
        return "updateUser";
    }

    @Secured("ROLE_ADMIN")
    @RequestMapping(method = RequestMethod.DELETE)
    @ResponseBody
    public String delete(@AuthenticationPrincipal SysUser loginedUser) {
        logger.info("execut admin delete method");
        logger.info(loginedUser.getUsername() + " execute");
        return "deleteUser";
    }


}