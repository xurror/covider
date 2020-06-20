import React from 'react';
import { FaArrowRight, FaArrowLeft } from "react-icons/fa";
import { Form, Col } from 'react-bootstrap';
import './UserBasicInfo.css';

const UserBasicInfo = (props) => {
  return (
    <div class="wrapper shadow">
      <div>
        <div class="d-flex justify-content-between">
          <div class="p">
            <h4>Enter your basic information</h4>
          </div>
          <div className="p-2">
          <p className='link dim underline pointer' 
            style={{ color: "#B8C5D9" }}>
              Having trouble? <strong className="helpColor">Get Help</strong></p>
          </div>
        </div>
        <p style={{ fontsize: ".8rem" }}>Lorem ipsum dolor sit amet et delectus accommodare his consul copiosae</p>


        <Form>
          <div style={{ paddingTop: "3rem", width: '70%' }}>
            <Form.Row>
              <Col>
                <Form.Label>Email</Form.Label>
                <Form.Control onChange={props.emailChange} placeholder="Email" />
              </Col>
              <Col>
                <Form.Label>Name</Form.Label>
                <Form.Control onChange={props.nameChange} placeholder="Name" />
              </Col>
            </Form.Row>
          </div>
          <div style={{ width: "35%", paddingTop: "2rem" }}>
            <Form.Group controlId="formBasicEmail">
              <Form.Label>Id card number</Form.Label>
              <Form.Control onChange={props.idcardChange} type="number" placeholder="id card number" />
            </Form.Group>
          </div>
          <div style={{ paddingTop: "1.5rem", width: '70%' }}>
            <Form.Row>
              <Col>
                <Form.Label>Password</Form.Label>
                <Form.Control onChange={props.passwordChange} type="password" placeholder="Password" />
              </Col>
              <Col>
                <Form.Label>Confirm Password</Form.Label>
                <Form.Control onChange={props.confirmPasswordChange} type="password" placeholder="Password" />
              </Col>
            </Form.Row>
          </div>
        </Form>
      </div>
      {
        props.role === "agent" ?
          <div style={{ display: 'flex', marginTop: "2rem", justifyContent: "space-between" }}>
            <div onClick={() => {
              const stage = {
                stage: 1,
                role: 'agent',
              }
              props.changeStage(stage)
            }}  className="link dim pointer"
              style={{ flex: 1, justifyItems: 'center' }}>
              <p style={{ fontSize: "1.2rem" }}><FaArrowLeft /> Previous</p>
            </div>
            <div onClick={() => {}}
              className="nextBtn link pointer ib br2 grow bw2 shadow-3">
              <p style={{ textAlign: 'center', position: "relative", bottom: -7, color: 'white' }}>Finish</p>
            </div>
          </div>
          :
          <div style={{ display: 'flex', marginTop: "2rem", justifyContent: "space-between" }}>
            <div onClick={() => {
              const stage = {
                stage: 1,
                role: 'user',
              }
              props.changeStage(stage)
            }}  
              style={{ flex: 1, justifyItems: 'center' }}>
              <p className="link dim pointer " style={{ fontSize: "1.2rem" }}><FaArrowLeft /> Previous</p>
            </div>
            <div onClick={() => {
              const stage = {
                stage: 3,
                role: 'user',
              };
              props.changeStage(stage)
            }}
              className="nextBtn link pointer ib br2 grow bw2 shadow-3">
              <p style={{ textAlign: 'center', position: "relative", bottom: -7, color: 'white' }}>Next <FaArrowRight /></p>
            </div>
          </div>
      }



    </div >
  )
}
export default UserBasicInfo;
