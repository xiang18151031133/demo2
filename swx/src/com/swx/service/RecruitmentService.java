package com.swx.service;

import com.swx.model.Recruitment;

import java.util.List;

public interface RecruitmentService {
    boolean addRecruitment(Recruitment recruitment);
    List<Recruitment> listAll();
    Recruitment getRecruitmentById(Recruitment recruitment);
}
