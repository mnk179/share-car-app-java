// @flow
import * as React from "react";
import type {TripService} from "../../api/TripService";

type NewTripFormProps = {
    tripService: TripService
};

export class NewTripForm extends React.Component<NewTripFormProps>{
    async handleSubmit(e: any) {
        e.preventDefault();
        const payload = {
            route: e.target.route.value,
            dateTime: e.target.dateTime.value,
            driverId: e.target.driverId.value
        };
        await this.props.tripService.add(payload);
    }
    render(){
        return(
            <form onSubmit={this.handleSubmit.bind(this)}>
                <label for="route">Route: </label><input type="text" name="route"/>
                <br/>
                <label for="dateTime">DateTime: </label><input type="text" name="dateTime"/>
                <br/>
                <label for="driverId">DriverId: </label><input type="text" name="driverId"/>
                <br/>
                <button>Save</button>
            </form>
        );
    }
}