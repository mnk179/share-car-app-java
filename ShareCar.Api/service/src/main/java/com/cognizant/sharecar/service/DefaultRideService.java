package com.cognizant.sharecar.service;

import com.cognizant.sharecar.api.model.dto.LazyRideView;
import com.cognizant.sharecar.api.model.dto.RideView;
import com.cognizant.sharecar.api.model.request.AddRideRequest;
import com.cognizant.sharecar.api.model.request.GetAllRidesQuery;
import com.cognizant.sharecar.api.spi.RideService;
import com.cognizant.sharecar.common.spi.model.RideStatus;
import com.cognizant.sharecar.common.spi.model.TripStatus;
import com.cognizant.sharecar.repository.entity.Ride;
import com.cognizant.sharecar.repository.entity.Trip;
import com.cognizant.sharecar.repository.entity.User;
import com.cognizant.sharecar.repository.spi.RideRepository;
import com.cognizant.sharecar.repository.spi.TripRepository;
import com.cognizant.sharecar.repository.spi.UserRepository;
import com.cognizant.sharecar.service.exception.NotImplementedException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static java.util.stream.Collectors.toList;

@Service
public class DefaultRideService implements RideService {

    private final RideRepository rideRepository;
//    private final UserRepository userRepository;
//    private final TripRepository tripRepository;

//    @Autowired
//    public DefaultRideService(RideRepository repository) {
//        this.rideRepository = repository;
//    }

    @Autowired
    public DefaultRideService(RideRepository rideRepository) {
        this.rideRepository = rideRepository;
//        this.userRepository = userRepository;
//        this.tripRepository = tripRepository;
    }

    @Override
    public List<LazyRideView> getAll(GetAllRidesQuery getAllQuery) {

//        rideRepository.deleteAll();
//        tripRepository.deleteAll();
//        userRepository.deleteAll();
//
//        userRepository.save(new User("Tom", "Wiemer", "tom.wiemer@hello.com", "+370612904810"));
//        tripRepository.save(new Trip("Alytus->Vilnius", TripStatus.SCHEDULED, LocalDateTime.now(), userRepository.findByEmail("tom.wiemer@hello.com").get(0), new ArrayList<Ride>()));
//        rideRepository.save(new Ride(RideStatus.REQUEST_PENDING, userRepository.findByEmail("tom.wiemer@hello.com").get(0), tripRepository.findByRoute("Alytus->Vilnius").get(0)));

        final RideStatus status = getAllQuery.getStatus();
        final Long passengerId = getAllQuery.getPassengerId();
        final Long tripId = getAllQuery.getTripId();

        List<Ride> rides;

        if (status == null && passengerId == null && tripId == null) {
            rides = rideRepository.findAll();
        }
        else {
            throw new NotImplementedException();
        }
        return rides.stream()
                .map(ride -> new LazyRideView(ride.getId(),
                                    ride.getStatus(),
                                    ride.getPassenger().getId(),
                                    ride.getTrip().getId(),
                                    ride.getTrip().getDriver().getFirstName(),
                                    ride.getTrip().getDriver().getLastName()))
                .collect(toList());
    }

    @Override
    public LazyRideView add(AddRideRequest request) {
        final RideView requestRide = request.getRide();
        final ridePassenger = new User(requestRide.getPassengerFirstName(), requestRide.getPassengerLastName(), requestRide.getPassengerEmail()
        final Ride rideEntity = new Ride(requestRide.getStatus(),
                requestRide.getPassenger()
    }

    @Override
    public LazyTaskView add(AddTaskRequest request) {
        final TaskView requestTask = request.getTask();
        final Task taskEntity = new Task(requestTask.getTitle(),
                requestTask.getDescription(),
                requestTask.getEndDate(),
                requestTask.getStatus(),
                requestTask.getPriority());
        Task detachedEntity = taskRepository.save(taskEntity);
        return new LazyTaskView(detachedEntity.getTaskId());
    }
}
