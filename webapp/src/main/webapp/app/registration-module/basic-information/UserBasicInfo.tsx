import React, { Component } from 'react';
import { FaArrowLeft } from "react-icons/fa";
import { Form, Col, Modal, Button } from 'react-bootstrap';
import axios from 'axios';

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
      text: null,
    }
  }

  emailChange = (event) => {
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
    this.setState({ modalShow: true })
    const { email, name, idcardnumber, password, confirmpassword } = this.state;
    const { role, changeRoute } = this.props;

    let userRole;
    if (role === 'agent') {
      userRole = 'AGENT'
    } else {
      userRole = 'USER'
    }

    if (password !== confirmpassword) {
      return this.setState({ text: 'Passwords do not match try again', modalShow: false })
    }

    const obj = {email, name, idNumber: idcardnumber, role: [userRole], password}
    console.log(obj);

    let url = 'https://covider.herokuapp.com/api/register';
    let fetchParams = {
      method: 'POST',
      headers: {
        'Content-Type': 'application/json',
        Accept: 'application/json',
      },
      body: JSON.stringify(obj)
    }
    fetch(url, fetchParams)
      .then(response => {
        const statusCode = response.status;
        const responseJson = response.json();
        return Promise.all([statusCode, responseJson]);
      })
      .then(res => {
        const statusCode = res[0];
        const responseJson = res[1];

        console.log('status', statusCode)
        if (statusCode == 201) {
          console.log(responseJson)
          this.setState({ modalShow: false })
          changeRoute()

        } else if (statusCode == 401) {
          console.log('responseJson')
          this.setState({ modalShow: false })
          // this.setState({ stage: 2 })
        } else {
          console.log('responseJson')
          this.setState({ modalShow: false })
        }


      })
      .catch(err => {
        console.log(err)
      }).finally(fin => console.log('finish'))
  }

  render() {
    const { role, changeStage } = this.props;
    const { modalShow, text } = this.state;

    return (
      <div className="wrapper shadow">
        <div>
          <div className="d-flex justify-content-between">
            <div className="p">
              <h4>Enter your basic information</h4>
            </div>
            <div className="p-2">
              <p className='link dim underline pointer'
                style={{ color: "#B8C5D9" }} onClick={() => this.setState({ show: true })}>
                Having trouble? <strong className="helpColor">Get Help</strong></p>
            </div>
          </div>
          {/* <p style={{ fontsize: ".8rem" }}>Lorem ipsum dolor sit amet et delectus accommodare his consul copiosae</p> */}

          <RegisterSuccessModal
            show={modalShow}
            onHide={() => this.setState({ modalShow: false })}
          />

          <Form>
            <div style={{ paddingTop: "3rem", width: '70%' }}>
              <Form.Row>
                <Col>
                  <Form.Label>Email</Form.Label>
                  <Form.Control onChange={this.emailChange} placeholder="Email" />
                </Col>
                <Col>
                  <Form.Label>Name</Form.Label>
                  <Form.Control onChange={this.nameChange} placeholder="Name" />
                </Col>
              </Form.Row>
            </div>
            <div style={{ width: "35%", paddingTop: "2rem" }}>
              <Form.Group controlId="formBasicEmail">
                <Form.Label>Id card number</Form.Label>
                <Form.Control onChange={this.idcardChange} type="text" placeholder="id card number" />
              </Form.Group>
            </div>
            <div style={{ paddingTop: "1rem", width: '70%' }}>
              <Form.Row>
                <Col>
                  <Form.Label>Password</Form.Label>
                  <Form.Control onChange={this.passwordChange} type="password" placeholder="Password" />
                </Col>
                <Col>
                  <Form.Label>Confirm Password</Form.Label>
                  <Form.Control onChange={this.confirmPasswordChange} type="password" placeholder="Password" />
                </Col>
              </Form.Row>
            </div>
            {
              text ?
                <p style={{ margin: 0, color: 'red' }}>{text}</p>
                :
                null
            }
          </Form>
        </div>
        {
          role === "agent" ?
            <div style={{ display: 'flex', marginTop: "1.5rem", justifyContent: "space-between" }}>
              <div onClick={() => {
                const stage = {
                  stage: 1,
                  role: 'agent',
                }
                changeStage(stage)
              }} className="link dim pointer"
                style={{ flex: 1, justifyItems: 'center' }}>
                <p style={{ fontSize: "1.2rem" }}><FaArrowLeft /> Previous</p>
              </div>
              <div onClick={() => { }}
                className="nextBtn link pointer ib br2 grow bw2 shadow-3">
                <p style={{ textAlign: 'center', position: "relative", bottom: -7, color: 'white' }}>Register</p>
              </div>
            </div>
            :
            <div style={{ display: 'flex', marginTop: "1.5rem", justifyContent: "space-between" }}>
              <div onClick={() => {
                const stage = {
                  stage: 1,
                  role: 'user',
                }
                changeStage(stage)
              }}
                style={{ justifyItems: 'center' }}>
                <p className="link dim pointer " style={{ fontSize: "1.2rem" }}><FaArrowLeft /> Previous</p>
              </div>
              <div onClick={() => this.handleRegister()}
                className="nextBtn link pointer ib br2 grow bw2 shadow-3">
                <p style={{ textAlign: 'center', position: "relative", bottom: -7, color: 'white' }}>Register</p>
              </div>
            </div>
        }
      </div >
    )
  }
}

export default UserBasicInfo;
