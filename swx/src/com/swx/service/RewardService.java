package com.swx.service;

import com.swx.model.Employee;
import com.swx.model.Reward;

import java.util.List;

public interface RewardService {
    List<Reward> listAll(Employee employee);
    boolean addReward(Reward reward);
    List<Reward> searchAll();
    boolean updateRewardStatusByEid(int re_eid);
}
