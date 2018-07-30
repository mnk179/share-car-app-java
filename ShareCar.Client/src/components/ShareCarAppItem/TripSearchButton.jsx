import * as React from "react";
import { Link } from "react-router-dom";

export class TripSearchButton extends React.Component {
    render(){
        return(
            <div>
            <Link to="/trips"><button>Routes map</button></Link>
            </div>
        );
    }
}