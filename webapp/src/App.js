import React, { Component } from 'react';
import { SignIn } from './components/SignIn'
import './App.css';


export class App extends Component {
  render() {
    return (
      <div className="App">

        <SignIn />
        
      </div>
    );
  }
}

export default App;
