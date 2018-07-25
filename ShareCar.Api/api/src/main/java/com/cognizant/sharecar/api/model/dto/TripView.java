package com.cognizant.sharecar.api.model.dto;

import com.cognizant.sharecar.common.spi.model.TripStatus;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.hateoas.Identifiable;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class TripView implements Identifiable<Long> {

    private Long id;

    private String route;
    private TripStatus status;
    @JsonFormat(pattern="yyyy-MM-dd HH:mm")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private LocalDateTime dateTime;
    private UserView driver;
    private List<LazyRideView> rides = new ArrayList<>();

    public TripView() {
    }

    public TripView(Long id, String route, TripStatus status, LocalDateTime dateTime, UserView driver, List<LazyRideView> rides) {
        this.id = id;
        this.route = route;
        this.status = status;
        this.dateTime = dateTime;
        this.driver = driver;
        this.rides = rides;
    }

    @Override
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRoute() {
        return route;
    }

    public void setRoute(String route) {
        this.route = route;
    }

    public TripStatus getStatus() {
        return status;
    }

    public void setStatus(TripStatus status) {
        this.status = status;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public UserView getDriver() {
        return driver;
    }

    public void setDriver(UserView driver) {
        this.driver = driver;
    }

    public List<LazyRideView> getRides() {
        return rides;
    }

    public void setRides(List<LazyRideView> rides) {
        this.rides = rides;
    }
}
