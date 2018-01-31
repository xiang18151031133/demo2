package com.swx.service.impl;

import com.swx.dao.InterviewMapper;
import com.swx.model.Interview;
import com.swx.service.InterviewService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("interviewService")
public class InterviewServiceImpl implements InterviewService {
    @Resource
    private InterviewMapper interviewMapper;

    @Override
    public boolean addInterview(Interview interview) {
        return interviewMapper.addInterview(interview);
    }

    @Override
    public List<Interview> listAll() {
        return interviewMapper.listAll();
    }

    @Override
    public Interview getInterviewById(Interview interview) {
        return interviewMapper.getInterviewById(interview);
    }

    @Override
    public boolean updateInterviw(Interview interview) {
        return interviewMapper.updateInterviw(interview);
    }

    @Override
    public List<Interview> getInterviewByUid(int r_uid) {
        return interviewMapper.getInterviewByUid(r_uid);
    }

}
