package com.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.pojo.User;
import com.service.UserService;
import com.util.WechatStruct;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/user")//所有/user界面下的方法
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/login")//普通用户通过微信登录小程序
    public @ResponseBody String login(@RequestBody String codeJson){//用前端传来的codeJson字符串获取用户的openId
        String appId = "wx1009f2c5e0e6d06e";
        String secret = "147f6a1b41435aa3e183c766a65c3879";
        JSONObject jsonObject = JSON.parseObject(codeJson);//将字符串codeJson转换为JSON对象
        String url = "https://api.weixin.qq.com/sns/jscode2session?appid=" + appId + "&secret=" + secret +
                "&js_code=" + jsonObject.getString("code") + "&grant_type=authorization_code";
        RestTemplate restTemplate = new RestTemplate();//调用http请求的WebService，并将结果转换成相应的对象类型
        ResponseEntity<String> responseEntity = restTemplate.exchange(url, HttpMethod.GET, null, String.class);
        if(responseEntity != null && responseEntity.getStatusCode() == HttpStatus.OK)
        {
            String sessionData = responseEntity.getBody();
            Gson gson = new Gson();
            WechatStruct ws = gson.fromJson(sessionData, WechatStruct.class);
            String tempOpenId = ws.getOpenId();
            System.out.println("ac");
            User user = userService.getUserByOpenId(tempOpenId);
            if(user == null){
                user = new User(tempOpenId);
                userService.addUser(user);//只加了userId和openId此处
            }
            else{
                System.out.println("ac");
            }
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("userId", user.getUserId());
            map.put("openId", tempOpenId);
            String openId = JSON.toJSONString(map);
            return openId;
        }
        return "null";
    }

    @RequestMapping(value="/adminLogin")//管理员登录
    public @ResponseBody String adminLogin(@RequestBody String json){
        System.out.println(json);
        JSONObject jsonObject = JSON.parseObject(json);
        if(jsonObject.getString("username").equals("agile") && jsonObject.getString("password").equals("123456")){
            return "ac";//管理员账号agile密码123456
        }
        else{
            return "?";
        }
    }

    @RequestMapping(value = "/{userId}/{userName}/{headShoturl}/userInfoSettings")//上传昵称和头像
    public @ResponseBody String userInfoSettings(@PathVariable("userId") Integer userId,
                                                 @PathVariable("userName") String userName,
                                                 @PathVariable("headShoturl") String headShoturl){
        userService.setUserInfo(userId,userName,headShoturl);
        return "ac";
    }

    @RequestMapping(value = "/{userId}/userInfo", method = RequestMethod.GET)//显示用户信息页
    public @ResponseBody String userInfo(@PathVariable("userId") Integer userId){
        User user = userService.getUserByUserId(userId);
        String resultUser = JSON.toJSONString(user);
        return resultUser;
    }

    @RequestMapping(value = "/{userId}/friendList", method = RequestMethod.GET)//好友列表
    public @ResponseBody String friendList(@PathVariable("userId") Integer userId){
        List<Integer> ulist = userService.getFriendList(userId);
        String resultUlist = JSON.toJSONString(ulist);
        return resultUlist;
    }

    @RequestMapping(value = "/{userId}/{latitude}/{longitude}/location")//将定位写入数据库
    public @ResponseBody String location(@PathVariable("userId") Integer userId,
                                         @PathVariable("latitude") Integer latitude,
                                         @PathVariable("longitude") Integer longitude){
        System.out.println("纬度："+latitude+" 经度："+longitude);
        userService.setLocation(userId,latitude,longitude);
        return "ac";
    }

    @RequestMapping(value = "/{userId1}/{userId2}/friendsInfo", method = RequestMethod.GET)//查看朋友的个人信息页（包括定位）
    public @ResponseBody String friendsInfo(@PathVariable("userId1") Integer userId1,@PathVariable("userId2") Integer userId2){
        User user = userService.viewFriendInfo(userId1,userId2);
        String resultUser = JSON.toJSONString(user);
        return resultUser;
    }

}
