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
public class AdminController {
    @Resource
    private AdminService adminService;

    @Resource
    private JobService jobService;

    @Resource
    private InterviewService interviewService;

    @Resource
    private DepartmentService departmentService;

    @Resource
    private EmployeeService employeeService;

    @Resource
    private RewardService rewardService;

    @Resource
    private SalaryService salaryService;

    @Resource
    private TrainService trainService;

    @Resource
    private AttendanceService attendanceService;


    @RequestMapping(value = "/toAdminLogin",method = RequestMethod.GET)
    public String toAdminLogin(){
        return "adminLogin";
    }

    @RequestMapping(value = "/adminLogin",method = RequestMethod.POST)
    public String adminLogin(Admin admin, HttpSession session)throws Exception{
        Admin admin1=adminService.getAdmin(admin);
        List<Job> jobs=jobService.listAll();
        List<Department> departments=departmentService.listAll();
        List<Employee> employees=employeeService.listAll();
        List<Salary> salaries=salaryService.searchAll();
        if(admin1!=null){
            session.setAttribute("admin",admin1);
            session.setAttribute("jobs",jobs);
            session.setAttribute("departments",departments);
            session.setAttribute("employees",employees);
            session.setAttribute("salaries",salaries);
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

    @RequestMapping("/addDept")
    public String addDept(Department department,HttpSession session){
        Admin admin= (Admin) session.getAttribute("admin");
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
        String str=sdf.format(new Date());
        department.setD_cid(admin.getA_cid());
        department.setD_createTime(str);
        departmentService.addDepartment(department);
        List<Department> departments=departmentService.listAll();
        session.setAttribute("departments",departments);
        return "adminSuccess";
    }

    @RequestMapping("/addJobs")
    public String addJobs(Job job,HttpSession session){
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
        String str=sdf.format(new Date());
        job.setJ_createTime(str);
        jobService.addJobs(job);
        List<Job> jobs=jobService.listAll();
        session.setAttribute("jobs",jobs);
        return "adminSuccess";
    }

    @RequestMapping("/toUpdateDept")
    public String toUpdateDept(Department department,HttpSession session){
        Department department1=departmentService.getDeptById(department);
        session.setAttribute("department1",department1);
        return "updateDept";
    }

    @RequestMapping("/updateDept")
    public String updateDept(Department department,HttpSession session){
        Department department1= (Department) session.getAttribute("department1");
        department1.setD_name(department.getD_name());
        departmentService.updateDeptById(department1);
        List<Department> departments=departmentService.listAll();
        session.setAttribute("departments",departments);
        return "adminSuccess";
    }

    @RequestMapping("/deleteDept")
    public String deleteDept(Department department,HttpSession session){
        Department department1=departmentService.getDeptById(department);
        List<Employee> employees=employeeService.listAll();
        for(Employee e:employees){
            if(e.getE_jdesc().equals(department1.getD_name())){
                return "adminSuccess";
            }
        }
        departmentService.deleteDeptById(department1);
        jobService.deleteByDeptId(department1.getD_id());
        List<Job> jobs=jobService.listAll();
        List<Department> departments=departmentService.listAll();
        session.setAttribute("departments",departments);
        session.setAttribute("jobs",jobs);
        return "adminSuccess";
    }

    @RequestMapping("/showJobAndEmp")
    public String showJobAndEmp(Department department,HttpSession session){
        List<Job> jobList=jobService.listByDeptId(department);
        session.setAttribute("jobList",jobList);
        Department department1=departmentService.getDeptById(department);
        List<Employee> employeeList=employeeService.listByJdesc(department1.getD_name());
        session.setAttribute("employeeList",employeeList);
        return "showJobs";
    }

    @RequestMapping("/toUpdateJob")
    public String toUpdateJob(Job job,HttpSession session){
        Job job1=jobService.getJobById(job);
        session.setAttribute("job1",job1);
        return "updateJob";
    }

    @RequestMapping("/updateJob")
    public String updateJob(Job job,HttpSession session){
        Job job1= (Job) session.getAttribute("job1");
        job1.setJ_name(job.getJ_name());
        jobService.updateJobById(job1);
        List<Job> jobs=jobService.listAll();
        session.setAttribute("jobs",jobs);
        return "adminSuccess";
    }

    @RequestMapping("/deleteJob")
    public String deleteJob(Job job,HttpSession session){
        Job job1=jobService.getJobById(job);
        List<Employee> employees=employeeService.listAll();
        for(Employee e:employees){
            if(e.getE_jname().equals(job1.getJ_name())){
                return "adminSuccess";
            }
        }
        jobService.deleteByJobId(job);
        List<Job> jobs=jobService.listAll();
        session.setAttribute("jobs",jobs);
        return "adminSuccess";
    }

    @RequestMapping("/showEmp")
    public String showEmp(Job job,HttpSession session){
        List<Employee> employeeList=employeeService.listByJname(job.getJ_name());
        session.setAttribute("employeeList",employeeList);
        return "showEmp";
    }

    @RequestMapping("/allEmp")
    public String allEmp(Employee employee,HttpSession session){
        Employee employee1=employeeService.getEmployeeById(employee);
        session.setAttribute("employee",employee1);
        List<Department> departments=departmentService.listAll();
        session.setAttribute("departments",departments);
        List<Attendance> attendances=attendanceService.listAll(employee1);
        session.setAttribute("attendances",attendances);
        return "allEmp";
    }

    @RequestMapping("/searchJobs2")
    public @ResponseBody List<Job> searchJobs2(Department department, HttpServletResponse response){
        List<Job> jobs=jobService.listByDeptId(department);
        return jobs;
    }

    @RequestMapping("/changeJobAndDept")
    public String changeJobAndDept(Department department,Job job,HttpSession session){
        Department department1=departmentService.getDeptById(department);
        Job job1=jobService.getJobById(job);
        Employee employee= (Employee) session.getAttribute("employee");
        employee.setE_jdesc(department1.getD_name());
        employee.setE_jname(job1.getJ_name());
        employeeService.updateEmployee(employee);
        Employee employee1=employeeService.getEmployeeById(employee);
        session.setAttribute("employee",employee1);
        return "allEmp";
    }

    @RequestMapping("/modifyTime")
    public String modifyTime(Employee employee,HttpSession session){
        Employee employee1= (Employee) session.getAttribute("employee");
        employee1.setE_workstarttime(employee.getE_workstarttime());
        employee1.setE_workendtime(employee.getE_workendtime());
        employeeService.updateEmployee(employee1);
        employee1=employeeService.getEmployeeById(employee1);
        session.setAttribute("employee",employee1);
        return "allEmp";
    }

    @RequestMapping("/modifyEmpStatus")
    public String modifyEmpStatus(Employee employee,HttpSession session){
        Employee employee1= (Employee) session.getAttribute("employee");
        employee1.setE_workstatus(employee.getE_workstatus());
        employeeService.updateEmployee(employee1);
        employee1=employeeService.getEmployeeById(employee1);
        session.setAttribute("employee",employee1);
        return "allEmp";
    }

    @RequestMapping("/payOff")
    public String payOff(){
        List<Reward> rewards=rewardService.searchAll();
        List<Employee> employees=employeeService.listAll();
        for(Employee e:employees){
            double bonus=0;
            double punish=0;
            for(Reward r:rewards){
                if(r.getRe_eid()==e.getE_id()){
                    if(r.getRe_status()==1){//奖励
                        bonus+=r.getRe_money();
                    }
                    if(r.getRe_status()==2) {//惩罚
                        punish+=r.getRe_money();
                    }
                }
            }
            Salary salary=new Salary();
            salary.setS_eid(e.getE_id());
            salary.setS_bonus(bonus);
            SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
            String str=sdf.format(new Date());
            salary.setS_date(str);
            salary.setS_punish(punish);
            salary.setS_status(0);
            salary.setS_salary(e.getE_basicwage());
            salary.setS_finalSalary(e.getE_basicwage()+bonus-punish);
            salaryService.addSalary(salary);
            rewardService.updateRewardStatusByEid(e.getE_id());
        }
        return "adminSuccess";
    }

    @RequestMapping("/taAddTrain")
    public String toAddTrain(HttpSession session){
        List<Department> departments=departmentService.listAll();
        List<Employee> employeeList=employeeService.listAll();
        session.setAttribute("employeeList",employeeList);
        session.setAttribute("departments",departments);
        return "addTrain";
    }

    @RequestMapping("/addTrainToAll")
    public String addTrainToAll(Train train,String d_name){
        List<Employee> employees=employeeService.listAll();
        for(Employee e:employees){
            if(d_name.equals(e.getE_jdesc())){
                train.setT_eid(e.getE_id());
                trainService.addTrain(train);
            }
        }
        return "addTrain";
    }

    @RequestMapping("/addTrainByEmp")
    public String  addTrainByEmp(Train train,String str){
        String[] arr=str.split(",");
        for(int i=0;i<arr.length;i++){
            if(arr.length==1&&arr[i].equals("")){
                return "addTrain";
            }
        }
        for(int i=0;i<arr.length;i++){
            if(!arr[i].equals(",")){
                train.setT_eid(Integer.parseInt(arr[i]));
                trainService.addTrain(train);
            }
        }
        return "addTrain";
    }

    @RequestMapping("/bonusOrPunish")
    public String bonusOrPunish(Reward reward,HttpSession session){
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
        String str=sdf.format(new Date());
        Employee employee1= (Employee) session.getAttribute("employee");
        reward.setRe_eid(employee1.getE_id());
        reward.setRe_time(str);
        rewardService.addReward(reward);
        return "allEmp";
    }

    @RequestMapping("/ensureSal")
    public String ensureSal(Salary salary,HttpSession session){
        Salary salary1=salaryService.getSalaryById(salary);
        salary1.setS_status(1);
        salaryService.updateSalary(salary1);
        List<Salary> salaries=salaryService.searchAll();
        session.setAttribute("salaries",salaries);
        return "adminSuccess";
    }
}
