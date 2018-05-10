package com.ejoylot.service;

import com.ejoylot.entry.SysRole;
import com.ejoylot.entry.SysUser;
import com.ejoylot.exception.BaseException;
import com.ejoylot.feign.UserServiceFeign;
import com.ejoylot.service.impl.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Copyright (c) 2018 ZheJiang Ejoylot Technology Co., Ltd.  All rights reserved.
 * Project: ejoylot-web-server
 * Package: com.ejoylot.service
 * Date: 18-5-7
 * User: dennis
 */

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserServiceFeign userServiceFeign;

    @Override
    public Object addAccount(SysUser sysUser) throws BaseException {
        return userServiceFeign.addAccount(sysUser);
    }

    @Override
    public Object deleteAccount(int id) throws BaseException {
        return userServiceFeign.deleteAccount(id);
    }

    @Override
    public SysUser loadUserByUsername(String userName) {
        return userServiceFeign.loadUserByUsername(userName);
    }

    @Override
    public List<SysRole> selectUserRoleByUserId(int id) {
        return userServiceFeign.selectUserRoleByUserId(id);
    }
}
