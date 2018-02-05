package com.swx.dao;

import com.swx.model.Attendance;
import com.swx.model.Employee;

import java.util.List;

public interface AttendanceMapper {
    List<Attendance> listAll(Employee employee);//根据员工id查询员工的所有考勤记录
}
