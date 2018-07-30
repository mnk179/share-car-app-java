//@flow

import { TripStatusValues } from "../utils/constants";

type TripId = number;
//type DriverId = number;
type Route = string;
type TripStatus = $Keys<typeof TripStatusValues>;

type Trip = {
    id: TripId,
    route: Route,
    status: TripStatus,
    dateTime: DateTime,
    driver: User,
    rides: Ride[]
}