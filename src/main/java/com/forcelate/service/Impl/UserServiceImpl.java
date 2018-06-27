package com.forcelate.service.Impl;

import com.forcelate.model.Color;
import com.forcelate.model.User;
import com.forcelate.repositpry.UserRepository;
import com.forcelate.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public List<User> getAllUserElderThan(int age) {
        return userRepository.findByAgeGreaterThan(age);
    }

    @Override
    public List<User> getAllUserByArticleColor(Color color) {
        return userRepository.findUserByArticleColor(color.ordinal());
    }

    @Override
    public List<User> getAllUsersHaveMoreArticlesThanThree() {
        return userRepository.findUsersByArticleListGreaterThan();
    }

    @Override
    public void saveUser(User user) {
        userRepository.save(user);
    }
}
