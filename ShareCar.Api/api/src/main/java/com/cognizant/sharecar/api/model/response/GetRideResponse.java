package com.cognizant.sharecar.api.model.response;

import com.cognizant.sharecar.api.model.dto.RideView;
import com.cognizant.sharecar.common.spi.model.RideStatus;

public class GetRideResponse {
    private Long id;
    private RideStatus status;
    private Long passengerId;
    private String passengerFirstName;
    private String passengerLastName;
    private Long tripId;
    private Long driverId;
    private String driverFirstName;
    private String driverLastName;

    public GetRideResponse(RideView rideView) {
        this.id = rideView.getId();
        this.status = rideView.getStatus();
        this.passengerId = rideView.getPassengerId();
        this.passengerFirstName = rideView.getPassengerFirstName();
        this.passengerLastName = rideView.getPassengerLastName();
        this.tripId = rideView.getTripId();
        this.driverId = rideView.getDriverId();
        this.driverFirstName = rideView.getDriverFirstName();
        this.driverLastName = rideView.getDriverLastName();
    }

    public Long getId() {
        return id;
    }

    public RideStatus getStatus() {
        return status;
    }

    public Long getPassengerId() {
        return passengerId;
    }

    public String getPassengerFirstName() {
        return passengerFirstName;
    }

    public String getPassengerLastName() {
        return passengerLastName;
    }

    public Long getTripId() {
        return tripId;
    }

    public Long getDriverId() {
        return driverId;
    }

    public String getDriverFirstName() {
        return driverFirstName;
    }

    public String getDriverLastName() {
        return driverLastName;
    }
}