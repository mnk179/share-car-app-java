// @flow
import * as React from "react";
import Moment from "react-moment";
import "../../styles/TripContainer.css";

type TripContainerProps = {
    trip: Trip,
    // onFullDataRequest: () => Promise<TodoItem>,
    // onItemUpdate: (data: TodoItem) => mixed,
    // onItemRemove: () => mixed,
    // onStatusUpdate: (newStatus: TodoItemStatus) => mixed
};

export class TripContainer extends React.Component<TripContainerProps> {

    render() {
        return (
            <div>
                <div className="trip-list-container">
                    <span className="trip-route">{this.props.trip.route}</span>
                    {/*<span className="trip-time">{this.props.trip.dateTime}</span>*/}
                    <span className="trip-time"><Moment date={this.props.trip.dateTime} format="HH:mm" /></span>
                    <span className="trip-driver-name">{this.props.trip.driver.firstName + " " + this.props.trip.driver.lastName}</span>
                </div>
            </div>
        );
    }
}