package com.cognizant.sharecar.api.spi;

import com.cognizant.sharecar.api.model.dto.LazyRideView;
import com.cognizant.sharecar.api.model.dto.RideView;
import com.cognizant.sharecar.api.model.request.AddRideRequest;
import com.cognizant.sharecar.api.model.request.GetAllRidesQuery;

import java.util.List;

public interface RideService {

    List<LazyRideView> getAll(GetAllRidesQuery getAllRidesQueryQuery);

    Long add(AddRideRequest addRideRequest);

    RideView getOne(Long id);
}