package com.ejoylot.security;

import com.ejoylot.entry.SysRole;
import com.ejoylot.entry.SysUser;
import com.ejoylot.feign.UserServiceFeign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class WebSecurityService implements UserDetailsService {

    @Autowired
    private UserServiceFeign userServiceFeign;
    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        SysUser user = (SysUser)userServiceFeign.loadUserByUsername(s);
        if (user == null) {
            throw new UsernameNotFoundException("用户名不存在");
        }
        java.util.List<SysRole> sysRole=(java.util.List)userServiceFeign.selectUserRoleByUserId(user.getId());
        user.setRoles(sysRole);
        return user;
    }
}