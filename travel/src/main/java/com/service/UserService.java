package com.service;

import com.pojo.User;

import java.util.List;
public interface UserService {
    /**
     * 根据openId查询用户
     *
     * @param openId
     * @return User
     */
    User getUserByOpenId(String openId);

    /**
     * 增加用户
     *
     * @param user
     * @return
     */
    void addUser(User user);

    /**
     * 上传昵称和头像
     *
     * @param userId,userName,headShoturl
     * @return
     */
    void setUserInfo(Integer userId,String userName,String headShoturl);

    /**
     * 查询一个用户的所有信息
     *
     * @param userId
     * @return User
     */
    User getUserByUserId(Integer userId);

    /**
     * 查看好友列表
     *
     * @param userId
     * @return List<Integer>
     */
    List<Integer> getFriendList(Integer userId);

    /**
     * 将定位写入数据库
     *
     * @param userId,latitude,longitude
     * @return
     */
    void setLocation(Integer userId,Integer latitude,Integer longitude);

    /**
     * 查看朋友的个人信息页（包括定位）
     *
     * @param userId1,userId2
     * @return User
     */
    User viewFriendInfo(Integer userId1,Integer userId2);

}
