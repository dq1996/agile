package com.mapper;

import com.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserMapper {

    /**
     * 根据openId查询用户
     *
     * @param openId
     * @return User
     */
    User getUserByOpenId(@Param("openId") String openId);

    /**
     * 增加用户
     *
     * @param user
     */
    void addUser(@Param("user") User user);

    /**
     * 上传昵称和头像
     *
     * @param userId,userName,headShoturl
     * @return
     */
    void setUserInfo(@Param("userId") Integer userId,@Param("userName") String userName,@Param("headShoturl") String headShoturl);

    /**
     * 查询一个用户的所有信息
     *
     * @param userId
     * @return User
     */
    User getUserByUserId(@Param("userId") Integer userId);

    /**
     * 查看好友列表
     *
     * @param userId
     * @return List<Integer>
     */
    List<Integer> getFriendList(@Param("userId") Integer userId);

    /**
     * 将定位写入数据库
     *
     * @param userId,latitude,longitude
     * @return
     */
    void setLocation(@Param("userId") Integer userId,@Param("latitude") Integer latitude,@Param("longitude") Integer longitude);

    /**
     * 查看朋友的个人信息页（包括定位）
     *
     * @param userId1,userId2
     * @return User
     */
    User viewFriendInfo(@Param("userId1") Integer userId1,@Param("userId2")Integer userId2);

}
