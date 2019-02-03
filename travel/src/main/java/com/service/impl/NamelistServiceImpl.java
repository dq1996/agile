package com.service.impl;

import com.mapper.NamelistMapper;
import com.service.NamelistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NamelistServiceImpl implements NamelistService {

    @Autowired
    private NamelistMapper namelistMapper;

    @Override
    public void joinInTravelPlan(Integer travelPlanNo,Integer userId){
        namelistMapper.joinInTravelPlan(travelPlanNo,userId);
    }
}
