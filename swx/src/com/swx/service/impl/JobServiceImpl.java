package com.swx.service.impl;

import com.swx.dao.JobMapper;
import com.swx.model.Department;
import com.swx.model.Job;
import com.swx.service.JobService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
@Service("jobService")
public class JobServiceImpl implements JobService {

    @Resource
    private JobMapper jobMapper;
    @Override
    public List<Job> listAll() {
        return jobMapper.listAll();
    }

    @Override
    public List<Job> listByDeptId(Department department) {
        return jobMapper.listByDeptId(department);
    }
}
