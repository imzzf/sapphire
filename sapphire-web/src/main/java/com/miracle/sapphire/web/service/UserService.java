package com.miracle.sapphire.web.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.miracle.sapphire.common.entity.User;

/**
 * @author miracle
 * @date 2020/12/06
 */
public interface UserService extends IService<User> {

    /**
     * 通过用户名和密码注册
     *
     * @param username
     * @param password
     * @return
     */
    User signup(String username, String password);

    /**
     * 通过用户名获取用户
     *
     * @param username
     * @return
     */
    User getUserByUsername(String username);
}
