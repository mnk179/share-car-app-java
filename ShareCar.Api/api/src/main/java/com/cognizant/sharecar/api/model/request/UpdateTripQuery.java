package com.cognizant.sharecar.api.model.request;

import com.cognizant.sharecar.common.spi.model.TripStatus;

public class UpdateTripQuery {

    private TripStatus status;

    public UpdateTripQuery() {
    }

    public UpdateTripQuery(TripStatus status) {
        this.status = status;
    }

    public TripStatus getStatus() {
        return status;
    }
}
