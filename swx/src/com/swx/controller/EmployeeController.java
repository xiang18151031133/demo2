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
import java.text.ParseException;
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
        User user2=userService.getUserById(user);
        User user1=userService.getUser(user2);
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
    public @ResponseBody List<Job> searchJobs(Department department, HttpServletResponse response){
        List<Job> jobs=jobService.listByDeptId(department);
        return jobs;
    }

    @RequestMapping("/upTime")
    public @ResponseBody String upTime(HttpSession session){
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm");
        String str=sdf.format(new Date());
        SimpleDateFormat sdf1=new SimpleDateFormat("HH:mm");
        String str1=sdf1.format(new Date());
        //System.out.println(str);
        //System.out.println(str1);
        Employee employee= (Employee) session.getAttribute("employee");
        Attendance attendance=new Attendance();
        attendance.setAt_eid(employee.getE_id());
        attendance.setAt_workTime(str);
        String workTime=employee.getE_workstarttime();
        try {
            Date date1=sdf1.parse(str1);
            Date date2=sdf1.parse(workTime);
            Long time=date1.getTime()-date2.getTime();
            //System.out.println("###"+time);
            if(time<=0){
                attendance.setAt_checkResult(0);
                attendanceService.addAttendanceByUp(attendance);
                return "OK";
            }else if(time>0&&time<=1800){//上班迟到30分钟内
                attendance.setAt_checkResult(1);
                Reward reward=new Reward();
                reward.setRe_eid(employee.getE_id());
                reward.setRe_money(50);
                reward.setRe_reason("上班迟到30分钟内");
                reward.setRe_status(2);
                reward.setRe_time(str);
                //System.out.println(reward);
                //System.out.println(attendance);
                rewardService.addReward(reward);
                attendanceService.addAttendanceByUp(attendance);
                return "ERROR";
            }else {//上班迟到超过 30分钟
                attendance.setAt_checkResult(1);
                Reward reward=new Reward();
                reward.setRe_eid(employee.getE_id());
                reward.setRe_money(150);
                reward.setRe_reason("上班迟到超过30分钟");
                reward.setRe_status(2);
                reward.setRe_time(str);
                //System.out.println(reward);
                //System.out.println(attendance);
                rewardService.addReward(reward);
                attendanceService.addAttendanceByUp(attendance);
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return "";
    }

    @RequestMapping("/downTime")
    public @ResponseBody String downTime(HttpSession session){
        Employee employee= (Employee) session.getAttribute("employee");
        List<Attendance> attendances=attendanceService.listAll(employee);
        int maxIndex=0;
        for(Attendance a:attendances){
            if(a.getAt_id()>maxIndex){
                maxIndex=a.getAt_id();
            }
        }
        if(attendances.size()>0){
            Attendance attendance=attendanceService.getAttendanceById(maxIndex);
            if(attendance.getAt_closeTime()==null){
                SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm");
                String str=sdf.format(new Date());
                SimpleDateFormat sdf1=new SimpleDateFormat("HH:mm");
                String str1=sdf1.format(new Date());
                //System.out.println(str);
                //System.out.println(str1);
                attendance.setAt_closeTime(str);
                String downTime=employee.getE_workendtime();
                try {
                    Date date1=sdf1.parse(str1);
                    Date date2=sdf1.parse(downTime);
                    Long time=date2.getTime()-date1.getTime();
                    //System.out.println("###"+time);
                    if(time<=0&&attendance.getAt_checkResult()==0){
                        attendanceService.updateAttendanceByDown(attendance);
                        return "OK";
                    }else if(time>0&&time<=1800){//下班早退30分钟内
                        attendance.setAt_checkResult(1);
                        Reward reward=new Reward();
                        reward.setRe_eid(employee.getE_id());
                        reward.setRe_money(50);
                        reward.setRe_reason("下班早退30分钟内");
                        reward.setRe_status(2);
                        reward.setRe_time(str);
                        //System.out.println(reward);
                        //System.out.println(attendance);
                        rewardService.addReward(reward);
                        attendanceService.updateAttendanceByDown(attendance);
                        return "ERROR";
                    }else {//下班早退超过 30分钟
                        attendance.setAt_checkResult(1);
                        Reward reward=new Reward();
                        reward.setRe_eid(employee.getE_id());
                        reward.setRe_money(150);
                        reward.setRe_reason("下班早退超过30分钟");
                        reward.setRe_status(2);
                        reward.setRe_time(str);
                        //System.out.println(reward);
                        //System.out.println(attendance);
                        rewardService.addReward(reward);
                        attendanceService.updateAttendanceByDown(attendance);
                        return "ERROR";
                    }
                } catch (ParseException e) {
                    e.printStackTrace();
                }
            }
        }
        return "none";
    }

    @RequestMapping("/sureSalary")
    public String sureSalary(Salary salary,HttpSession session){
        Salary salary1=salaryService.getSalaryById(salary);
        if(salary1.getS_status()==0){
            salary1.setS_status(1);
            salaryService.updateSalary(salary1);
            Employee employee= (Employee) session.getAttribute("employee");
            List<Salary> salaries=salaryService.listAll(employee);
            session.setAttribute("salaries",salaries);
        }
        return "empLoginSuccess";
    }

    @RequestMapping("/appealSalary")
    public String appealSalary(Salary salary,HttpSession session){
        Salary salary1=salaryService.getSalaryById(salary);
        if(salary1.getS_status()==0){
            salary1.setS_status(2);
            salaryService.updateSalary(salary1);
            Employee employee= (Employee) session.getAttribute("employee");
            List<Salary> salaries=salaryService.listAll(employee);
            session.setAttribute("salaries",salaries);
        }
        return "empLoginSuccess";
    }
}
