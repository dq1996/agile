package com.service.impl;

import com.mapper.UserMapper;
import com.pojo.User;
import com.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public User getUserByOpenId(String openId) {
        return userMapper.getUserByOpenId(openId);
    }

    @Override
    public void addUser(User user) {
        userMapper.addUser(user);
    }

    @Override
    public void setUserInfo(Integer userId,String userName,String headShoturl){
        userMapper.setUserInfo(userId,userName,headShoturl);
    }

    @Override
    public User getUserByUserId(Integer userId) {
        return userMapper.getUserByUserId(userId);
    }

    @Override
    public List<Integer> getFriendList(Integer userId) {
        return userMapper.getFriendList(userId);
    }

    @Override
    public void setLocation(Integer userId,Integer latitude,Integer longitude) {
        userMapper.setLocation(userId,latitude,longitude);
    }

    @Override
    public User viewFriendInfo(Integer userId1,Integer userId2) {
        return userMapper.viewFriendInfo(userId1,userId2);
    }

}