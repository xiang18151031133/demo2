package com.swx.service.impl;

import com.swx.dao.EmployeeMapper;
import com.swx.model.Employee;
import com.swx.service.EmployeeService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("employeeService")
public class EmployeeServiceImpl implements EmployeeService {
    @Resource
    private EmployeeMapper employeeMapper;
    @Override
    public boolean addEmployee(Employee employee) {
        return employeeMapper.addEmployee(employee);
    }

    @Override
    public Employee getEmployee(Employee employee) {
        return employeeMapper.getEmployee(employee);
    }

    @Override
    public Employee getEmployeeById(Employee employee) {
        return employeeMapper.getEmployeeById(employee);
    }

    @Override
    public boolean updateEmployee(Employee employee) {
        return employeeMapper.updateEmployee(employee);
    }

    @Override
    public List<Employee> listAll() {
        return employeeMapper.listAll();
    }

    @Override
    public List<Employee> listByJdesc(String e_jdesc) {
        return employeeMapper.listByJdesc(e_jdesc);
    }

    @Override
    public List<Employee> listByJname(String e_jname) {
        return employeeMapper.listByJname(e_jname);
    }
}
