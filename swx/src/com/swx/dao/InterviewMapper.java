package com.swx.dao;

import com.swx.model.Interview;

import java.util.List;

public interface InterviewMapper {
    boolean addInterview(Interview interview);//增加面试表
    List<Interview> listAll();//查询所有的面试信息
    Interview getInterviewById(Interview interview);//根据id获得面试信息
    boolean updateInterviw(Interview interview);//更新面试信息
    List<Interview> getInterviewByUid(int r_uid);//根据用户id查面试信息
}
