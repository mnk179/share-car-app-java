package com.cognizant.sharecar.api.model.dto;

import com.cognizant.sharecar.common.spi.model.RideStatus;
import org.springframework.hateoas.Identifiable;

public class RideView implements Identifiable<Long> {

    private Long id;
    private RideStatus status;
    private UserView passenger;
    private TripView trip;

    public RideView() {
    }

    public RideView(Long id, RideStatus status, UserView passenger, TripView trip) {
        this.id = id;
        this.status = status;
        this.passenger = passenger;
        this.trip = trip;
    }

    @Override
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public RideStatus getStatus() {
        return status;
    }

    public void setStatus(RideStatus status) {
        this.status = status;
    }

    public UserView getPassenger() {
        return passenger;
    }

    public void setPassenger(UserView passenger) {
        this.passenger = passenger;
    }

    public TripView getTrip() {
        return trip;
    }

    public void setTrip(TripView trip) {
        this.trip = trip;
    }
}
