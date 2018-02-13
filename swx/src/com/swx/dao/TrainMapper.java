package com.swx.dao;

import com.swx.model.Employee;
import com.swx.model.Train;

import java.util.List;

public interface TrainMapper {
    List<Train> listAll(Employee employee);//根据员工id查询员工的所有培训记录
    boolean addTrain(Train train);//增加培训记录
}
