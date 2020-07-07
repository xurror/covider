<<<<<<< HEAD
<<<<<<< HEAD
import React from 'react';
import {Redirect, Route, Switch} from 'react-router-dom';
import asyncComponent from '../../../util/asyncComponent';

const Dashboard = ({match}) => (
  <div className="app-wrapper">
    <Switch>
      <Redirect exact from={`${match.url}/`} to={`${match.url}/classic`}/>
      <Route path={`${match.url}/classic`} component={asyncComponent(() => import('./routes/Classic'))}/>
      <Route path={`${match.url}/modern`} component={asyncComponent(() => import('./routes/Modern'))}/>
      <Route component={asyncComponent(() => import('app/routes/extraPages/routes/404'))}/>
    </Switch>
  </div>
);

=======
=======
>>>>>>> 4d2bbb99f7304fe93e114a6909260496de0e6fc0
import React from 'react';
import {Redirect, Route, Switch} from 'react-router-dom';
import asyncComponent from '../../../util/asyncComponent';

const Dashboard = ({match}) => (
  <div className="app-wrapper">
    <Switch>
      <Redirect exact from={`${match.url}/`} to={`${match.url}/classic`}/>
      <Route path={`${match.url}/classic`} component={asyncComponent(() => import('./routes/Classic'))}/>
      <Route path={`${match.url}/modern`} component={asyncComponent(() => import('./routes/Modern'))}/>
      <Route component={asyncComponent(() => import('app/routes/extraPages/routes/404'))}/>
    </Switch>
  </div>
);

<<<<<<< HEAD
>>>>>>> 4d2bbb9... backbone for the dashboard
=======
>>>>>>> 4d2bbb99f7304fe93e114a6909260496de0e6fc0
export default Dashboard;