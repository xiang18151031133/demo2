package com.swx.dao;

import com.swx.model.Employee;
import com.swx.model.Reward;

import java.util.List;

public interface RewardMapper {
    List<Reward> listAll(Employee employee);//根据员工id查询员工的所有奖惩记录
}
