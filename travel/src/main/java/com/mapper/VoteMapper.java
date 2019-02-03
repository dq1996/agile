package com.mapper;

import org.apache.ibatis.annotations.Param;

public interface VoteMapper {
    /**
     * 收集各个计划的投票数
     *
     * @param travelPlanNo
     * @return Integer
     */
    Integer getEachPlanVoteNum(@Param("travelPlanNo") Integer travelPlanNo);
}
