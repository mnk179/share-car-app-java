//@flow
import React, {Component} from "react";
import "./App.css";
import {MainLayout} from "./components/layouts/MainLayout";
import {TripListLayout} from "./components/layouts/TripListLayout";
import {TripAddLayout} from "./components/layouts/TripAddLayout";
import {TripDetailsLayout} from "./components/layouts/TripDetailsLayout";
import {BrowserRouter as Router, Switch, Route} from "react-router-dom";
import {RestTripService} from "./api/RestTripService";
import { TripSearchLayout } from "./components/layouts/TripSearchLayout";
import { RestUserService } from "./api/RestUserService";
import { ProfilePageLayout } from "./components/layouts/ProfilePageLayout";


const TRIP_SERVICE = new RestTripService();
const USER_SERVICE = new RestUserService();

class App extends Component<{}> {
    render() {
        return (
            <div>
                <Router>
                    <Switch>
                        {/*<Route path="/ride_request" component={RideRequestLayout}/>
                        <Route path="/ride_list_pass" component={RideListPassengerLayout}/>*/}
                        <Route name="main" exact path="/" component={MainLayout}/>
                        <Route name="trip_details" exact path="/trips/details/:id" component={props => <TripDetailsLayout {...props} tripService={TRIP_SERVICE}/>}/>
                        <Route name="trip_search" exact path="/trips/search" component={() => <TripSearchLayout tripService={TRIP_SERVICE}/>}/>
                        <Route name="new_trip" exact path="/trips/new" component={() => <TripAddLayout tripService={TRIP_SERVICE}/>}/>
                        <Route name="trips" path="/trips/:date?" render={props => <TripListLayout {...props} tripService={TRIP_SERVICE}/>}/>
                        <Route name="trip_details" exact path="/trips/details" component={() => <TripDetailsLayout tripService={TRIP_SERVICE}/>}/>
                        <Route name="profile" path="/profile/:id?" render={props => <ProfilePageLayout userService={USER_SERVICE}/>}/>
                    </Switch>
                </Router>
            </div>
        );
    }
}

export default App;
