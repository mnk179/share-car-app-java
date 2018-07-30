//@flow
import * as React from "react";
import { NavBar } from "./NavBar";

export class MainLayout extends React.Component<{}> {

    render() {
        return (
            <div>
                <NavBar/>
            </div>
        );
    }
}