package com.pojo;

public class Namelist {//记录每个旅行计划的名单
    private Integer travelPlanNo;
    private Integer userId;
    public Namelist(){}
    public void setTravelPlanNo(Integer travelPlanNo){
        this.travelPlanNo=travelPlanNo;
    }
    public Integer getTravelPlanNo(){
        return travelPlanNo;
    }
    public void setUserId(Integer userId){
        this.userId=userId;
    }
    public Integer getUserId(){
        return userId;
    }
}
