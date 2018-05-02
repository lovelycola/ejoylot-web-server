package com.ejoylot.controller;

import com.ejoylot.entry.SysUser;
import com.ejoylot.mapper.SysRoleMapper;
import com.ejoylot.mapper.SysUserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("user")
@RestController
public class UserController {
    @Autowired
    private SysUserMapper userMapper;

    @Autowired
    private SysRoleMapper sysRoleMapper;

    @GetMapping("/user")
    public Object listAll() {
        SysUser s=userMapper.selectByPrimaryKey(1);
        s.setRoles(sysRoleMapper.selectUserRoleByUserId(s.getId()));
        return s;
    }

}