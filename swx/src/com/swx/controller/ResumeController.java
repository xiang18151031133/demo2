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

    @RequestMapping(value = "/toAddResume",method = RequestMethod.GET)
    public String toAddResume(){
        return "addResume";
    }

    @RequestMapping(value = "/addResume",method = RequestMethod.POST)
    public String addResume(Resume resume, HttpSession session)throws Exception{
        User user= (User) session.getAttribute("user");
        resume.setUser(user);
        resumeService.addResume(resume);
        User user1=userService.getUser(user);
        session.setAttribute("user",user1);
        return "lookResume";
    }

    @RequestMapping(value = "/showResume",method = RequestMethod.GET)
    public String showResume(Resume resume,HttpSession session)throws Exception{
        Resume resume1=resumeService.getResume(resume);
        session.setAttribute("resume",resume1);
        return "showResume";
    }

    @RequestMapping(value = "/toUpdateResume",method = RequestMethod.POST)
    public String toUpdateResume(Resume resume,HttpSession session)throws Exception{
        Resume resume1=resumeService.getResume(resume);
        session.setAttribute("resume",resume1);
        return "updateResume";
    }

    @RequestMapping(value = "/updateResume",method = RequestMethod.POST)
    public String updateResume(Resume resume,HttpSession session)throws Exception{
        User user= (User) session.getAttribute("user");
        resumeService.updateResume(resume);
        User user1=userService.getUser(user);
        session.setAttribute("user",user1);
        return "lookResume";
    }
    @RequestMapping(value = "/deleteResume",method = RequestMethod.POST)
    public String deleteResume(Resume resume,HttpSession session)throws Exception{
        User user= (User) session.getAttribute("user");
        resumeService.deleteResume(resume);
        User user1=userService.getUser(user);
        session.setAttribute("user",user1);
        return "lookResume";
    }
}
