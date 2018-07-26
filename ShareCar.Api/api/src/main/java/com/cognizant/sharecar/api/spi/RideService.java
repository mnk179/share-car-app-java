package com.cognizant.sharecar.api.spi;

import com.cognizant.sharecar.api.model.dto.LazyRideView;
import com.cognizant.sharecar.api.model.request.AddRideRequest;
import com.cognizant.sharecar.api.model.request.GetAllRidesQuery;

import java.util.List;

public interface RideService {

    List<LazyRideView> getAll(GetAllRidesQuery getAllQuery);

    LazyRideView add(AddRideRequest ride);

//
//    TaskView getOne(Long id);
//
//    LazyTaskView add(AddTaskRequest task);
//
//    void delete(long id);
}