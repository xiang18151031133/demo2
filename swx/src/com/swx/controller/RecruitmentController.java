package com.swx.controller;

import com.swx.model.Recruitment;
import com.swx.service.RecruitmentService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

@Controller
public class RecruitmentController {
    @Resource
    private RecruitmentService recruitmentService;

    @RequestMapping(value = "/toAddRecruitment",method = RequestMethod.GET)
    public String toAddRecruitment(){
        return "addRecruitment";
    }
    @RequestMapping(value = "/addRecruitment",method = RequestMethod.POST)
    public String addRecruitment(Recruitment recruitment, HttpSession session)throws Exception{
        recruitment.setRm_cid(1);
        recruitmentService.addRecruitment(recruitment);
        return "adminSuccess";
    }
    @RequestMapping(value = "/showRecruitment",method = RequestMethod.GET)
    public String showRecruitment(Recruitment recruitment,HttpSession session)throws Exception{
        Recruitment recruitment1=recruitmentService.getRecruitmentById(recruitment);
        session.setAttribute("recruitment",recruitment1);
        return "showRecruitment";
    }
}
