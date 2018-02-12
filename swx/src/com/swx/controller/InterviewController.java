package com.swx.controller;

import com.swx.model.Interview;
import com.swx.model.Recruitment;
import com.swx.model.Resume;
import com.swx.model.User;
import com.swx.service.InterviewService;
import com.swx.service.RecruitmentService;
import com.swx.service.ResumeService;
import com.swx.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class InterviewController {
    @Resource
    private InterviewService interviewService;

    @Resource
    private UserService userService;

    @Resource
    private RecruitmentService recruitmentService;


    @RequestMapping(value = "/addInterview",method = RequestMethod.POST)
    public String addInterview(Interview interview){
        Recruitment recruitment=new Recruitment();
        recruitment.setRm_id(interview.getI_rmid());
        Recruitment recruitment1=recruitmentService.getRecruitmentById(recruitment);
        interview.setI_cid(recruitment1.getRm_cid());
        interviewService.addInterview(interview);
        return "userSuccess";
    }

    @RequestMapping(value = "/showResume2",method = RequestMethod.POST)
    public String showResume2(User user, HttpSession session){
        User user1=userService.getUserById(user);
        User user2=userService.getUser(user1);
        session.setAttribute("user",user2);
        return "showResume2";
    }

    @RequestMapping(value = "/showRecruitment2",method = RequestMethod.POST)
    public String showRecruitment2(Recruitment recruitment,HttpSession session){
        Recruitment recruitment1=recruitmentService.getRecruitmentById(recruitment);
        session.setAttribute("recruitment",recruitment1);
        return "showRecruitment2";
    }

    @RequestMapping(value = "/toUpdateInterview",method = RequestMethod.POST)
    public String toUpdateInterview(Interview interview,User user,HttpSession session){
        Interview interview1=interviewService.getInterviewById(interview);
        User user1=userService.getUserById(user);
        User user2=userService.getUser(user1);
        session.setAttribute("user",user2);
        session.setAttribute("interview",interview1);
        return "toUpdateInterview";
    }

    @RequestMapping(value = "/updateInterview",method = RequestMethod.POST)
    public String updateInterview(Interview interview,HttpSession session){
        Interview interview1= (Interview) session.getAttribute("interview");
        interview1.setI_interviewaddress(interview.getI_interviewaddress());
        interview1.setI_interviewtime(interview.getI_interviewtime());
        interviewService.updateInterviw(interview1);
        User user= (User) session.getAttribute("user");
        user.setU_status(1);
        userService.updateUser(user);
        return "adminSuccess";
    }

    @RequestMapping(value = "/offer",method = RequestMethod.GET)
    public String offer(HttpSession session){
        User user2= (User) session.getAttribute("user");
        //User user1=userService.getUserById(user);
        User user1=userService.getUser(user2);
        if(user1.getU_status()==1){
            List<Recruitment> recruitments =recruitmentService.listAll();
            List<Interview> interviews =interviewService.getInterviewByUid(user1.getU_id());
            session.setAttribute("interviews",interviews);
            session.setAttribute("recruitments",recruitments);
        }
        return "offer";
    }

    @RequestMapping(value = "/toInterview",method = RequestMethod.POST)
    public String toInterview(Interview interview){
        Interview interview1=interviewService.getInterviewById(interview);
        interview1.setI_ustatus(2);
        interviewService.updateInterviw(interview1);
        return "userSuccess";
    }

    @RequestMapping(value = "/cancleInterview",method = RequestMethod.POST)
    public String cancleInterview(Interview interview,HttpSession session){
        Interview interview1=interviewService.getInterviewById(interview);
        interview1.setI_ustatus(1);
        interviewService.updateInterviw(interview1);
        User user= (User) session.getAttribute("user");
        user.setU_status(0);
        userService.updateUser(user);
        session.setAttribute("user",user);
        session.setAttribute("interview",interview1);
        return "userSuccess";
    }


    /*public String hire(Interview interview,User user,HttpSession session){
        Interview interview1=interviewService.getInterviewById(interview);
        interview1.setI_result(2);
        interviewService.updateInterviw(interview1);
        User user1=userService.getUserById(user);
        user1.setU_status(2);
        userService.updateUser(user1);
        return "adminSuccess";
    }*/

    @RequestMapping(value = "/abandon",method = RequestMethod.POST)
    public String abandon(Interview interview,User user,HttpSession session){
        Interview interview1=interviewService.getInterviewById(interview);
        interview1.setI_result(1);
        interviewService.updateInterviw(interview1);
        User user2=userService.getUserById(user);
        User user1=userService.getUser(user2);
        user1.setU_status(0);
        userService.updateUser(user1);
        return "adminSuccess";
    }
}
