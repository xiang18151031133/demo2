package com.swx.dao;

import com.swx.model.User;

public interface UserMapper {
    boolean addUser(User user);
    User getUser(User user);
    User getUserByName(User user);
}
