//@flow
import * as React from "react";
import "../../styles/NavBar.css";
import { Link } from "react-router-dom";

export class NavBar extends React.Component<{}> {
    render() {
        return (
            <div className="NavBar">
            <button className="button">Profile</button>
            <Link to="/trips"><button className="button">Routes map</button></Link>
            <button className="button">Rides</button>
            <button className="button">Change role</button>
            </div>
        );
    }
}