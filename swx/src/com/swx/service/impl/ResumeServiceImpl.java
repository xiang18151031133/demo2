package com.swx.service.impl;

import com.swx.dao.ResumeMapper;
import com.swx.model.Resume;
import com.swx.service.ResumeService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service("resumeService")
public class ResumeServiceImpl implements ResumeService {
    @Resource
    private ResumeMapper resumeMapper;
    @Override
    public boolean addResume(Resume resume) {
        return resumeMapper.addResume(resume);
    }

    @Override
    public Resume getResume(int r_uid) {
        return resumeMapper.getResume(r_uid);
    }

    @Override
    public boolean updateResume(Resume resume) {
        return resumeMapper.updateResume(resume);
    }

    @Override
    public boolean deleteResume(Resume resume) {
        return resumeMapper.deleteResume(resume);
    }
}
