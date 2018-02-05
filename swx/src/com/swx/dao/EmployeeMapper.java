package com.swx.dao;

import com.swx.model.Employee;

public interface EmployeeMapper {
    boolean addEmployee(Employee employee);//增加员工信息
    Employee getEmployee(Employee employee);//员工登录
    Employee getEmployeeById(Employee employee);//根据id找到员工
    boolean updateEmployee(Employee employee);//修改员工信息
}
