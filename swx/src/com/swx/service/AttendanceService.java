package com.swx.service;

import com.swx.model.Attendance;
import com.swx.model.Employee;

import java.util.List;

public interface AttendanceService {
    List<Attendance> listAll(Employee employee);
    boolean addAttendanceByUp(Attendance attendance);
    boolean updateAttendanceByDown(Attendance attendance);
    Attendance getAttendanceById(int at_id);
}
