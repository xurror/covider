import React from 'react';
import {Redirect, Route, Switch} from 'react-router-dom';
import asyncComponent from '../../../util/asyncComponent';

const Dashboard = ({match}) => (
  <div className="app-wrapper">
    <Switch>
      <Redirect exact from={`${match.url}/`} to={`${match.url}/users`}/>
      <Route path={`${match.url}/users`} component={asyncComponent(() => import('./routes/Users'))}/>
      <Route path={`${match.url}/listing`} component={asyncComponent(() => import('./routes/Listing'))}/>
      <Route path={`${match.url}/crypto`} component={asyncComponent(() => import('./routes/Crypto'))}/>
      <Route path={`${match.url}/news`} component={asyncComponent(() => import('./routes/News'))}/>
    </Switch>
  </div>
);

export default Dashboard;
