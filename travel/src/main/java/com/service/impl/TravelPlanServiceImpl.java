package com.service.impl;

import com.mapper.TravelPlanMapper;
import com.pojo.TravelPlan;
import com.service.TravelPlanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TravelPlanServiceImpl implements TravelPlanService {

    @Autowired
    private TravelPlanMapper travelPlanMapper;

    @Override
    public TravelPlan getOngoingTravelPlan(Integer userId){
        return travelPlanMapper.getOngoingTravelPlan(userId);
    }

    @Override
    public List<TravelPlan> getCompletedTravelPlan(Integer userId){
        return travelPlanMapper.getCompletedTravelPlan(userId);
    }

    @Override
    public void createNewTravelPlan(Integer travelPlanNo,String travelPlanName,String travelLineIntro,
                                    String status,Integer founderId,List<String> moodspictures){
        travelPlanMapper.createNewTravelPlan(travelPlanNo,travelPlanName,travelLineIntro,status,founderId,moodspictures);
    }

    @Override
    public TravelPlan shareTravelPlan(Integer travelPlanNo){
        return travelPlanMapper.shareTravelPlan(travelPlanNo);
    }

    @Override
    public void shareMoodsPictures(Integer travelPlanNo,String moodspictures){
        travelPlanMapper.shareMoodsPictures(travelPlanNo,moodspictures);
    }

}
