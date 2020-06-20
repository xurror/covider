import React from 'react';
import { FaUserSecret, FaUser, FaArrowRight, FaArrowLeft } from "react-icons/fa";
import { Form, Col, FormControl } from 'react-bootstrap';
import './MedicalHistoryInfo.css';

const MedicalHistoryInfo = (props) => {
  return (
    <div class="wrapper shadow">
      <div class="d-flex justify-content-between">
        <div class="p">
          <h4>Medical information history</h4>
        </div>
        <div className="p-2">
        <p className='link dim underline pointer' 
            style={{ color: "#B8C5D9" }}>
              Having trouble? <strong className="helpColor">Get Help</strong></p>
        </div>
      </div>
      <p style={{ fontsize: ".8rem" }}>Lorem ipsum dolor sit amet et delectus accommodare his consul copiosae</p>

      <div style={{ width: "70%" }}>
        <FormControl as="textarea" aria-label="With textarea" rows="4" />
      </div>

      <div style={{ marginTop: "1rem" }}>

        <div style={{ display: 'flex', alignItems: 'center' }}>
          <p>What is your status?</p>
          <div style={{ width: "15%", marginLeft: "1rem" }}>
            <Form.Group controlId="exampleForm.ControlSelect1">
              <Form.Control as="select">
                <option>negative</option>
                <option>positive</option>
              </Form.Control>
            </Form.Group>
          </div>
        </div>

        <div style={{ display: 'flex', alignItems: 'center' }}>
          <p>What is your status?</p>
          <div style={{ width: "10%", marginLeft: "1rem" }}>
            <Form.Group controlId="exampleForm.ControlSelect1">
              <Form.Control as="select">
                <option>yes</option>
                <option>no</option>
              </Form.Control>
            </Form.Group>
          </div>
        </div>

        <div style={{ display: 'flex', alignItems: 'center', width: "80%" }}>
          <div style={{ flex: 1 }}>
            <p>How many family members do u leave with?</p>
          </div>
          <div style={{ width: "30%", marginLeft: "1rem", flex: 1.5 }}>
            <Form.Control as="textarea" rows="1" />
          </div>
        </div>

        <div style={{ display: 'flex', alignItems: 'center', width: "80%" }}>
          <div style={{}}>
            <p>How many family members do u leave with?</p>
          </div>
          <div style={{ width: "20%", marginLeft: "1rem", alignItems: "flex-start" }}>
            <Form.Group controlId="exampleForm.ControlSelect1">
              <Form.Control as="select">
                <option>All</option>
                <option>None</option>
                <option>1</option>
                <option>2</option>
                <option>3</option>
                <option>4</option>
              </Form.Control>
            </Form.Group>
          </div>
        </div>

      </div>


      <div style={{ display: 'flex', marginTop: "1rem", justifyContent: "space-between" }}>
        <div onClick={() => {
          const stage = {
            stage: 2,
            role: 'user',
          };
          props.changeStage(stage)
        }} 
          style={{ flex: 1, justifyItems: 'center' }}>
          <p  className="link dim pointer" style={{ fontSize: "1.2rem" }}><FaArrowLeft /> Previous</p>
        </div>
        <div onClick={() => {
          const stage = {
            stage: 4,
            role: 'user',
          };
          props.changeStage(stage)
        }}
          className="nextBtn link pointer ib br2 grow bw2 shadow-3">
          <p style={{ textAlign: 'center', position: "relative", bottom: -7, color: 'white' }}>Next <FaArrowRight /></p>
        </div>
      </div >


    </div >
  )
}
export default MedicalHistoryInfo;
