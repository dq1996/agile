package com.service;

public interface VoteService {

    /**
     * 收集各个计划的投票数
     *
     * @param travelPlanNo
     * @return Integer
     */
    Integer getEachPlanVoteNum( Integer travelPlanNo);

}
