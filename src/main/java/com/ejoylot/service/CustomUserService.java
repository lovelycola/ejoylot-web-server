package com.ejoylot.service;

import com.ejoylot.entry.SysUser;
import com.ejoylot.mapper.SysRoleMapper;
import com.ejoylot.mapper.SysUserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class CustomUserService implements UserDetailsService {
    @Autowired
    SysUserMapper sysUserMapper;

    @Autowired
    SysRoleMapper sysRoleMapper;
    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        System.out.println(s);
        SysUser user = sysUserMapper.selectByUserName(s);
        if (user == null) {
            throw new UsernameNotFoundException("用户名不存在");
        }
        user.setRoles(sysRoleMapper.selectUserRoleByUserId(user.getId()));
        return user;
    }
}