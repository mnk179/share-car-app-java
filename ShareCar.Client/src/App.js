//@flow
import React, {Component} from "react";
import "./App.css";
import {MainLayout} from "./components/layouts/MainLayout";
import {TripListLayout} from "./components/layouts/TripListLayout";
import {BrowserRouter as Router, Switch, Route} from "react-router-dom";
import {RestTripService} from "./api/RestTripService";

const TRIP_SERVICE = new RestTripService();

class App extends Component<{}> {
    render() {
        return (
            <div>
                <Router>
                    <Switch>
                        <Route exact path="/" component={MainLayout}/>
                        <Route exact path="/trips" component={() => <TripListLayout tripService={TRIP_SERVICE}/>}/>
                        {/*<Route path="/ride_request" component={RideRequestLayout}/>
                        <Route path="/ride_list_pass" component={RideListPassengerLayout}/>*/}
                    </Switch>
                </Router>
            </div>
        );
    }
}

export default App;
