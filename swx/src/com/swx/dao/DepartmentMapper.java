package com.swx.dao;

import com.swx.model.Department;

import java.util.List;

public interface DepartmentMapper {
    List<Department> listAll();//查询所有部门
    boolean addDepartment(Department department);//增加部门
    Department getDeptById(Department department);//根据id找到部门
    boolean updateDeptById(Department department);//更新部门
    boolean deleteDeptById(Department department);//根据id删除部门
}
