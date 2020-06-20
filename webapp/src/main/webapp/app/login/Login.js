import React, { Component } from 'react';
import { Form, Button } from 'react-bootstrap';

import './Login.css';

class Login extends Component {
  render() {
    return (
      <div className="wrapper">
        <div class="card-body">
          <p className='f5 link dim black underline pointer'>Back</p>
          <div class="d-flex justify-content-between">
            <div class="p-2" style={{marginLeft: "-10px"}}>
              <h4>Login</h4>
            </div>
            <div class="p-2">
              <a href="/help" style={{color: "#B8C5D9"}}>Having trouble? <strong className="helpColor" >Get Help</strong></a>
            </div>
          </div>

          <div style={{marginTop: "2rem"}}>
            <p style={{fontSize: "1.2rem"}}>Welcome back, login to continue</p>
            <p style={{fontSize: ".8rem;"}}>Lorem ipsum dolor sit amet et delectus accommodare his consul copiosae</p>
          </div>

          <div style={{width: "40%"}}>
            <Form>
              <Form.Group controlId="formBasicEmail">
                <Form.Label>Email address</Form.Label>
                <Form.Control type="email" placeholder="Enter email" />
              </Form.Group>

              <Form.Group controlId="formBasicPassword">
                <Form.Label>Password</Form.Label>
                <Form.Control type="password" placeholder="Password" />
              </Form.Group>
              <Button variant="primary" type="submit" style={{backgroundColor: '#6e13ec', borderWidth: 0}}>
                Login
            </Button>
            </Form>
          </div>
        </div>
      </div>
    );
  }
}

export default Login;