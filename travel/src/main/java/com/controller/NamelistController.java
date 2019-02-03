package com.controller;

import com.service.NamelistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/namelist")//所有/namelist界面下的方法

public class NamelistController {

    @Autowired
    private NamelistService namelistService;

    @RequestMapping(value = "/{travelPlanNo}/{userId}/enter")//加入该旅行计划
    public @ResponseBody String enter(@PathVariable("travelPlanNo") Integer travelPlanNo,
                                      @PathVariable("userId") Integer userId){
        namelistService.joinInTravelPlan(travelPlanNo,userId);
        return "ac";
    }

}
