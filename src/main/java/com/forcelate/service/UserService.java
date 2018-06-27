package com.forcelate.service;

import com.forcelate.model.Color;
import com.forcelate.model.User;

import java.util.List;

public interface UserService {

    List<User> getAllUsers();

    List<User> getAllUserElderThan(int age);

    List<User> getAllUserByArticleColor(Color color);

    List<User> getAllUsersHaveMoreArticlesThanThree();

    void saveUser(User user);
}
