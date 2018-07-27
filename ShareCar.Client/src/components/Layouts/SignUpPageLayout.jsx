//@flow
import * as React from "react";
import { Header } from "../Header";
import { SignUpForm } from "../ShareCarAppItem/SignUpForm";

export class SignUpPageLayout extends React.Component<{}>{

    render(){
        return (
            <div>
            <Header/>
            <SignUpForm/>
            </div>
        );
    }
}