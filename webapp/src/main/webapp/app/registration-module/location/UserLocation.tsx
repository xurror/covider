import React, { Component } from 'react';
import { FaArrowLeft } from "react-icons/fa";
import { Form, } from 'react-bootstrap';
import './UserLocation.css';

class UserLocation extends Component {
  constructor() {
    super();
    this.state = {
      currentLocation: '',
      previousLocation: '',
    }
  }

  currentLocation = (event) => {
    this.setState({ currentLocation: event.target.value })
  }
  previousLocation = (event) => {
    this.setState({ previousLocation: event.target.value })
  }



  render() {
    const { changeStage } = this.props;
    return (
      <div className="wrapper shadow">
        <div className="d-flex justify-content-between">
          <div className="p">
            <h4>Location details</h4>
          </div>
          <div className="p-2">
            <p className='link dim underline pointer'
              style={{ color: "#B8C5D9" }}>
              Having trouble? <strong className="helpColor">Get Help</strong></p>
          </div>
        </div>
        <p style={{ fontsize: ".8rem" }}>Lorem ipsum dolor sit amet </p>

        <div style={{ paddingTop: "3rem", width: '40%' }}>
          <Form.Group controlId="formBasicEmail">
            <Form.Label>Your current address</Form.Label>
            <Form.Control onChange={this.currentLocation} type="number" placeholder="current address" />
          </Form.Group>
          <Form.Group controlId="formBasicEmail">
            <Form.Label>Your previous address</Form.Label>
            <Form.Control onChange={this.previousLocation} type="number" placeholder="previouse address" />
          </Form.Group>
        </div>


        <div style={{ display: 'flex', marginTop: "8rem", justifyContent: "space-between" }}>
          <div onClick={() => {
            const stage = {
              stage: 2,
            };
            changeStage(stage)
          }}
            style={{ flex: 1, justifyItems: 'center' }}>
            <p className="link dim pointer" style={{ fontSize: "1.2rem" }}><FaArrowLeft /> Previous</p>
          </div>
          <div onClick={() => {
            const stage = {
              stage: 3,
            };
            changeStage(stage)
          }}
            className="nextBtn link pointer ib br2 grow bw2 shadow-3">
            <p style={{ textAlign: 'center', position: "relative", bottom: -7, color: 'white' }}>Finish</p>
          </div>
        </div>


      </div>
    )
  }
}

export default UserLocation;
