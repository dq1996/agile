package com.pojo;

public class User {
    private Integer userId;
    private String openId;
    private String userName;
    private String headShoturl;//头像地址
    private Integer latitude;//纬度
    private Integer longitude;//经度
    public User(){
    }
    public User(String openId){
        this.openId = openId;
    }
    public void setUserId(Integer userId){
        this.userId=userId;
    }
    public Integer getUserId(){
        return userId;
    }
    public void setOpenId(String openId){
        this.openId=openId;
    }
    public String getOpenId(){
        return openId;
    }
    public void setUserName(String userName){
        this.userName=userName;
    }
    public String getUserName(){
        return userName;
    }
    public void setHeadShoturl(String headShoturl){
        this.headShoturl=headShoturl;
    }
    public String getHeadShoturl(){
        return headShoturl;
    }
    public void setLocation(Integer latitude,Integer longitude){
        this.latitude=latitude;
        this.longitude=longitude;
    }
    public Integer getLatitude(){
        return latitude;
    }
    public Integer getLongitude(){
        return longitude;
    }
}
