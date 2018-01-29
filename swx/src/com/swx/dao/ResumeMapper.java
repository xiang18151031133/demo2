package com.swx.dao;

import com.swx.model.Resume;

public interface ResumeMapper {
    boolean addResume(Resume resume);
    Resume getResume(Resume resume);
    boolean updateResume(Resume resume);
    boolean deleteResume(Resume resume);
}
