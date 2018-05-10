package com.ejoylot.service;

import com.ejoylot.entry.SysUser;
import com.ejoylot.feign.UserServiceFeign;
import com.ejoylot.service.impl.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Copyright (c) 2018 ZheJiang Ejoylot Technology Co., Ltd.  All rights reserved.
 * Project: ejoylot-web-server
 * Package: com.ejoylot.service
 * Date: 18-5-7
 * User: dennis
 */

@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    UserServiceFeign userServiceFeign;

    @Override
    public SysUser login(String userName, String password) {
        return null;
    }
}
