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
      login page
    </div>
  )
}