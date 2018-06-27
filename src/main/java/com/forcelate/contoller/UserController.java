package com.forcelate.contoller;

import com.forcelate.model.Color;
import com.forcelate.model.User;
import com.forcelate.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/userlist", method = RequestMethod.GET)
    public ResponseEntity getAllUsers() {
        List<User> userDetails = userService.getAllUsers();
        return new ResponseEntity(userDetails, HttpStatus.OK);
    }

    @RequestMapping(value = "/greaterthan", method = RequestMethod.GET)
    public ResponseEntity findGreaterThanAge(@RequestParam("age") int age) {
        List<User> users = userService.getAllUserElderThan(age);
        return new ResponseEntity(users, HttpStatus.OK);
    }

    @RequestMapping(value = "/findbycolor", method = RequestMethod.GET)
    public ResponseEntity findUserByArticleColor(@RequestParam("color") Color color) {
        List<User> users = userService.getAllUserByArticleColor(color);
        return new ResponseEntity(users, HttpStatus.OK);
    }

    @RequestMapping(value = "/findbycount", method = RequestMethod.GET)
    public ResponseEntity findUserByCountArticle() {
        List<User> users = userService.getAllUsersHaveMoreArticlesThanThree();
        return new ResponseEntity(users, HttpStatus.OK);
    }

    @RequestMapping(value = "/saveuser", method = RequestMethod.POST)
    public ResponseEntity saveUser(@RequestParam("name") String name, @RequestParam("age") int age) {
        User user = new User(name, age);
        userService.saveUser(user);
        return new ResponseEntity(user, HttpStatus.OK);
    }


}
