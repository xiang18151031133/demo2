package com.swx.controller;

import com.swx.model.Resume;
import com.swx.model.User;
import com.swx.service.ResumeService;
import com.swx.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

@Controller
public class ResumeController {
    @Resource
    private ResumeService resumeService;

    @Resource
    private UserService userService;

    @RequestMapping(value = "/addResume",method = RequestMethod.POST)
    public String addResume(Resume resume, HttpSession session)throws Exception{
        User user= (User) session.getAttribute("user");
        resume.setUser(user);
        resumeService.addResume(resume);
        Resume resume1=resumeService.getResume(user.getU_id());
        session.setAttribute("resume",resume1);
        return "showResume";
    }

    @RequestMapping(value = "/updateOrAdd",method = RequestMethod.POST)
    public String updateOrAdd(HttpSession session){
        User user= (User) session.getAttribute("user");
        Resume resume=resumeService.getResume(user.getU_id());
        if(resume==null){
            return "addResume";
        }
        session.setAttribute("resume",resume);
        return "updateResume";
    }

    @RequestMapping(value = "/updateResume",method = RequestMethod.POST)
    public String updateResume(Resume resume,HttpSession session)throws Exception{
        resumeService.updateResume(resume);
        User user= (User) session.getAttribute("user");
        Resume resume1=resumeService.getResume(user.getU_id());
        session.setAttribute("resume",resume1);
        return "showResume";
    }
}
