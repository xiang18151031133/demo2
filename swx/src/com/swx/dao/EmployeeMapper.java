package com.swx.dao;

import com.swx.model.Employee;

import java.util.List;

public interface EmployeeMapper {
    boolean addEmployee(Employee employee);//增加员工信息
    Employee getEmployee(Employee employee);//员工登录
    Employee getEmployeeById(Employee employee);//根据id找到员工
    boolean updateEmployee(Employee employee);//修改员工信息
    List<Employee> listAll();//查询所有员工
    List<Employee> listByJdesc(String e_jdesc);//根据部门名称查员工
    List<Employee> listByJname(String e_jname);//根据职位查询员工
}
