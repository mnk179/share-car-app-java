//@flow
import * as React from "react";

type UserDetailsLayoutProps = {
    user: User;
}

export class UserDetailsLayout extends React.Component<UserDetailsLayoutProps>{
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