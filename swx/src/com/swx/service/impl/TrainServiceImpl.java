package com.swx.service.impl;

import com.swx.dao.TrainMapper;
import com.swx.model.Employee;
import com.swx.model.Train;
import com.swx.service.TrainService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
@Service("trainService")
public class TrainServiceImpl implements TrainService {
    @Resource
    private TrainMapper trainMapper;
    @Override
    public List<Train> listAll(Employee employee) {
        return trainMapper.listAll(employee);
    }
}
