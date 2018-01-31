package com.swx.controller;

import com.swx.model.Employee;
import com.swx.model.Interview;
import com.swx.model.Recruitment;
import com.swx.model.User;
import com.swx.service.EmployeeService;
import com.swx.service.InterviewService;
import com.swx.service.RecruitmentService;
import com.swx.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
public class EmployeeController {
    @Resource
    private EmployeeService employeeService;

    @Resource
    private UserService userService;

    @Resource
    private InterviewService interviewService;

    @Resource
    private RecruitmentService recruitmentService;

    @RequestMapping(value = "/hire",method = RequestMethod.POST)
    public String hire(User user, Interview interview, HttpSession session){
        User user1=userService.getUserById(user);
        user1.setU_status(2);
        userService.updateUser(user1);
        Interview interview1=interviewService.getInterviewById(interview);
        interview1.setI_result(2);
        interviewService.updateInterviw(interview1);
        Employee employee=new Employee();
        employee.setE_name(user1.getU_name());
        employee.setE_password(user1.getU_pass());
        employee.setE_realname(user1.getResume().getR_name());
        employee.setE_age(user1.getResume().getR_age());
        employee.setE_ethnicity(user1.getResume().getR_ethnicity());
        employee.setE_phone(user1.getResume().getR_phone());
        employee.setE_address(user1.getResume().getR_address());
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
        String str=sdf.format(new Date());
        employee.setE_hiretime(str);
        employee.setE_cid(interview1.getI_cid());
        Recruitment recruitment=new Recruitment();
        recruitment.setRm_id(interview1.getI_rmid());
        Recruitment recruitment1=recruitmentService.getRecruitmentById(recruitment);
        employee.setE_jdesc(recruitment1.getRm_jdesc());
        employee.setE_jname(recruitment1.getRm_jname());
        employee.setE_basicwage(recruitment1.getRm_money());
        employeeService.addEmployee(employee);
        return "../../index";
    }

    @RequestMapping("/ToEmpLogin")
    public String ToEmpLogin(){
        return "empLogin";
    }
    @RequestMapping("/empLogin")
    public String empLogin(Employee employee,HttpSession session){
        Employee employee1=employeeService.getEmployee(employee);
        if(employee1!=null){
            return "empLoginSuccess";
        }
        return "empLogin";
    }

    @RequestMapping("/toUpdateEmp")
    public String toUpdateEmp(){
        return "updateEmp";
    }
}
