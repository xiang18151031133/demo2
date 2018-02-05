package com.swx.service.impl;

import com.swx.dao.RewardMapper;
import com.swx.model.Employee;
import com.swx.model.Reward;
import com.swx.service.RewardService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
@Service("rewardService")
public class RewardServiceImpl implements RewardService {
    @Resource
    private RewardMapper rewardMapper;
    @Override
    public List<Reward> listAll(Employee employee) {
        return rewardMapper.listAll(employee);
    }
}
