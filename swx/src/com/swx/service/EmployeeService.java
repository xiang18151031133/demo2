package com.swx.service;

import com.swx.model.Employee;

import java.util.List;

public interface EmployeeService {
    boolean addEmployee(Employee employee);
    Employee getEmployee(Employee employee);
    Employee getEmployeeById(Employee employee);
    boolean updateEmployee(Employee employee);
    List<Employee> listAll();
    List<Employee> listByJdesc(String e_jdesc);
    List<Employee> listByJname(String e_jname);
}
