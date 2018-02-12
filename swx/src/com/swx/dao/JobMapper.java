package com.swx.dao;

import com.swx.model.Department;
import com.swx.model.Job;

import java.util.List;

public interface JobMapper {
    List<Job> listAll();
    List<Job> listByDeptId(Department department);//根据部门id找到职位
    boolean addJobs(Job job);//增加职位
    boolean deleteByDeptId(int j_did);//根据部门id删除职位
    Job getJobById(Job job);//根据id获得job
    boolean updateJobById(Job job);//根据id更新job
    boolean deleteByJobId(Job job);//根据job的id删除job
}
