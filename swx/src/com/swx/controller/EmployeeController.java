package com.swx.controller;

import com.swx.model.*;
import com.swx.service.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

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

    @Resource
    private SalaryService salaryService;

    @Resource
    private TrainService trainService;

    @Resource
    private RewardService rewardService;

    @Resource
    private AttendanceService attendanceService;

    @Resource
    private DepartmentService departmentService;

    @Resource
    private JobService jobService;

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
        employee.setE_workstatus(1);
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
        List<Salary> salaries=salaryService.listAll(employee1);
        List<Train> trains=trainService.listAll(employee1);
        List<Reward> rewards=rewardService.listAll(employee1);
        List<Attendance> attendances=attendanceService.listAll(employee1);
        List<Department> departments=departmentService.listAll();
        List<Job> jobs=jobService.listAll();
        if(employee1!=null){
            session.setAttribute("employee",employee1);
            session.setAttribute("salaries",salaries);
            session.setAttribute("trains",trains);
            session.setAttribute("rewards",rewards);
            session.setAttribute("attendances",attendances);
            session.setAttribute("departments",departments);
            session.setAttribute("jobs",jobs);
            return "empLoginSuccess";
        }
        return "empLogin";
    }

    @RequestMapping("/toshowpersonalinfo")
    public String toshowpersonalinfo(){
        return "showpersonalinfo";
    }

    @RequestMapping("/modifyPass")
    public String modifyPass(Employee employee,HttpSession session){
        Employee employee1= (Employee) session.getAttribute("employee");
        employee1.setE_password(employee.getE_password());
        employeeService.updateEmployee(employee1);
        return "../../index";
    }

    @RequestMapping("/searchJobs")
    public @ResponseBody void searchJobs(Department department, HttpServletResponse response){
        System.out.println("$$$"+department);
        List<Job> jobs=jobService.listByDeptId(department);
        System.out.println(jobs);

    }
}
