package com.swx.dao;

import com.swx.model.Attendance;
import com.swx.model.Employee;

import java.util.List;

public interface AttendanceMapper {
    List<Attendance> listAll(Employee employee);//根据员工id查询员工的所有考勤记录
    boolean addAttendanceByUp(Attendance attendance);//增加上班打卡
    boolean updateAttendanceByDown(Attendance attendance);// 修改下班打卡
    Attendance getAttendanceById(int at_id);//根据id找到打卡记录
}
