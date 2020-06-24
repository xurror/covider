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
      <div className="wrapper shadow ct">
        <div className="d-flex justify-content-between">
          <div className="p-2">
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
          <p style={{ fontSize: ".8rem" }}>Lorem ipsum dolor sit amet et delectus accommodare his consul copiosae</p>
        </div>

        <div>
          <div onClick={() => {
            const stage = {
              stage: 2,
              role: 'agent',
            };
            props.changeStage(stage)
          }}
            className=' dib br2 grow bw2 shadow-3 d-flex flex-row align-items-center choicecards'
            style={{ color: "#000000", textDecoration: "none", marginTop: 40 }}>
            <div className="iconStyle ">
              <h3 className="icon" style={{ color: "#000000a4", fontSize: "2rem", left: "1px" }}><FaUserSecret /></h3>
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
          }} className=' dib br2 grow bw2 shadow-3 d-flex flex-row align-items-center choicecards'
            style={{ color: "#000000", textDecoration: "none" }}>
            <div className="iconStyle ">
              <h3 className="icon" style={{ color: "#000000a4", fontSize: "2rem", left: "1px" }}><FaUser /></h3>
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
