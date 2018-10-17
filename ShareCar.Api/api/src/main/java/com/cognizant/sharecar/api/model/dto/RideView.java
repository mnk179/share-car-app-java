package com.cognizant.sharecar.api.model.dto;

import com.cognizant.sharecar.common.spi.model.RideStatus;

public class RideView {

    private Long id;
    private RideStatus status;
    private Long passengerId;
    private String passengerFirstName;
    private String passengerLastName;
    private Long tripId;
    private Long driverId;
    private String driverFirstName;
    private String driverLastName;

    public RideView(Long id, RideStatus status, Long passengerId, String passengerFirstName, String passengerLastName, Long tripId, Long driverId, String driverFirstName, String driverLastName) {
        this.id = id;
        this.status = status;
        this.passengerId = passengerId;
        this.passengerFirstName = passengerFirstName;
        this.passengerLastName = passengerLastName;
        this.tripId = tripId;
        this.driverId = driverId;
        this.driverFirstName = driverFirstName;
        this.driverLastName = driverLastName;
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

    public String getPassengerFirstName() {
        return passengerFirstName;
    }

    public void setPassengerFirstName(String passengerFirstName) {
        this.passengerFirstName = passengerFirstName;
    }

    public String getPassengerLastName() {
        return passengerLastName;
    }

    public void setPassengerLastName(String passengerLastName) {
        this.passengerLastName = passengerLastName;
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

    public Long getDriverId() {
        return driverId;
    }

    public void setDriverId(Long driverId) {
        this.driverId = driverId;
    }
}
