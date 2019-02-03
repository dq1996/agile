package com.pojo;

public class Vote {//记录每个旅行计划的得票情况
    private Integer travelPlanNo;
    private Integer userId;
    public Vote (){}
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
