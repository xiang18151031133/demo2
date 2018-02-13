package com.swx.service.impl;

import com.swx.dao.SalaryMapper;
import com.swx.model.Employee;
import com.swx.model.Salary;
import com.swx.service.SalaryService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
@Service("salaryService")
public class SalaryServiceImpl implements SalaryService {
    @Resource
    private SalaryMapper salaryMapper;
    @Override
    public List<Salary> listAll(Employee employee) {
        return salaryMapper.listAll(employee);
    }

    @Override
    public boolean addSalary(Salary salary) {
        return salaryMapper.addSalary(salary);
    }

    @Override
    public Salary getSalaryById(Salary salary) {
        return salaryMapper.getSalaryById(salary);
    }

    @Override
    public boolean updateSalary(Salary salary) {
        return salaryMapper.updateSalary(salary);
    }

    @Override
    public List<Salary> searchAll() {
        return salaryMapper.searchAll();
    }
}
