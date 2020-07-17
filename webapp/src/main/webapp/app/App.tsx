import React, { Component } from 'react';
import { BrowserRouter, Route, Switch } from 'react-router-dom';
 
import Home from './distribution_module/Home/Home';
import Login from './distribution_module/Login/Login';
import Geolocation from './distribution_module/Geolocation/Geolocation';
import Error from './distribution_module/Error';
 
class App extends Component {
  render() {
    return (      
       <BrowserRouter>
        <div>
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