//@flow
import * as React from "react";
import { NavBar } from "../NavigationBar/NavBar";

export class MainLayout extends React.Component<{}> {

    render() {
        return (
            <div>
                <NavBar/>
            </div>
        );
    }
}