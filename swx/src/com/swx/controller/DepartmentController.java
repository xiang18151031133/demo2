package com.swx.controller;

import com.swx.service.DepartmentService;
import org.springframework.stereotype.Controller;

import javax.annotation.Resource;

@Controller
public class DepartmentController implements DepartmentService {
    @Resource
    private DepartmentService departmentService;


}
