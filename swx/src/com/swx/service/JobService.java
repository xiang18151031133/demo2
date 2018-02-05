package com.swx.service;

import com.swx.model.Department;
import com.swx.model.Job;

import java.util.List;

public interface JobService {
    List<Job> listAll();
    List<Job> listByDeptId(Department department);
}
