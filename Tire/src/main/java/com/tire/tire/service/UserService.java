package com.tire.tire.service;

import com.tire.tire.pojo.User;
import org.springframework.stereotype.Service;

import java.util.Map;

public interface UserService {
    public Map<String, Object> getUserById(Integer userId);
    public Map<String, Object> loginByName(String userName, String userPassword);
    public Map<String, Object> loginById(Integer userId, String userPassword);
    public Map<String, Object> register(String userName, String userPassword);
    public Map<String, Object> revise(Integer userId, String userName, String userPassword);
}
