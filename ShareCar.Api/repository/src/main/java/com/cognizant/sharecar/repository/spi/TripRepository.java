package com.cognizant.sharecar.repository.spi;

import com.cognizant.sharecar.repository.entity.Trip;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TripRepository extends JpaRepository<Trip, Long> {
}
