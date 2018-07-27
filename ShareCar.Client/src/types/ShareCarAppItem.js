//@flow

import { TripStatus } from "../utils/constants";

type TripId = number;
type DriverId = number;
type Route = string;
type Status = $Keys<typeof TripStatus>;
//type ShareCarAppItemTripDateTime = dateTime;

type Trip = {
    tripId: TripId,
    driverId: DriverId,
    route: Route,
    status: Status
}