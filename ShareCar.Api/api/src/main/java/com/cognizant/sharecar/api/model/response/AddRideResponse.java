package com.cognizant.sharecar.api.model.response;

import com.cognizant.sharecar.common.spi.model.RideStatus;
import com.fasterxml.jackson.annotation.JsonProperty;

public class AddRideResponse {
    private Long rideId;
    private RideStatus status;
    private Long passengerId;
    private Long tripId;
    private String driverFirstName;
    private String driverLastName;

    public AddRideResponse(Long id, RideStatus status, Long passengerId, Long tripId, String driverFirstName, String driverLastName) {
        this.rideId = id;
        this.status = status;
        this.passengerId = passengerId;
        this.tripId = tripId;
        this.driverFirstName = driverFirstName;
        this.driverLastName = driverLastName;
    }

    @JsonProperty("id")
    public Long getRideId() {
        return rideId;
    }

    @JsonProperty
    public RideStatus getStatus() {
        return status;
    }

    @JsonProperty
    public Long getPassengerId() {
        return passengerId;
    }

    @JsonProperty
    public Long getTripId() {
        return tripId;
    }

    @JsonProperty
    public String getDriverFirstName() {
        return driverFirstName;
    }

    @JsonProperty
    public String getDriverLastName() {
        return driverLastName;
    }
}
