package com.service.impl;
import com.mapper.VoteMapper;
import com.service.VoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VoteServiceImpl implements VoteService {

    @Autowired
    private VoteMapper voteMapper;

    @Override
    public Integer getEachPlanVoteNum( Integer travelPlanNo) {
        return voteMapper.getEachPlanVoteNum(travelPlanNo);
    }
}
