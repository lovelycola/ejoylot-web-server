package com.ejoylot.service.impl;

import com.ejoylot.entry.SysRole;
import com.ejoylot.entry.SysUser;
import com.ejoylot.exception.BaseException;

import java.util.List;

/**
 * Copyright (c) 2018 ZheJiang Ejoylot Technology Co., Ltd.  All rights reserved.
 * Project: ejoylot-web-server
 * Package: com.ejoylot.service.impl
 * Date: 18-5-7
 * User: dennis
 */
public interface UserService{

    Object addAccount(SysUser sysUser) throws BaseException;

    Object deleteAccount(int id) throws BaseException;

    SysUser loadUserByUsername(String userName);

    List<SysRole> selectUserRoleByUserId(int id);
}
