package com.cognizant.sharecar.api.resource;

import com.cognizant.sharecar.api.model.dto.TripView;
import com.cognizant.sharecar.api.model.request.AddTripRequest;
import com.cognizant.sharecar.api.model.request.GetAllTripsQuery;
import com.cognizant.sharecar.api.model.response.AddTripResponse;
import com.cognizant.sharecar.api.model.response.GetTripResponse;
import com.cognizant.sharecar.api.spi.TripService;
import com.cognizant.sharecar.common.spi.model.TripStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static java.util.stream.Collectors.toList;

@RestController
@RequestMapping(path = "/trips")
public class TripApi{

    @Autowired
    private TripService tripService;

    @GetMapping(path = "/{id}")
    public ResponseEntity<GetTripResponse> getOne(@PathVariable(name = "id") Long id) {
        TripView trip = tripService.getOne(id);
        return ResponseEntity.ok(new GetTripResponse(trip));
    }

    @GetMapping
    public ResponseEntity<List<GetTripResponse>> getAll(@RequestParam(required = false) TripStatus status) {
        List<TripView> trips = tripService.getAll(new GetAllTripsQuery());
        List<GetTripResponse> responses = trips
                .stream()
                .map(GetTripResponse::new)
                .collect(toList());

        return ResponseEntity.ok(responses);
    }

    @PostMapping ResponseEntity<AddTripResponse> add(@RequestBody AddTripRequest tripRequest){
        try {
            AddTripResponse response = new AddTripResponse(tripService.add(tripRequest));
            return ResponseEntity.ok(response);
        } catch (Exception exception) {
            throw new InternalServerException("Internal error occurred!");
        }
    }
}
