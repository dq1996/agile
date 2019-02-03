package com.mapper;

import com.pojo.TravelPlan;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TravelPlanMapper {

    /**
     * 查看进行中旅行计划
     *
     * @param userId
     * @return TravelPlan
     */
    TravelPlan getOngoingTravelPlan(@Param("userId") Integer userId);

    /**
     * 查看已完成旅行计划
     *
     * @param userId
     * @return List<TravelPlan>
     */
    List<TravelPlan> getCompletedTravelPlan(@Param("userId") Integer userId);

    /**
     * 创建新的旅行计划
     *
     * @param travelPlanNo,travelPlanName,travelLineIntro,status,founderId,moodspictures
     * @return
     */
    void createNewTravelPlan(@Param("travelPlanNo") Integer travelPlanNo,
                             @Param("travelPlanName") String travelPlanName,
                             @Param("travelLineIntro") String travelLineIntro,
                             @Param("status") String status,
                             @Param("founderId") Integer founderId,
                             @Param("moodspictures") List<String> moodspictures);

    /**
     * 分享该旅行计划
     *
     * @param travelPlanNo
     * @return TravelPlan
     */
    TravelPlan shareTravelPlan(@Param("travelPlanNo") Integer travelPlanNo);

    /**
     * 上传旅行中发布的文字和图片
     *
     * @param travelPlanNo,moodspictures
     * @return
     */
    void shareMoodsPictures(@Param("travelPlanNo") Integer travelPlanNo,@Param("moodspictures")String moodspictures);

}
