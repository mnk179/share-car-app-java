package com.cognizant.sharecar.api.spi;

import com.cognizant.sharecar.api.model.dto.TripView;
import com.cognizant.sharecar.api.model.request.AddTripRequest;
import com.cognizant.sharecar.api.model.request.GetAllTripsQuery;
import com.cognizant.sharecar.api.model.request.UpdateTripQuery;

import java.util.List;

public interface TripService {

    TripView getOne(Long id);

    List<TripView> getAll(GetAllTripsQuery getAllTripsQuery);

    Long add(AddTripRequest request);

    void update(Long id, UpdateTripQuery updateTripQuery);
}
