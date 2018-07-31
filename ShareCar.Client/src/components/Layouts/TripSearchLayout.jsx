// @flow
import * as React from "react";
import { TripSearchForm } from "../Trip/TripSearchForm";
import {TripService} from "../../api/TripService";
import { NavBar } from "./NavBar";

type TripSearchLayoutProps = {
    tripService: TripService
};


export class TripSearchLayout extends React.Component<TripSearchLayoutProps> {

    render(){
        return(
            <div>
                <NavBar/>
                <TripSearchForm tripService={this.props.tripService}/>
            </div>
        );
    }
}