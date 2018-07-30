// @flow
import * as React from "react";
import { NewTripForm } from "../Trip/NewTripForm";
import {TripService} from "../../api/TripService";

type TripAddLayoutProps = {
    tripService: TripService
};


export class TripAddLayout extends React.Component<TripAddLayoutProps> {

    render(){
        return(
            <div>
                <NewTripForm tripService={this.props.tripService}/>
            </div>
        );
    }
}