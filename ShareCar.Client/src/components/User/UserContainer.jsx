//@flow
import * as React from "react";

type UserContainerProps = {
    user: User;
}

export class UserContainer extends React.Component<UserContainerProps>{
    render() {
        return (
            <div>
            <div>
                {this.props.user.firstName}
            </div>
            <div>
            {this.props.user.lastName}
            </div>
                <div>{this.props.user.email}</div>
                <div>{this.props.user.phoneNo}</div>
                </div>
        );
    }
}