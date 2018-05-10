package com.ejoylot.service.impl;

import com.ejoylot.entry.SysUser;

/**
 * Copyright (c) 2018 ZheJiang Ejoylot Technology Co., Ltd.  All rights reserved.
 * Project: ejoylot-web-server
 * Package: com.ejoylot.service
 * Date: 18-5-7
 * User: dennis
 */
public interface LoginService {

    SysUser login(String userName,String password);
}
