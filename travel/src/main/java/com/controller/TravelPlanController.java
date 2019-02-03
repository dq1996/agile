package com.controller;

import com.alibaba.fastjson.JSON;
import com.pojo.TravelPlan;
import com.service.TravelPlanService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/travelPlan")//所有/travelPlan界面下的方法
public class TravelPlanController {

    private TravelPlanService travelPlanService;

    @RequestMapping(value = "/{userId}/ongoingTravelPlan", method = RequestMethod.GET)//用户的进行中旅行计划
    public @ResponseBody String ongoingTravelPlan(@PathVariable("userId") Integer userId){
        TravelPlan tp = travelPlanService.getOngoingTravelPlan(userId);
        String resultTravelPlan = JSON.toJSONString(tp);
        return resultTravelPlan;
    }

    @RequestMapping(value = "/{userId}/completedTravelPlan", method = RequestMethod.GET)//用户的已完成旅行计划
    public @ResponseBody String completedTravelPlan(@PathVariable("userId") Integer userId){
        List<TravelPlan> tpl = travelPlanService.getCompletedTravelPlan(userId);
        String resultTravelPlanList = JSON.toJSONString(tpl);
        return resultTravelPlanList;
    }

    @RequestMapping(value = "/{travelPlanNo}/{travelPlanName}/{travelLineIntro}/{status}/{userId}/{moodspictures}/newTravelPlan")//创建新的旅行计划
    public @ResponseBody String newTravelPlan( @PathVariable("travelPlanNo") Integer travelPlanNo,
                                               @PathVariable("travelPlanName") String travelPlanName,
                                               @PathVariable("travelLineIntro") String travelLineIntro,
                                               @PathVariable("status") String status,
                                               @PathVariable("userId") Integer founderId,
                                               @PathVariable("moodspictures") List<String> moodspictures){
        travelPlanService.createNewTravelPlan(travelPlanNo,travelPlanName,travelLineIntro,status,founderId,moodspictures);
        return "ac";
    }

    @RequestMapping(value = "/{travelPlanNo}/sharedTravelPlan", method = RequestMethod.GET)//分享自己参与过的旅行计划（包括图片什么的）
    public @ResponseBody String sharedTravelPlan(@PathVariable("travelPlanNo") Integer travelPlanNo){
        TravelPlan tp = travelPlanService.shareTravelPlan(travelPlanNo);
        String resultTravelPlanList = JSON.toJSONString(tp);
        return resultTravelPlanList;
    }

    @RequestMapping(value = "/{travelPlanNo}/{moodspictures}/MoodsPictures")//上传旅行中发布的文字和图片
    public @ResponseBody String MoodsPictures( @PathVariable("travelPlanNo") Integer travelPlanNo,
                                               @PathVariable("moodspictures") String moodspictures){
        travelPlanService.shareMoodsPictures(travelPlanNo,moodspictures);
        return "ac";
    }

}
