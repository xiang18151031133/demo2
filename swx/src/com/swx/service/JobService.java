package com.swx.service;

import com.swx.model.Department;
import com.swx.model.Job;

import java.util.List;

public interface JobService {
    List<Job> listAll();
    List<Job> listByDeptId(Department department);
    boolean addJobs(Job job);
    boolean deleteByDeptId(int j_did);
    Job getJobById(Job job);
    boolean updateJobById(Job job);
    boolean deleteByJobId(Job job);
}
