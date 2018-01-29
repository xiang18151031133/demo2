package com.swx.controller;

import com.swx.model.Admin;
import com.swx.service.AdminService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Resource;

@Controller
public class AdminController {
    @Resource
    private AdminService adminService;

    @RequestMapping(value = "/toAdminLogin",method = RequestMethod.GET)
    public String toAdminLogin(){
        return "adminLogin";
    }

    @RequestMapping(value = "/adminLogin",method = RequestMethod.POST)
    public String adminLogin(Admin admin){
        System.out.println(admin);
        Admin admin1=adminService.getAdmin(admin);
        if(admin1!=null){
            return "adminSuccess";
        }
        return "../../index";
    }
}
