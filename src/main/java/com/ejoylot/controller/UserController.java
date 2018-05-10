package com.ejoylot.controller;

import com.ejoylot.entry.SysUser;
import com.ejoylot.exception.BaseException;
import com.ejoylot.message.ResultEntity;
import com.ejoylot.service.UserServiceImpl;
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
    private UserServiceImpl userService;

    @Secured({"ROLE_ADMIN"})
    @RequestMapping(method = RequestMethod.POST)
    @ApiOperation(value="创建用户", notes="根据User对象创建用户")
    @ApiImplicitParam(name = "user", value = "创建的用户实体", required = true, dataType = "SysUser")
    @ResponseBody
    public ResultEntity save(@AuthenticationPrincipal SysUser loginedUser, @RequestBody SysUser user) throws BaseException {
        logger.info("execut admin ,user,insert method");
        logger.info(loginedUser.getUsername() + " execute");
        userService.addAccount(user);
        return ResultEntity.success(user);
    }

    @Secured("ROLE_ADMIN")
    @RequestMapping(value = "/{id}",method = RequestMethod.DELETE)
    @ResponseBody
    public ResultEntity delete(@AuthenticationPrincipal SysUser loginedUser,@PathVariable int id) throws BaseException {
        logger.info("execut admin delete method");
        logger.info(loginedUser.getUsername() + " execute");
        userService.deleteAccount(id);
        return ResultEntity.success("deleteUser");
    }
//

}