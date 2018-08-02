//@flow
import * as React from "react";
import { NavBar } from "../NavigationBar/NavBar";
import { UserService } from "../../api/UserService";
import { UserContainer } from "../User/UserContainer"; 

type ProfilePageLayoutProps = {
    userService: UserService,
    match: any
};

type ProfilePageLayoutState = {
    isLoading: boolean,
    user: User[]
}

export class ProfilePageLayout extends React.Component<ProfilePageLayoutProps, ProfilePageLayoutState> {
    state = {
        isLoading: true,
        user: []
    };
    async componentDidMount() {
        console.log("date " + this.props.match.params.date);
        const data = await this.props.userService.getAll(this.props.match.params.date);
        await new Promise(resolve => setTimeout(resolve, 1000)); //sleep 1000ms
        this.setState({isLoading: false, user: data});
    }
    render() {
        return (
            <div>
                <NavBar/>
                <div>
                    {this.state.user.map((x, i)=>
                    <UserContainer key={i}
                    user={x}
                    />)}
                </div>
            </div>
        );
    }
}