//@flow
import React, { Component } from 'react';
import './App.css';
import { MainLayout } from "./components/Layouts/MainLayout";
import {BrowserRouter as Router, Route, Link} from "react-router-dom";

class App extends Component<{}> {
  render() {
    return (
      <div>
      <Router>
          <Route exact path = "/" component={MainLayout}></Route>
          {/*<Route path="/trip_view" component={TripViewLayout}/>
          <Route path="/ride_request" component={RideRequestLayout}/>
          <Route path="/ride_list_pass" component={RideListPassengerLayout}/>*/}
        </Router>
      </div>
    );
  }
}

export default App;
