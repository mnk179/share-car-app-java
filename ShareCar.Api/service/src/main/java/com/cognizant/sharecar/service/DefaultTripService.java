package com.cognizant.sharecar.service;

import com.cognizant.sharecar.api.model.dto.TripView;
import com.cognizant.sharecar.api.model.request.AddTripRequest;
import com.cognizant.sharecar.api.model.request.GetAllTripsQuery;
import com.cognizant.sharecar.api.model.request.UpdateTripQuery;
import com.cognizant.sharecar.api.spi.TripService;
import com.cognizant.sharecar.common.spi.model.TripStatus;
import com.cognizant.sharecar.repository.entity.Trip;
import com.cognizant.sharecar.repository.entity.User;
import com.cognizant.sharecar.repository.spi.TripRepository;
import com.cognizant.sharecar.service.exception.NotFoundException;
import com.cognizant.sharecar.service.utils.TripMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import static java.util.stream.Collectors.toList;

@Service
public class DefaultTripService implements TripService {

    private final TripRepository tripRepository;

    @Autowired
    public DefaultTripService(TripRepository tripRepository) {
        this.tripRepository = tripRepository;
    }

    @Override
    public TripView getOne(Long id) {
        return tripRepository.findById(id)
                .map(TripMapper::mapEntityToView)
                .orElseThrow(() -> new NotFoundException("Trip with id " + id + " was not found"));
    }

    @Override
    public List<TripView> getAll(GetAllTripsQuery getAllTripsQuery){
        final TripStatus status = getAllTripsQuery.getStatus();
        final Long driverId = getAllTripsQuery.getDriverId();
        final LocalDate date = getAllTripsQuery.getDate();

        List<Trip> result = new ArrayList<>();

        //TODO find by status and driverId
        if(date == null & status == null && driverId == null)
            result = tripRepository.findAll();
        else if(date != null)
            result = tripRepository.findByDateTimeBetween(date.atStartOfDay(), date.atTime(LocalTime.MAX));

        return result.stream()
                .map(TripMapper::mapEntityToView)
                .collect(toList());
    }

    @Override
    public Long add(AddTripRequest request) {
        final Trip tripEntity = new Trip(request.getRoute(),
                TripStatus.SCHEDULED,
                request.getDateTime(),
                new User(request.getDriverId())
        );
        return tripRepository.save(tripEntity).getId();
    }

    @Override
    public void update(Long id, UpdateTripQuery updateTripQuery) {
        final TripStatus status = updateTripQuery.getStatus();
        final Trip trip = tripRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Trip with id " + id + " was not found"));

        if(status != null)
            trip.setStatus(status);

        tripRepository.save(trip);
    }
}
