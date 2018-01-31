package com.swx.controller;

import com.swx.model.Admin;
import com.swx.model.Interview;
import com.swx.model.Job;
import com.swx.model.Recruitment;
import com.swx.service.AdminService;
import com.swx.service.InterviewService;
import com.swx.service.JobService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class AdminController {
    @Resource
    private AdminService adminService;

    @Resource
    private JobService jobService;

    @Resource
    private InterviewService interviewService;

    @RequestMapping(value = "/toAdminLogin",method = RequestMethod.GET)
    public String toAdminLogin(){
        return "adminLogin";
    }

    @RequestMapping(value = "/adminLogin",method = RequestMethod.POST)
    public String adminLogin(Admin admin, HttpSession session)throws Exception{
        Admin admin1=adminService.getAdmin(admin);
        List<Job> jobs=jobService.listAll();
        if(admin1!=null){
            session.setAttribute("admin",admin1);
            session.setAttribute("jobs",jobs);
            return "adminSuccess";
        }
        return "../../index";
    }
    @RequestMapping(value = "/showInterview",method = RequestMethod.GET)
    public String showInterview(HttpSession session){
        List<Interview> interviews=interviewService.listAll();
        session.setAttribute("interviews",interviews);
        return "showInterview";
    }

}
