package com.swx.service;

import com.swx.model.Employee;

public interface EmployeeService {
    boolean addEmployee(Employee employee);
    Employee getEmployee(Employee employee);
}
