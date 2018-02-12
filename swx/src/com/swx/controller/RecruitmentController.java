package com.swx.controller;

import com.swx.model.Admin;
import com.swx.model.Recruitment;
import com.swx.model.User;
import com.swx.service.RecruitmentService;
import com.swx.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

@Controller
public class RecruitmentController {
    @Resource
    private RecruitmentService recruitmentService;

    @Resource
    private UserService userService;

    @RequestMapping(value = "/toAddRecruitment",method = RequestMethod.GET)
    public String toAddRecruitment(){
        return "addRecruitment";
    }
    @RequestMapping(value = "/addRecruitment",method = RequestMethod.POST)
    public String addRecruitment(Recruitment recruitment, HttpSession session)throws Exception{
        Admin admin= (Admin) session.getAttribute("admin");
        recruitment.setRm_cid(admin.getA_cid());
        recruitmentService.addRecruitment(recruitment);
        return "adminSuccess";
    }
    @RequestMapping(value = "/showRecruitment",method = RequestMethod.GET)
    public String showRecruitment(Recruitment recruitment,HttpSession session)throws Exception{
        User user1= (User) session.getAttribute("user");
        /*User user1=userService.getUserById(user);
        System.out.println("@@@@"+user1);*/
        session.setAttribute("user",user1);
        Recruitment recruitment1=recruitmentService.getRecruitmentById(recruitment);
        session.setAttribute("recruitment",recruitment1);
        return "showRecruitment";
    }
}
