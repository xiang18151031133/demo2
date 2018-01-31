package com.swx.service.impl;

import com.swx.dao.DepartmentMapper;
import com.swx.service.DepartmentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service("departmentService")
public class DepartmentServiceImpl implements DepartmentService {
    @Resource
    private DepartmentMapper departmentMapper;


}
