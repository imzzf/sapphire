package com.miracle.sapphire.web.controller;

import com.miracle.sapphire.common.api.Result;
import com.miracle.sapphire.common.api.ResultCode;
import com.miracle.sapphire.web.service.UserService;
import com.miracle.sapphire.web.vo.UserVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author miracle
 * @date 2020/11/08
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * @param userVO
     * @return com.miracle.sapphire.common.api.Result
     * @author miracle
     * @date 2020/11/10 16:04
     */
    @PostMapping("/signup")
    public Result signup(@RequestBody UserVO userVO) {
        if (userService.getUserByUsername(userVO.getUsername()) != null) {
            return Result.failed(ResultCode.USER_USERNAME_REGISTERED);
        }
        userService.signup(userVO.getUsername(), userVO.getPassword());
        return Result.success("注册成功");
    }

}
