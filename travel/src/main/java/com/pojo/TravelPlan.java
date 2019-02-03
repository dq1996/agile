package com.pojo;

public class TravelPlan {
    private Integer travelPlanNo;//旅游计划编号
    private String travelPlanName;//旅游计划名称
    private String travelLineIntro;//旅行线路简介
    private String status;//未开始或者进行中或者已完成
    private Integer founderId;//创建者id
    private String moodspictures;//旅行过程中的图片路径
    public TravelPlan(){}
    public void setTravelPlanNo(Integer travelPlanNo){
        this.travelPlanNo=travelPlanNo;
    }
    public Integer getTravelPlanNo(){
        return travelPlanNo;
    }
    public void setTravelPlanName(String travelPlanName){
        this.travelPlanName=travelPlanName;
    }
    public String getTravelPlanName(){
        return travelPlanName;
    }
    public void setTravelLineIntro(String travelLineIntro){
        this.travelLineIntro=travelLineIntro;
    }
    public String getTravelLineIntro(){
        return travelLineIntro;
    }
    public void setStatus(String status){
        this.status=status;
    }
    public String getStatus(){
        return status;
    }
    public void setFounderId(Integer founderId){
        this.founderId=founderId;
    }
    public Integer getFounderId(){
        return founderId;
    }
    public void setMoodspictures(String moodspictures){
        this.moodspictures=moodspictures;
    }
    public String getMoodspictures(){
        return moodspictures;
    }
}
