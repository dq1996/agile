package com.pojo;

public class Friends {
    private Integer u1;//记录互为好友的两个人的userId
    private Integer u2;
    public Friends(){}
    public void setU1(Integer u1){
        this.u1=u1;
    }
    public Integer getU1(){
        return u1;
    }
    public void setU2(Integer u2){
        this.u2=u2;
    }
    public Integer getU2(){
        return u2;
    }
}
