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
      email: '',
      name: '',
      idcardnumber: '',
      password: '',
      confirmpassword: '',

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
          emailChange={(event) => this.setState({ email: event.target.value })}
          nameChange={(event) => this.setState({ name: event.target.value })}
          idcardChange={(event) => this.setState({ idcardnumber: event.target.value })}
          passwordChange={(event) => this.setState({ password: event.target.value })}
          confirmPasswordChange={(event) => this.setState({ confirmpassword: event.target.value })}
        />
      )
    } else if (stage === 3) {
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

export default Register;

const RenderRegisterHome = (props) => {
  return (
    <div>
      <div class="wrapper shadow">
        <div class="d-flex justify-content-between">
          <div class="p-2">
            <h4>Register</h4>
          </div>
          <div className="p-2">
            <p className='link dim underline pointer' 
            style={{ color: "#B8C5D9" }}>
              Having trouble? <strong className="helpColor">Get Help</strong></p>
          </div>
        </div>

        <div style={{ marginTop: "2rem", }}>
          <p style={{ fontSize: "1.2rem", }}>Choose your member role</p>
          <p style={{ fontsize: ".8rem" }}>Lorem ipsum dolor sit amet et delectus accommodare his consul copiosae</p>
        </div>

        <div>
          <div onClick={() => {
            const stage = {
              stage: 2,
              role: 'agent',
            };
            props.changeStage(stage)
          }} 
          className= ' dib br2 grow bw2 shadow-3 d-flex flex-row align-items-center choicecards'
            style={{ color: "#000000", textdecoration: "none", marginTop: 40 }}>
            <div class="iconStyle ">
              <h3 class="icon" style={{ color: "#000000a4", fontsize: "5rem" }}><FaUserSecret /></h3>
            </div>
            <div style={{ paddingLeft: "1rem", marginBottom: -5 }}>
              <p style={{ marginBottom: -2 }}>Agent</p>
              <p>Lorem ipsum</p>
            </div>
          </div>

          <div onClick={() => {
            const stage = {
              stage: 2,
              role: 'user',
            };
            props.changeStage(stage)
          }} className= ' dib br2 grow bw2 shadow-3 d-flex flex-row align-items-center choicecards'
            style={{ color: "#000000", textDecoration: "none" }}>
            <div class="iconStyle ">
              <h3 class="icon" style={{ color: "#000000a4", fontSize: "2rem", }}><FaUser /></h3>
            </div>
            <div style={{ paddingLeft: "1rem", marginBottom: -5 }}>
              <p style={{ marginBottom: -2 }}>User</p>
              <p>Lorem ipsum</p>
            </div>
          </div>
        </div>
      </div>
    </div>
  );
}
