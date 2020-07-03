import React, { Component } from "react";
import { Router, Switch, Route } from "react-router-dom";

import Geolocation from "./Geolocation/Geolocation";
import Contact from "./Contact/Contact";
import Health from "./HealthInfo/HealthInfo";
import Login from "./Login/Login";
import history from './history';

export default class Routes extends Component {
    render() {
        return (
            <Router history={history}>
                <Switch>
                    <Route path="/" exact component={Login} />
                    <Route path="/Geolocation" component={Geolocation} />
                    <Route path="/Contact" component={Contact} />
                    <Route path="/Health" component={Health} />
                </Switch>
            </Router>
        )
    }
}