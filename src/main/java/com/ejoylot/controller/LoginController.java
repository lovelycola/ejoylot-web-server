package com.ejoylot.controller;

import com.ejoylot.entry.SysUser;
import com.ejoylot.message.ResultEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

@RestController
public class LoginController {

    @RequestMapping(value = "/login")
    @ResponseBody
    public ResultEntity login(@AuthenticationPrincipal SysUser loginedUser, @RequestParam(name = "logout", required = false) String logout) {
        if (logout != null) {
            return ResultEntity.fail(null);
        }
        if (loginedUser != null) {
            return ResultEntity.success(loginedUser);
        }
        return null;
    }
}