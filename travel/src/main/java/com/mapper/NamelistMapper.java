package com.mapper;

import org.apache.ibatis.annotations.Param;

public interface NamelistMapper {

    /**
     * 加入该旅行计划
     *
     * @param travelPlanNo,userId
     * @return
     */
    void joinInTravelPlan(@Param("travelPlanNo") Integer travelPlanNo, @Param("userId") Integer userId);

}
