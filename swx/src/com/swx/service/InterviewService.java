package com.swx.service;

import com.swx.model.Interview;

import java.util.List;

public interface InterviewService {
    boolean addInterview(Interview interview);
    List<Interview> listAll();
    Interview getInterviewById(Interview interview);
    boolean updateInterviw(Interview interview);
    List<Interview> getInterviewByUid(int r_uid);
}
