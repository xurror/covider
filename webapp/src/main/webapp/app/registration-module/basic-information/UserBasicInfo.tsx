import React, { Component } from 'react';
import { FaArrowLeft } from "react-icons/fa";
import { Form, Col, Modal, Button } from 'react-bootstrap';

import RegisterSuccessModal from '../registerSuccesModal/RegisterSuccessModal';
import './UserBasicInfo.css';

class UserBasicInfo extends Component {
  constructor() {
    super();
    this.state = {
      email: '',
      name: '',
      idcardnumber: '',
      password: '',
      confirmpassword: '',
      modalShow: false,
    }
  }

  emailChange = (event) => {
    console.log(event.target.value)
    this.setState({ email: event.target.value })
  }
  nameChange = (event) => {
    this.setState({ name: event.target.value })
  }
  idcardChange = (event) => {
    this.setState({ idcardnumber: event.target.value });
  }
  passwordChange = (event) => {
    this.setState({ password: event.target.value });
  }
  confirmPasswordChange = (event) => {
    this.setState({ confirmpassword: event.target.value });
  }

  handleRegister() {
    const { email, name, idcardnumber, password, confirmpassword } = this.state;
    const { role } = this.props;
    var authorities;
    if (role === 'agent') {
      authorities = ['AGENT']
    } else {
      authorities = ['USER']
    }

    console.log(
      {
        email, name, idcardnumber, password, confirmpassword, authorities
      }
    )

    this.setState({ modalShow: true })
  }
  render() {
    const { role, changeStage } = this.props;
    const { modalShow } = this.state;
    return (
      <div className="wrapper shadow">
       UserBasicInfo
      </div >
    )
  }
}

export default UserBasicInfo;
