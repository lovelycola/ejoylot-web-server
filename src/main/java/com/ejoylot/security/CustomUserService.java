package com.ejoylot.security;

import com.ejoylot.entry.SysRole;
import com.ejoylot.entry.SysUser;
import com.ejoylot.feign.CustomUserServiceFeignImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class CustomUserService implements UserDetailsService {
//    @Autowired
//    SysUserMapper sysUserMapper;
//
//    @Autowired
//    SysRoleMapper sysRoleMapper;

    @Autowired
    private CustomUserServiceFeignImpl customUserServiceFeign;
    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
//        SysUser systemUser=new SysUser();
//        systemUser.setUsername("dennissun");
//        systemUser.setPassword("password");
//        SysRole role=new SysRole();
//        role.setId(1);
//        role.setName("ROLE_ADMIN");
//        java.util.List d=new ArrayList();
//        d.add(role);
//        systemUser.setRoles(d);
        Object obj=customUserServiceFeign.loadUserByUsername(s);
        System.out.println(obj);
        SysUser user = (SysUser)customUserServiceFeign.loadUserByUsername(s);
        if (user == null) {
            throw new UsernameNotFoundException("用户名不存在");
        }
        java.util.List<SysRole> sysRole=(java.util.List)customUserServiceFeign.selectUserRoleByUserId(user.getId());
        user.setRoles(sysRole);
        return user;
    }
}