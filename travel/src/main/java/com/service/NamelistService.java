package com.service;

public interface NamelistService {
    /**
     * 加入该旅行计划
     *
     * @param travelPlanNo,userId
     * @return
     */
    void joinInTravelPlan(Integer travelPlanNo,Integer userId);
}
