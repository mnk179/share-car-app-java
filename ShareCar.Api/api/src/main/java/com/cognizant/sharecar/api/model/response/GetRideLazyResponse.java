package com.cognizant.sharecar.api.model.response;

import com.cognizant.sharecar.api.model.dto.LazyRideView;
import com.cognizant.sharecar.common.spi.model.RideStatus;

public class GetRideLazyResponse{
    private Long id;
    private RideStatus status;
    private Long passengerId;
    private Long tripId;
    private String driverFirstName;
    private String driverLastName;

    public GetRideLazyResponse(LazyRideView ride){
        this.id = ride.getId();
        this.status = ride.getStatus();
        this.passengerId = ride.getPassengerId();
        this.tripId = ride.getTripId();
        this.driverFirstName = ride.getDriverFirstName();
        this.driverLastName = ride.getDriverLastName();
    }

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

    public Long getPassengerId() {
        return passengerId;
    }

    public void setPassengerId(Long passengerId) {
        this.passengerId = passengerId;
    }

    public Long getTripId() {
        return tripId;
    }

    public void setTripId(Long tripId) {
        this.tripId = tripId;
    }

    public String getDriverFirstName() {
        return driverFirstName;
    }

    public void setDriverFirstName(String driverFirstName) {
        this.driverFirstName = driverFirstName;
    }

    public String getDriverLastName() {
        return driverLastName;
    }

    public void setDriverLastName(String driverLastName) {
        this.driverLastName = driverLastName;
    }
}
