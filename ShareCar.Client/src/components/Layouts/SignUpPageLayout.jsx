//@flow
import * as React from "react";
import { NavBar } from "./NavBar";
import { SignUpForm } from "../ShareCarAppItem/SignUpForm";

export class SignUpPageLayout extends React.Component<{}>{

    render(){
        return (
            <div>
            <NavBar/>
            <SignUpForm/>
            </div>
        );
    }
}