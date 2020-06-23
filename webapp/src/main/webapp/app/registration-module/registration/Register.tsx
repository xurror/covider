import React, { Component } from 'react';
import './Register.css';
import { FaUserSecret, FaUser } from "react-icons/fa";

import UserBasicInfo from '../basic-information/UserBasicInfo';
import MedicalHistoryInfo from '../medical-history/MedicalHistoryInfo';
import UserLocation from '../location/UserLocation';

class Register extends Component {
  constructor() {
    super();
    this.state = {
      stage: 1,
      role: '',
    }
  }
  changeStage(level) {
    const { stage, role } = level;
    this.setState({ stage, role })
    this.props.changeStage(stage)
    this.props.setRole(role)
  }


  render() {
    const { stage, role } = this.state;

    if (stage === 1) {
      return (
        <RenderRegisterHome
          changeStage={(stage) => this.changeStage(stage)}
        />
      )
    } else if (stage === 2) {
      return (
        <UserBasicInfo
          role={role}
          changeStage={(stage) => this.changeStage(stage)}
        />
      )
    }

  }
}

export default Register;

const RenderRegisterHome = (props) => {
  return (
    <div>
     Registration
    </div>
  );
}
