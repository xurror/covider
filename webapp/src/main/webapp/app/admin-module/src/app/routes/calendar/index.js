import React from 'react';
import {Redirect, Route, Switch} from 'react-router-dom';
import asyncComponent from '../../../util/asyncComponent';

const Calendar = ({match}) => (
  <div className="app-wrapper">
    <Switch>
      <Redirect exact from={`${match.url}/`} to={`${match.url}/basic`}/>
      <Route path={`${match.url}/timeslots`} component={asyncComponent(() => import('./routes/timeslots/'))}/>
    </Switch>
  </div>
);

export default Calendar;
