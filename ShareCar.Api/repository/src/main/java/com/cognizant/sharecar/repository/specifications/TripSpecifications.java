package com.cognizant.sharecar.repository.specifications;

import com.cognizant.sharecar.common.spi.model.TripStatus;
import com.cognizant.sharecar.repository.entity.Trip;
import org.springframework.data.jpa.domain.Specification;

import java.time.LocalDate;
import java.time.LocalTime;

public class TripSpecifications{

    public Specification<Trip> tripsFilteredByStatus(TripStatus status) {
        return (Specification<Trip>) (root, query, cb) ->{
            if(status != null)
                return cb.equal(root.get("status"), status);
            else
                return cb.isNotNull(root.get("status"));
        };
    }

    public Specification<Trip> tripsFilteredByDate(LocalDate date) {
        return (Specification<Trip>) (root, query, cb) ->{
            if(date != null)
                return cb.between(root.get("dateTime"), date.atStartOfDay(),date.atTime(LocalTime.MAX));
            else
                return cb.isNotNull(root.get("dateTime"));
        };
    }

    public Specification<Trip> tripsFilteredByDriverId(Long driverId) {
        return (Specification<Trip>) (root, query, cb) ->{
            if(driverId != null)
                return cb.equal(root.join("driver").get("id"), driverId);
            else
                return cb.isNotNull(root.get("driver"));
        };
    }
}
