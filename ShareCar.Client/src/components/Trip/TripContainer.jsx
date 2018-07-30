// @flow
import * as React from "react";
import Moment from "react-moment";
import "../../styles/TripContainer.css";

type TripContainerProps = {
    trip: Trip,
    key: number
    // onFullDataRequest: () => Promise<TodoItem>,
    // onItemUpdate: (data: TodoItem) => mixed,
    // onItemRemove: () => mixed,
    // onStatusUpdate: (newStatus: TodoItemStatus) => mixed
};

export class TripContainer extends React.Component<TripContainerProps> {

    render() {
        return (
            <tr className="trip-list-container" key={this.props.key}>
                    <td className="trip-route">{this.props.trip.route}</td>
                    <td className="trip-time"><Moment date={this.props.trip.dateTime} format="HH:mm" /></td>
                    <td className="trip-driver-name">{this.props.trip.driver.firstName + " " + this.props.trip.driver.lastName}</td>
            </tr>
        );
    }
}