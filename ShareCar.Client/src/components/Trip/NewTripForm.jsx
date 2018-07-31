// @flow
import * as React from "react";
import type {TripService} from "../../api/TripService";
import DayPicker from "react-day-picker";
import "react-day-picker/lib/style.css";

type NewTripFormProps = {
    tripService: TripService
};
type NewTripFormState = {
    selectedDay: Date
};


export class NewTripForm extends React.Component<NewTripFormProps, NewTripFormState> {
    constructor(props: any) {
        super(props);
        this.state = {
            selectedDay: null,
        };
    }
    handleDayClick(day: Date, { selected }) {
        this.setState({
            selectedDay: selected ? undefined : day,
        });
    }
    async handleSubmit(e: any) {
        e.preventDefault();
        const payload = {
            route: e.target.route.value,
            dateTime: this.state.selectedDay
                            .setHours(e.target.timeOfDay.value.slice(0,2), e.target.timeOfDay.value.slice(3))
                            .toISOString,
            driverId: e.target.driverId.value
        };
        console.log(payload.dateTime);
        await this.props.tripService.add(payload);
    }
    render(){
        return(
            <form onSubmit={this.handleSubmit.bind(this)}>
                <label for="route">Route:</label><input type="text" name="route"/>
                <br/>
                <DayPicker
                    selectedDays={this.state.selectedDay}
                    onDayClick={this.handleDayClick.bind(this)}
                />
                <br/>
                <label for="timeOfDay">Time:</label><input type="text" name="timeOfDay" defaultValue="08:00"/>
                <br/>
                <label for="driverId">DriverId:</label><input type="text" name="driverId"/>
                <br/>
                <button>Save</button>
            </form>
        );
    }
}