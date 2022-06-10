package com.example.tools.service;

import com.example.tools.mapper.UserMapper;
import com.example.tools.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;

    public int InsertUser(User user){
        return userMapper.InsertUser(user);
    }

    public int DeleteUser(int uid){
        return userMapper.DeleteUser(uid);
    }

    public int UpdateUser(User user){
        return userMapper.UpdateUser(user);
    }

    public User SelectUser(String uname){
        return userMapper.SelectUser(uname);
    }
    public List<User> SelectAllUser(){
        return userMapper.SelectAllUser();
    }
}
