import React, { Component } from 'react';
import { FaArrowRight, FaArrowLeft } from "react-icons/fa";
import { Form, FormControl } from 'react-bootstrap';
import './MedicalHistoryInfo.css';

class MedicalHistoryInfo extends Component {
  constructor() {
    super();
    this.state = {
      medialDetails: '',
      covidStatus: '',
      testStatus: '',
      familyNumber: '',
      familyStatus: '',
    }
  }

  medicalHistory = (event) => {
    this.setState({ medialDetails: event.target.value })
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

  render() {
    const { changeStage } = this.props;
    return (
      <div className="wrapper shadow">
        medical history
      </div >
    )
  }
}
export default MedicalHistoryInfo;
