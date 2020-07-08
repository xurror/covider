import React from "react";
import { Route, Switch } from "react-router-dom";
import Dashboard from "./dashboard";
import Calendar from "./calendar";
import asyncComponent from "../../util/asyncComponent";
import { withRouter } from "react-router";

const Routes = ({ match }) =>
  <Switch>
    <Route path={`${match.url}/dashboard`} component={Dashboard}/>
    <Route path={`${match.url}/calendar`} component={Calendar}/>
    <Route path={`${match.url}/to-do`}
           component={asyncComponent(() => import("./todo/basic"))}/>
    <Route path={`${match.url}/to-do-redux`}
           component={asyncComponent(() => import("./todo/redux"))}/>
  </Switch>;


export default withRouter(Routes);
