//@flow
import * as React from "react";
import "../../styles/NavBar.css";
import { ProfileButton } from "../NavigationBar/ProfileButton";
import { TripListButton } from "../NavigationBar/TripListButton";
import { RidesButton } from "../NavigationBar/RidesButton";
import { ChangeRoleButton } from "../NavigationBar/ChangeRoleButton";

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