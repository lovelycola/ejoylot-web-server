package com.ejoylot.hystrix;

import com.ejoylot.entry.SysRole;
import com.ejoylot.entry.SysUser;
import com.ejoylot.exception.BaseException;
import com.ejoylot.exception.ErrorCode;
import com.ejoylot.exception.SercurityException;
import com.ejoylot.feign.UserServiceFeign;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Component
public class AccountServerFeignClientFallback implements UserServiceFeign {

    protected static final Logger logger = LoggerFactory.getLogger(AccountServerFeignClientFallback.class);
    @Override
    public Object addAccount(@RequestParam("sysUser") SysUser sysUser) throws BaseException {
        logger.info("addAccount fallback");
        throw new BaseException(ErrorCode.RUNTIME_ERROR,"add account failed!");

    }

    @Override
    public Object deleteAccount(@PathVariable("id") int id) throws BaseException {
        logger.info("deleteAccount fallback");
        throw new BaseException(ErrorCode.RUNTIME_ERROR,"delete account failed!");
    }

    @Override
    public SysUser loadUserByUsername(@RequestParam(value = "userName", required = false) String userName) throws SercurityException {
        logger.info("loadUserByUsername fallback");
        throw new SercurityException("loadUserByUsername failed!");
    }

    @Override
    public List<SysRole> selectUserRoleByUserId(@PathVariable("id") int id) throws SercurityException {
        logger.info("selectUserRoleByUserId fallback");
        throw new SercurityException("selectUserRoleByUserId failed!");
    }
}