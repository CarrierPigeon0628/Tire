package com.tire.tire.controller;

import com.tire.tire.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.Objects;

import static java.lang.Integer.parseInt;

@RestController
public class UserController {
    @Autowired
    UserService userService;

    @GetMapping("/user/{userId}/")
    public Map<String, Object> getUserById(@PathVariable Integer userId) {
        System.out.println(userId);
        return userService.getUserById(userId);
    }

    @PostMapping("/login/")
    public Map<String, Object> login(@RequestParam Map<String, Object> form,
                                     @RequestParam(value = "filter", defaultValue = "userName") String filter) {
        String userPassword = form.get("userPassword").toString();
        if (Objects.equals(filter, "userName")) {
            String userName = form.get("userName").toString();
            System.out.println(userName);
            return userService.loginByName(userName, userPassword);
        }
        else if (Objects.equals(filter, "userId")) {
            Integer userId = (Integer) form.get("userId");
            System.out.println(userId);
            return userService.loginById(userId, userPassword);
        }
        return null;
    }

    @PostMapping("/register/")
    public Map<String, Object> register(@RequestParam Map<String, Object> form) {
        String userPassword = form.get("userPassword").toString();
        String userName = form.get("userName").toString();
        System.out.println(userName);
        return userService.register(userName, userPassword);
    }

    @PutMapping("/reviseUser/{userId}")
    public Map<String, Object> revise(@PathVariable Integer userId, @RequestParam Map<String, Object> form) {
        String userName = form.get("userName").toString();
        String userPassword = form.get("userPassword").toString();
        return userService.revise(userId, userName, userPassword);
    }
}
