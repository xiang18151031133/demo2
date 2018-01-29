package com.swx.service.impl;

import com.swx.dao.RecruitmentMapper;
import com.swx.model.Recruitment;
import com.swx.service.RecruitmentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service("recruitmentService")
public class RecruitmentServiceImpl implements RecruitmentService {
    @Resource
    private RecruitmentMapper recruitmentMapper;
    @Override
    public boolean addRecruitment(Recruitment recruitment) {
        return recruitmentMapper.addRecruitment(recruitment);
    }
}
