package com.controller;

import com.alibaba.fastjson.JSON;
import com.service.VoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/vote")

public class VoteController {

    @Autowired
    private VoteService voteService;

    @RequestMapping(value = "/{travelPlanNo}/VoteNum", method = RequestMethod.GET)//收集各个计划的投票数
    public @ResponseBody String getEachPlanVoteNum(@PathVariable("travelPlanNo") Integer travelPlanNo){
        Integer voteNum = voteService.getEachPlanVoteNum(travelPlanNo);
        String resultVoteNum = JSON.toJSONString(voteNum);
        return resultVoteNum;
    }
}
