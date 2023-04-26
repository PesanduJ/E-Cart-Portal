package com.ecartportal.ecartportal.service;

import com.ecartportal.ecartportal.entity.User;

public interface UserService {

    User addUser(User user);

    String login(String username, String password);
}
