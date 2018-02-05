package com.swx.service;

import com.swx.model.Employee;
import com.swx.model.Salary;

import java.util.List;

public interface SalaryService {
    List<Salary> listAll(Employee employee);
}
