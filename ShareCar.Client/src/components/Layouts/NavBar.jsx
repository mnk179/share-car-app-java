//@flow
import * as React from "react";
import "../../styles/NavBar.css";
import { ProfileButton } from "../ShareCarAppItem/ProfileButton";
import { TripListButton } from "../ShareCarAppItem/TripListButton";
import { RidesButton } from "../ShareCarAppItem/RidesButton";
import { ChangeRoleButton } from "../ShareCarAppItem/ChangeRoleButton";

export class NavBar extends React.Component<{}> {
    render() {
        return (
            <div className="NavBar">
            <ProfileButton/>
            <TripListButton/>
            <RidesButton/>
            <ChangeRoleButton/>
            </div>
        );
    }
}