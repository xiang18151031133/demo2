package com.swx.dao;

import com.swx.model.Resume;

public interface ResumeMapper {
    boolean addResume(Resume resume);
    Resume getResume(int r_uid);//根据用户id来查
    boolean updateResume(Resume resume);
    boolean deleteResume(Resume resume);
}
