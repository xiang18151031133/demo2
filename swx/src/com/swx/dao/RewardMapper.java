package com.swx.dao;

import com.swx.model.Employee;
import com.swx.model.Reward;

import java.util.List;

public interface RewardMapper {
    List<Reward> listAll(Employee employee);//根据员工id查询员工的所有奖惩记录
    boolean addReward(Reward reward);//增加奖惩记录
    List<Reward> searchAll();//查询所有奖惩记录
    boolean updateRewardStatusByEid(int re_eid);//更新奖惩记录
}
