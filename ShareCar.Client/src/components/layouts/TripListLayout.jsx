//@flow
import * as React from "react";
import {NavBar} from "./NavBar";
import {TripService} from "../../api/TripService";
import {TripContainer} from "../Trip/TripContainer";
import "../../styles/TripContainer.css";

type TripListLayoutProps = {
    tripService: TripService
};

type TripListLayoutState = {
    isLoading: boolean,
    trips: Trip[]
}

export class TripListLayout extends React.Component<TripListLayoutProps, TripListLayoutState> {

    state = {
        isLoading: true,
        trips: []
    };

    async componentDidMount() {
        const data = await this.props.tripService.getAll();
        await new Promise(resolve => setTimeout(resolve, 1000)); //sleep 1000ms
        this.setState({isLoading: false, trips: data});
    }

    render() {
        return (
            <div>
                <NavBar/>
                <div className="trip-container">
                
                    <div className="trip-list-container">
                     <span className="trip-description">Marsrutas</span> 
                     <span className="trip-description">Keliones pradzia</span>  
                     <span className="trip-description">Vairuotojas</span>    
                    </div>

                    {this.state.trips.map((x, i) =>
                        <div key={i}>
                            <TripContainer
                                // onFullDataRequest={() => this.props.tripService.getSingle(x)}
                                trip={x}
                                // onItemUpdate={newData => this.handleUpdate(x.id, newData)}
                                // onItemRemove={() => this.handleRemove(x.id)}
                                // onStatusUpdate={newStatus => this.handleStatusUpdate(x.id, newStatus)}
                            />
                        </div>)
                }</div>
            </div>
        );
    }
}