package com.swx.service.impl;

import com.swx.dao.AttendanceMapper;
import com.swx.model.Attendance;
import com.swx.model.Employee;
import com.swx.service.AttendanceService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
@Service("attendanceService")
public class AttendanceServiceImpl implements AttendanceService {
    @Resource
    private AttendanceMapper attendanceMapper;
    @Override
    public List<Attendance> listAll(Employee employee) {
        return attendanceMapper.listAll(employee);
    }
}
