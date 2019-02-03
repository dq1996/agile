package com.service;

import com.pojo.TravelPlan;

import java.util.List;

public interface TravelPlanService {

    /**
     * 查看进行中旅行计划
     *
     * @param userId
     * @return TravelPlan
     */
    TravelPlan getOngoingTravelPlan(Integer userId);

    /**
     * 查看已完成旅行计划
     *
     * @param userId
     * @return List<TravelPlan>
     */
    List<TravelPlan> getCompletedTravelPlan(Integer userId);

    /**
     * 创建新的旅行计划
     *
     * @param travelPlanNo,travelPlanName,travelLineIntro,status,founderId,moodspictures
     * @return
     */
    void createNewTravelPlan(Integer travelPlanNo,String travelPlanName,String travelLineIntro,
                             String status,Integer founderId,List<String> moodspictures);

    /**
     * 分享该旅行计划
     *
     * @param travelPlanNo
     * @return TravelPlan
     */
    TravelPlan shareTravelPlan(Integer travelPlanNo);

    /**
     * 上传旅行中发布的文字和图片
     *
     * @param travelPlanNo,moodspictures
     * @return
     */
    void shareMoodsPictures(Integer travelPlanNo,String moodspictures);

}
