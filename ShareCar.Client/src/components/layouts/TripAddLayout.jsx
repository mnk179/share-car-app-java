// @flow
import * as React from "react";
import { NewTripForm } from "../Trip/NewTripForm";
import {TripService} from "../../api/TripService";
import { NavBar } from "../NavigationBar/NavBar";

type TripAddLayoutProps = {
    tripService: TripService
};


export class TripAddLayout extends React.Component<TripAddLayoutProps> {

    render(){
        return(
            <div>
                <NavBar/>
                <NewTripForm tripService={this.props.tripService}/>
            </div>
        );
    }
}