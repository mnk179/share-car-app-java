//@flow

type AddTripRequest = {
    route: Route,
    dateTime: string,
    driverId: DriverId
};

type AddTripResponse = {
    id: TripId,

};