package com.swx.controller;

import com.swx.service.RecruitmentService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Resource;

@Controller
public class RecruitmentController {
    @Resource
    private RecruitmentService recruitmentService;
    @RequestMapping(value = "/toAddRecruitment",method = RequestMethod.GET)
    public String toAddRecruitment(){
        return "addRecruitment";
    }
}
