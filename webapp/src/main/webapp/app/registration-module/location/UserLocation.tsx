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
        Location
      </div>
    )
  }
}

export default UserLocation;
