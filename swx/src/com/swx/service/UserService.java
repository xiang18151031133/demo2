package com.swx.service;

import com.swx.model.User;

public interface UserService {
    boolean addUser(User user);
    User getUser(User user);
    User getUserByName(User user);
    User getUserById(User user);
    boolean updateUser(User user);
}
