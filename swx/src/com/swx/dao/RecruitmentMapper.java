package com.swx.dao;

import com.swx.model.Recruitment;

import java.util.List;

public interface RecruitmentMapper {
    boolean addRecruitment(Recruitment recruitment);//增加招聘信息
    List<Recruitment> listAll();//查询所有的招聘信息
    Recruitment getRecruitmentById(Recruitment recruitment);//根据招聘信息的查询招聘信息
}
