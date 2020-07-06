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
          <p style={{ fontsize: ".8rem" }}>Lorem ipsum dolor sit amet et delectus accommodare his consul copiosae</p>

          <RegisterSuccessModal
            show={modalShow}
            onHide={() => this.setState({modalShow: false})}
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
                <Form.Control onChange={this.idcardChange} type="number" placeholder="id card number" />
              </Form.Group>
            </div>
            <div style={{ paddingTop: "1.5rem", width: '70%' }}>
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
          </Form>
        </div>
        {
          role === "agent" ?
            <div style={{ display: 'flex', marginTop: "2rem", justifyContent: "space-between" }}>
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
            <div style={{ display: 'flex', marginTop: "2rem", justifyContent: "space-between" }}>
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
