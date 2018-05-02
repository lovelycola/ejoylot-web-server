package com.ejoylot.mapper;

import com.ejoylot.entry.SysUserRoles;

public interface SysUserRolesMapper {
    int insert(SysUserRoles record);

    int insertSelective(SysUserRoles record);
}