package com.swx.service;

import com.swx.model.Employee;
import com.swx.model.Train;

import java.util.List;

public interface TrainService {
    List<Train> listAll(Employee employee);
    boolean addTrain(Train train);
}
