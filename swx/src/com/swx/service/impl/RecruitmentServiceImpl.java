package com.swx.service.impl;

import com.swx.dao.RecruitmentMapper;
import com.swx.model.Recruitment;
import com.swx.service.RecruitmentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("recruitmentService")
public class RecruitmentServiceImpl implements RecruitmentService {
    @Resource
    private RecruitmentMapper recruitmentMapper;
    @Override
    public boolean addRecruitment(Recruitment recruitment) {
        return recruitmentMapper.addRecruitment(recruitment);
    }

    @Override
    public List<Recruitment> listAll() {
        return recruitmentMapper.listAll();
    }

    @Override
    public Recruitment getRecruitmentById(Recruitment recruitment) {
        return recruitmentMapper.getRecruitmentById(recruitment);
    }
}
