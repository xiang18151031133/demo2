package com.swx.dao;

import com.swx.model.Employee;
import com.swx.model.Salary;

import java.util.List;

public interface SalaryMapper {
    List<Salary> listAll(Employee employee);//根据员工id查询员工的所有工资记录
    boolean addSalary(Salary salary);//增加薪资记录
    Salary getSalaryById(Salary salary);//根据id找到工资记录
    boolean updateSalary(Salary salary);//更新工资记录
    List<Salary> searchAll();//查询所有的工资记录
}
