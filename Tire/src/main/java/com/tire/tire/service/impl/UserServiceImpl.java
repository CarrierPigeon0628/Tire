package com.tire.tire.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.tire.tire.mapper.UserMapper;
import com.tire.tire.pojo.User;
import com.tire.tire.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserMapper userMapper;

    @Override
    public Map<String, Object> getUserById(Integer userId) {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("user_id", userId);
        User user = userMapper.selectOne(queryWrapper);
        Map<String, Object> response = new HashMap<>();
        if (user == null) {
            response.put("code", 0);
        }
        else {
            response.put("code", 1);
            response.put("user_id", user.getUserId());
            response.put("user_name", user.getUserName());
            response.put("user_status", user.getUserStatus());
        }
        return response;
    }

    @Override
    public Map<String, Object> loginByName(String userName, String userPassword) {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("user_name", userName);
        queryWrapper.eq("user_password", userPassword);
        User user = userMapper.selectOne(queryWrapper);
        Map<String, Object> response = new HashMap<>();
        if (user == null) {
            response.put("code", 0);
        }
        else {
            response.put("code", 1);
            response.put("user_id", user.getUserId());
            response.put("user_name", user.getUserName());
            response.put("user_status", user.getUserStatus());
        }
        return response;
    }

    @Override
    public Map<String, Object> loginById(Integer userId, String userPassword) {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("user_id", userId);
        queryWrapper.eq("user_password", userPassword);
        User user = userMapper.selectOne(queryWrapper);
        Map<String, Object> response = new HashMap<>();
        if (user == null) {
            response.put("code", 0);
        }
        else {
            response.put("code", 1);
            response.put("user_id", user.getUserId());
            response.put("user_name", user.getUserName());
            response.put("user_status", user.getUserStatus());
        }
        return response;
    }

    @Override
    public Map<String, Object> register(String userName, String userPassword) {
        QueryWrapper<User> queryWrapperName = new QueryWrapper<>();
        queryWrapperName.eq("user_name", userName);
        Map<String, Object> response = new HashMap<>();
        if (!userMapper.exists(queryWrapperName)) {
            User user = new User(null, userPassword, userName, "User");
            userMapper.insert(user);
            response.put("code", 1);
            response.put("user_name", user.getUserName());
            response.put("user_status", user.getUserStatus());
        }
        else {
            response.put("code", 0);
        }
        return response;
    }

    @Override
    public Map<String, Object> revise(Integer userId, String userName, String userPassword) {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("user_id", userId);
        User user = userMapper.selectOne(queryWrapper);
        Map<String, Object> response = new HashMap<>();
        if (user == null) {
            response.put("code", 0);
        }
        else if (userName.equals(user.getUserName()) && userPassword.equals(user.getUserPassword())) {
            response.put("code", -1);
        }
        else {
            UpdateWrapper<User> updateWrapper = new UpdateWrapper<>();
            if (!userPassword.equals("")) {
                updateWrapper.set("user_password", userPassword).eq("user_id", userId);
            }
            if (!userName.equals("")) {
                updateWrapper.set("user_name", userName).eq("user_id", userId);
            }
            userMapper.update(user, updateWrapper);
            response.put("code", 1);
            response.put("user_id", user.getUserId());
            response.put("user_name", user.getUserName());
            response.put("user_status", user.getUserStatus());
        }
        return response;
    }
}
