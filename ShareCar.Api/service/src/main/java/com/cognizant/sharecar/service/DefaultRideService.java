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
import com.cognizant.sharecar.service.exception.NotFoundException;
import com.cognizant.sharecar.service.exception.NotImplementedException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.config.Task;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static com.cognizant.sharecar.common.spi.model.RideStatus.REQUEST_PENDING;
import static java.util.stream.Collectors.toList;

@Service
public class DefaultRideService implements RideService {

    private final RideRepository rideRepository;

    private final UserRepository userRepository;
    private final TripRepository tripRepository;

    public void populateRepoWithDummyData() {
        rideRepository.deleteAll();
        tripRepository.deleteAll();
        userRepository.deleteAll();

        userRepository.save(new User("Tom", "Wiemer", "tom.wiemer@hello.com", "+370612904810"));
        tripRepository.save(new Trip("Alytus->Vilnius", TripStatus.SCHEDULED, LocalDateTime.now(), userRepository.findByEmail("tom.wiemer@hello.com").get(0), new ArrayList<Ride>()));
        rideRepository.save(new Ride(RideStatus.REQUEST_PENDING, userRepository.findByEmail("tom.wiemer@hello.com").get(0), tripRepository.findByRoute("Alytus->Vilnius").get(0)));
    }

    @Autowired
    public DefaultRideService(RideRepository rideRepository, UserRepository userRepository, TripRepository tripRepository) {
        this.rideRepository = rideRepository;
        this.userRepository = userRepository;
        this.tripRepository = tripRepository;
    }

    @Override
    public List<LazyRideView> getAll(GetAllRidesQuery getAllQuery) {
        //populateRepoWithDummyData();

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
//       // try {
//            final Ride rideEntity = new Ride(REQUEST_PENDING, new User(request.getPassengerId()), new Trip(request.getTripId()));
//            Ride detachedEntity = rideRepository.save(rideEntity);
//            return new LazyRideView(detachedEntity.getId(),
//                    detachedEntity.getStatus(),
//                    detachedEntity.getPassenger().getId(),
//                    detachedEntity.getTrip().getId(),
//                    detachedEntity.getTrip().getDriver().getFirstName(),
//                    detachedEntity.getTrip().getDriver().getLastName());
////        }
////        catch (Exception exception) {
////            System.out.println(exception.getStackTrace());
////            throw new NotFoundException("Passenger or trip does not exist");
////        }



        // TODO replace with call to UserService
        final Optional<User> passengerOptional = userRepository.findById(request.getPassengerId());
        // TODO replace with call to TripService
        final Optional<Trip> tripOptional = tripRepository.findById(request.getTripId());

        if (!passengerOptional.isPresent()) {
            throw new NotFoundException("Passenger does not exist");
            //return Optional.empty();
        }
        else if (!tripOptional.isPresent()) {
            throw new NotFoundException("Trip does not exist");
            //return Optional.empty();
        }
        else {
            final Ride rideEntity = new Ride(REQUEST_PENDING, passengerOptional.get(), tripOptional.get());
            Ride detachedEntity = rideRepository.save(rideEntity);
            return new LazyRideView(detachedEntity.getId(),
                    detachedEntity.getStatus(),
                    detachedEntity.getPassenger().getId(),
                    detachedEntity.getTrip().getId(),
                    detachedEntity.getTrip().getDriver().getFirstName(),
                    detachedEntity.getTrip().getDriver().getLastName());
        }
    }

    @Override
    public RideView getOne(Long id) {
        final Optional<Ride> optionalRide = rideRepository.findById(id);
        if (optionalRide.isPresent()) {
            Ride ride = optionalRide.get();
            RideView rideView = new RideView(id,
                    ride.getStatus(),
                    ride.getPassenger().getId(),
                    ride.getPassenger().getFirstName(),
                    ride.getPassenger().getLastName(),
                    ride.getTrip().getId(),
                    ride.getTrip().getDriver().getId(),
                    ride.getTrip().getDriver().getFirstName(),
                    ride.getTrip().getDriver().getLastName());
            return rideView;
        }
        else {
            throw new NotFoundException("Ride with id " + id + " not found");
        }
    }
}
