package com.swx.service.impl;

import com.swx.dao.UserMapper;
import com.swx.model.User;
import com.swx.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service("userService")
public class UserServiceImpl implements UserService {
    @Resource
    private UserMapper userMapper;
    @Override
    public boolean addUser(User user) {
        return userMapper.addUser(user);
    }

    @Override
    public User getUser(User user) {
        return userMapper.getUser(user);
    }

    @Override
    public User getUserByName(User user) {
        return userMapper.getUserByName(user);
    }

    @Override
    public User getUserById(User user) {
        return userMapper.getUserById(user);
    }

    @Override
    public boolean updateUser(User user) {
        return userMapper.updateUser(user);
    }
}
