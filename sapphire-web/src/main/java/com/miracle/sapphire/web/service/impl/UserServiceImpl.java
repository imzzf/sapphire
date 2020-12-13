package com.miracle.sapphire.web.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.miracle.sapphire.common.dao.UserMapper;
import com.miracle.sapphire.common.entity.User;
import com.miracle.sapphire.web.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

/**
 * @author miracle
 * @date 2020/12/06
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public User signup(String username, String password) {
        User user = new User();
        user.setUsername(username);
        user.setPassword(new BCryptPasswordEncoder().encode(password));
        user.setNickname(username);
        LocalDateTime localDateTime = LocalDateTime.now();
        user.setRegisterTime(localDateTime);
        user.setCreateTime(localDateTime);
        user.setModifiedTime(localDateTime);
        userMapper.insert(user);
        return user;
    }

    @Override
    public User getUserByUsername(String username) {
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.eq("username", username);
        return userMapper.selectOne(wrapper);
    }
}
