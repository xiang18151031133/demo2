package com.swx.controller;

import com.swx.model.User;
import com.swx.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Controller
public class UserController {
    @Resource
    private UserService userService;

    @RequestMapping(value = "/toLogin",method = RequestMethod.GET)
    public String toLogin(){
        return "login";
    }

    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public String login(User user, HttpSession session)throws Exception{
        User user1=userService.getUser(user);
        if(user1!=null){
            session.setAttribute("user",user1);
            return "userSuccess";
        }
       return "login";
    }

    @RequestMapping(value = "/toRegister",method = RequestMethod.GET)
    public String toRegister(){
        return "register";
    }

    @RequestMapping(value = "/register",method = RequestMethod.POST)
    public String register(User user)throws Exception{
        boolean f=userService.addUser(user);
        if(f){
            return "login";
        }
        return "register";
    }
    @RequestMapping(value = "/checkName",method = RequestMethod.POST)
    public @ResponseBody void checkName(User user, HttpServletResponse response)throws Exception{
        User user1=userService.getUserByName(user);
        if(user1!=null){
            response.getWriter().print("用户已存在");
        }else {
            response.getWriter().print("ok");
        }
    }
    @RequestMapping(value = "/toLookResume",method = RequestMethod.GET)
    public String toLookResume(){
        return "lookResume";
    }
}
