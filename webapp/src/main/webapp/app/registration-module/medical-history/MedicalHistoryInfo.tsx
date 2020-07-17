import React, { Component } from 'react';
import { FaArrowRight, FaArrowLeft } from "react-icons/fa";
import { Form, FormControl, Spinner } from 'react-bootstrap';
import './MedicalHistoryInfo.css';
import { connect } from 'react-redux';
import axios from 'axios';

class MedicalHistoryInfo extends Component {
  constructor() {
    super();
    this.state = {
      medicalDetails: '',
      covidStatus: '',
      testStatus: '',
      familyNumber: '',
      familyStatus: '',
      loading: false,
    }
  }

  medicalHistory = (event) => {
    this.setState({ medicalDetails: event.target.value })
  }
  covidStatus = (event) => {
    this.setState({ covidStatus: event.target.value })
  }
  testStatus = (event) => {
    this.setState({ testStatus: event.target.value });
  }
  familyNumber = (event) => {
    this.setState({ familyNumber: event.target.value });
  }
  familyStatus = (event) => {
    this.setState({ familyStatus: event.target.value });
  }

  gotoNext(stage) {
    const { medicalDetails, covidStatus } = this.state;
    this.setState({ loading: true })

    let status = false;
    if (covidStatus === 'positive') {
      status = true
    }

    const { token } = this.props
    const { user, changeStage } = this.props;

    const obj = { currentStatus: status, currentSymptoms: [medicalDetails], userIdNumber: user.idNumber, userId: `${user.id}` }

    axios.post('https://covider.herokuapp.com/api/medical/', {obj}, {
      headers: {
        'Content-Type': 'application/json',
        Accept: 'application/json',
        authorization: token,
      }
    })
      .then(res => {
        this.setState({ loading: false })
        changeStage(stage)
        console.log(res.data);
      })
      .catch(err => {
        this.setState({ loading: false })
        console.log(err)
      })
  }

  render() {
    const { user } = this.props;
    const { loading } = this.state;

    return (
      <div className="wrapper shadow">
        <div className="d-flex justify-content-between">
          <div className="p">
            <h4>Enter your medical information history! {user.name}</h4>
          </div>
          <div className="p-2">
            <p className='link dim underline pointer'
              style={{ color: "#B8C5D9" }}>
              Having trouble? <strong className="helpColor">Get Help</strong></p>
          </div>
        </div>
        <p style={{ fontsize: ".8rem" }}>Lorem ipsum dolor sit amet et delectus accommodare his consul copiosae</p>

        <div style={{ width: "70%" }}>
          <FormControl onChange={this.medicalHistory} as="textarea" aria-label="With textarea" rows="4" />
        </div>

        <div style={{ marginTop: "1rem" }}>

          <div style={{ display: 'flex', alignItems: 'center' }}>
            <p>What is your status?</p>
            <div style={{ width: "15%", marginLeft: "1rem" }}>
              <Form.Group controlId="exampleForm.ControlSelect1">
                <Form.Control onChange={this.covidStatus} as="select">
                  <option>negative</option>
                  <option>positive</option>
                </Form.Control>
              </Form.Group>
            </div>
          </div>

          <div style={{ display: 'flex', alignItems: 'center' }}>
            <p>Have you had a covid-19 test before?</p>
            <div style={{ width: "10%", marginLeft: "1rem" }}>
              <Form.Group controlId="exampleForm.ControlSelect1">
                <Form.Control onChange={this.testStatus} as="select">
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
              <Form.Control onChange={this.familyNumber} as="textarea" rows="1" />
            </div>
          </div>

          <div style={{ display: 'flex', alignItems: 'center', width: "80%" }}>
            <div style={{}}>
              <p>How many family members do u leave with?</p>
            </div>
            <div style={{ width: "20%", marginLeft: "1rem", alignItems: "flex-start" }}>
              <Form.Group controlId="exampleForm.ControlSelect1">
                <Form.Control onChange={this.familyStatus} as="select">
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
          {/* <div onClick={() => {
            const stage = {
              stage: 1,
            };
            changeStage(stage)
          }}
            style={{ flex: 1, justifyItems: 'center' }}>
            <p className="link dim pointer" style={{ fontSize: "1.2rem" }}><FaArrowLeft /> Previous</p>
          </div> */}
          <div onClick={() => {
            const stage = {
              stage: 3,
            };
            this.gotoNext(stage)
          }}
            className="nextBtn link pointer ib br2 grow bw2 shadow-3">

            {
              loading ?
                <Spinner animation="border" variant="light" className='ma1' />
                :
                <p style={{ textAlign: 'center', position: "relative", bottom: -7, color: 'white' }}>  Next < FaArrowRight /></p>
            }

          </div>
        </div >


      </div >
    )
  }
}

const mapStateToProps = ({ token }) => {

  return {
    token: token.token
  }
}

export default connect(mapStateToProps, null)(MedicalHistoryInfo);
