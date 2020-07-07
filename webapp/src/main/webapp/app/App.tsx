import React, { Component } from 'react';
import { BrowserRouter, Route, Switch } from 'react-router-dom';
 
import Home from './distribution_module/Home/Home';
import Login from './distribution_module/Login/Login';
import Geolocation from './distribution_module/Geolocation/Geolocaton';
import Error from './distribution_module/Error';
import Navigation from './distribution_module/Navigation';
 
class App extends Component {
  render() {
    return (      
       <BrowserRouter>
        <div>
          <Navigation />
            <Switch>
             <Route path="/" component={Login} exact/>
             <Route path="/Home" component={Home}/>
             <Route path="/Geolocation" component={Geolocation}/>
            <Route component={Error}/>
           </Switch>
        </div> 
      </BrowserRouter>
    );
  }
}

export default App;