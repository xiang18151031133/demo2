package com.swx.service;

import com.swx.model.Department;

import java.util.List;

public interface DepartmentService {
    List<Department> listAll();
    boolean addDepartment(Department department);
    Department getDeptById(Department department);
    boolean updateDeptById(Department department);
    boolean deleteDeptById(Department department);
}
