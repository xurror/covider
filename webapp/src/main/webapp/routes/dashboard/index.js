import React from 'react';
import {Redirect, Route, Switch} from 'react-router-dom';
import asyncComponent from '../../../util/asyncComponent';

const Dashboard = ({match}) => (
  <div className="app-wrapper">
    <Switch>
      <Redirect exact from={`${match.url}/`} to={`${match.url}/crm`}/>
      <Route path={`${match.url}/crm`} component={asyncComponent(() => import('./routes/CRM'))}/>
      <Route path={`${match.url}/listing`} component={asyncComponent(() => import('./routes/Listing'))}/>
      <Route path={`${match.url}/crypto`} component={asyncComponent(() => import('./routes/Crypto'))}/>
      <Route path={`${match.url}/eCommerce`} component={asyncComponent(() => import('./routes/ECommerce'))}/>
      <Route path={`${match.url}/news`} component={asyncComponent(() => import('./routes/News'))}/>
      <Route path={`${match.url}/intranet`} component={asyncComponent(() => import('./routes/Intranet'))}/>
      <Route path={`${match.url}/misc`} component={asyncComponent(() => import('./routes/Misc'))}/>
    </Switch>
  </div>
);

export default Dashboard;