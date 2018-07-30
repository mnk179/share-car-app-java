package com.cognizant.sharecar.api.model.request;

import com.cognizant.sharecar.common.spi.model.TripStatus;

import java.time.LocalDate;

public class GetAllTripsQuery {

    private TripStatus status;
    private Long driverId;
    private LocalDate date;

    public GetAllTripsQuery() {
    }

    public GetAllTripsQuery(TripStatus status) {
        this.status = status;
    }

    public GetAllTripsQuery(LocalDate date) {
        this.date = date;
    }

    public GetAllTripsQuery(TripStatus status, LocalDate date) {
        this.status = status;
        this.date = date;
    }

    public GetAllTripsQuery(TripStatus status, Long driverId) {
        this.status = status;
        this.driverId = driverId;
    }

    public GetAllTripsQuery(TripStatus status, Long driverId, LocalDate date) {
        this.status = status;
        this.driverId = driverId;
        this.date = date;
    }

    public TripStatus getStatus() { return status; }

    public void setStatus(TripStatus status) {
        this.status = status;
    }

    public Long getDriverId() {
        return driverId;
    }

    public void setDriverId(Long driverId) {
        this.driverId = driverId;
    }

    public LocalDate getDate() { return date; }

    public void setDate(LocalDate date) {
        this.date = date;
    }
}