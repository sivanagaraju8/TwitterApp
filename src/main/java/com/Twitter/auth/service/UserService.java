package com.Twitter.auth.service;

import com.Twitter.auth.model.User;

public interface UserService {
    void save(User user);

    User findByUsername(String username);
}
