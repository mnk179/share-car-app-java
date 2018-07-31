package com.cognizant.sharecar.api.model.request;

public class AddRideRequest {

    private Long passengerId;
    private Long tripId;

    public AddRideRequest(Long passengerId, Long tripId) {
        this.passengerId = passengerId;
        this.tripId = tripId;
    }

    public AddRideRequest() {
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
}