package com.swx.service.impl;

import com.swx.dao.AdminMapper;
import com.swx.model.Admin;
import com.swx.service.AdminService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service("adminService")
public class AdminServiceImpl implements AdminService {
    @Resource
    private AdminMapper adminMapper;
    @Override
    public Admin getAdmin(Admin admin) {
        return adminMapper.getAdmin(admin);
    }
}
