//@flow
import * as React from "react";
import {NavBar} from "../NavigationBar/NavBar";
import {TripService} from "../../api/TripService";
import {TripContainer} from "../Trip/TripContainer";
import "../../styles/TripContainer.css";

type TripDetailsLayoutProps = {
    tripService: TripService,
    tripId: TripId
};

type TripDetailsLayoutState = {
    isLoading: boolean,
    trip: Trip
}

export class TripDetailsLayout extends React.Component<TripDetailsLayoutProps, TripDetailsLayoutState> {

    state = {
        isLoading: true,
        trip: null
    };

    async componentDidMount() {
        const data = await this.props.tripService.getSingle(this.props.tripId);
        await new Promise(resolve => setTimeout(resolve, 1000)); //sleep 1000ms
        this.setState({isLoading: false, trip: data});
    }

    render() {
        return (
            <div>
                <NavBar/>
                <div className="trip-details-container">
                    <div>{this.state.trip.id}</div>
                    <div>{this.state.trip.route}</div>
                    <div>{this.state.trip.dateTime}</div>
                </div>
            </div>
        );
    }
}