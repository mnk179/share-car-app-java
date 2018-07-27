package com.cognizant.sharecar.api.model.request;

import java.time.LocalDateTime;

public class AddTripRequest {

    private String route;
    private LocalDateTime dateTime;
    private Long driverId;

    public AddTripRequest(String route, LocalDateTime dateTime, Long driverId) {
        this.route = route;
        this.dateTime = dateTime;
        this.driverId = driverId;
    }

    public AddTripRequest() {
    }

    public AddTripRequest(String route, Long driverId) {
        this.route = route;
        this.driverId = driverId;
    }

    public String getRoute() {
        return route;
    }

    public void setRoute(String route) {
        this.route = route;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public Long getDriverId() {
        return driverId;
    }

    public void setDriverId(Long driverId) {
        this.driverId = driverId;
    }
}
