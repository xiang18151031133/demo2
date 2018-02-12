package com.swx.service;

import com.swx.model.Resume;

public interface ResumeService {
    boolean addResume(Resume resume);
    Resume getResume(int r_uid);
    boolean updateResume(Resume resume);
    boolean deleteResume(Resume resume);
}
