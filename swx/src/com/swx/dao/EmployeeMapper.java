package com.swx.dao;

import com.swx.model.Employee;

public interface EmployeeMapper {
    boolean addEmployee(Employee employee);//增加员工信息
    Employee getEmployee(Employee employee);//员工登录
}
