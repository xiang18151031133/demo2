package com.swx.service.impl;

import com.swx.dao.DepartmentMapper;
import com.swx.model.Department;
import com.swx.service.DepartmentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("departmentService")
public class DepartmentServiceImpl implements DepartmentService {
    @Resource
    private DepartmentMapper departmentMapper;


    @Override
    public List<Department> listAll() {
        return departmentMapper.listAll();
    }
}
