import React, { Component } from 'react'
import { NavLink } from 'react-router-dom';
import MuiThemeProvider from 'material-ui/styles/MuiThemeProvider';
import TextField from 'material-ui/TextField'
import "./Login.css"
import logo from './user.png'
import logo1 from './coimage.jpg'

class Login extends Component {
constructor(props){
  super(props);
  this.state={
  username:'',
  password:''
    }
 }

render() {
    return (
      <div className="whole">
      <div className="img">
      <img src={logo1} alt="logo"/>
</div>
      <div className="container">
        <MuiThemeProvider>
          <div>
          <div className="title">
                        <h1>covider</h1>
                    </div>
          <div className="logo">
                        <img src={logo} alt="logo"/>
                    </div>
           <TextField
             hintText="Enter your Username"
             floatingLabelText="Username"
             onChange = {(event,newValue) => this.setState({username:newValue})}
             />
           <br/>
             <TextField
               type="password"
               hintText="Enter your Password"
               floatingLabelText="Password"
               onChange = {(event,newValue) => this.setState({password:newValue})}
               />
             <br/>
             <NavLink to="/Home"><button type="button" className="but" style={style}>Login</button></NavLink>
          </div> <br/>
         </MuiThemeProvider>
         <div className="checkbox">
              <input type="checkbox" id="cbremember"/>
              <label form="chremember">Remember Me &nbsp;&nbsp;&nbsp;&nbsp;</label>
                        <a href="text.html">Forgot Password?</a>
          </div>
      </div>
      </div>
    );
  }
}
const style = {
 margin: 15,
};
export default Login;