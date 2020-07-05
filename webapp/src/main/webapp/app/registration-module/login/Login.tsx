import React, { Component } from 'react';
import { Form, Button } from 'react-bootstrap';

import './Login.css';
import MedicalHistoryInfo from '../medical-history/MedicalHistoryInfo';
import UserLocation from '../location/UserLocation';
import LoginSuccesModal from '../registerSuccesModal/RegisterSuccessModal';

class Login extends Component {
  constructor() {
    super();
    this.state = {
      stage: 1,
      role: '',
      modalShow: false,
    }
  }

  changeStage(level) {
    const { stage } = level;
    this.setState({ stage })
    this.props.changeStage(stage)
  }

  handleLogin() {
    this.props.setFirstTime(true)
    this.setState({ modalShow: true })
    this.setState({ stage: 2 })
  }
  changeRoute(route) {
    this.props.changeRoute(route)
  }

  render() {
    const { stage, modalShow } = this.state;

    if (stage === 1) {
      return (
        <RenderLoginPage
          changeRoute={(route) => this.changeRoute(route)}
          handleLogin={() => this.handleLogin()}
          modalShow={modalShow}
          onHide={() => this.setState({modalShow: false})}
        />
      )
    } else if (stage === 2) {
      return (
        <MedicalHistoryInfo
          changeStage={(stage) => this.changeStage(stage)}
        />
      )
    } else {
      return (
        <UserLocation
          changeStage={(stage) => this.changeStage(stage)}
        />
      )
    }
  }
}

export default Login;

const RenderLoginPage = (props) => {
  const { changeRoute, handleLogin, modalShow, onHide } = props;
  
  return (
    <div className="wrapper shadow ct">
      <div className="card-body">
        <p onClick={() => changeRoute('home')} className='f5 link dim black underline pointer'>Back</p>
        <div className="d-flex justify-content-between">
          <div className="p-2" style={{ marginLeft: "-10px" }}>
            <h4>Login</h4>
          </div>
          <div className="p-2">
            <a href="/help" style={{ color: "#B8C5D9" }}>Having trouble? <strong className="helpColor" >Get Help</strong></a>
          </div>
        </div>

        <div style={{ marginTop: "2rem" }}>
          <p style={{ fontSize: "1.2rem" }}>Welcome back, login to continue</p>
          <p style={{ fontSize: ".8rem;" }}>Lorem ipsum dolor sit amet et delectus accommodare his consul copiosae</p>
        </div>
        <LoginSuccesModal
            show={modalShow}
            onHide={() => onHide()}
          />

        <div style={{ width: "40%" }}>
          <Form>
            <Form.Group controlId="formBasicEmail">
              <Form.Label>Email / Id card number</Form.Label>
              <Form.Control type="email" placeholder="Email / Id card number" />
            </Form.Group>

            <Form.Group controlId="formBasicPassword">
              <Form.Label>Password</Form.Label>
              <Form.Control type="password" placeholder="Password" />
            </Form.Group>
            <Button onClick={() => handleLogin()} className="grow" variant="primary" style={{ backgroundColor: '#6e13ec', borderWidth: 0 }}>
              Login
            </Button>

          </Form>
        </div>
      </div>
    </div>
  )
}