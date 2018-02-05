package com.swx.dao;

import com.swx.model.Department;
import com.swx.model.Job;

import java.util.List;

public interface JobMapper {
    List<Job> listAll();
    List<Job> listByDeptId(Department department);
}
