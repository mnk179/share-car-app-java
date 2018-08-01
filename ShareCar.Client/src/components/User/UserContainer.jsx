//@flow
import * as React from "react";

type UserContainerProps = {
    user: User;
}

export class UserContainer extends React.Component<UserContainerProps>{
    render() {
        return (
            <div>
                {this.props.user.firstName;
                this.props.user.lastName;
                this.props.user.email;
                this.props.user.phoneNo;
                this.props.user.trips;
                this.props.user.rides;}
            </div>
        );
    }
}