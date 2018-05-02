package com.ejoylot.service;

public class CustomUserService {// implements UserDetailsService {
//    @Autowired
//    SysUserMapper sysUserMapper;
//
//    @Autowired
//    SysRoleMapper sysRoleMapper;
//    @Override
//    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
//        SysUser user = sysUserMapper.selectByUserName(s);
//        if (user == null) {
//            throw new UsernameNotFoundException("用户名不存在");
//        }
//        System.out.println("s:"+s);
//        user.setRoles(sysRoleMapper.selectUserRoleByUserId(user.getId()));
//        //System.out.println("username:"+user.getUsername()+";password:"+user.getPassword());
//        return user;
//    }
}