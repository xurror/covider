import React, { Component } from 'react';
import { FaArrowLeft } from "react-icons/fa";
import Form from 'react-bootstrap/Form';
import Spinner from 'react-bootstrap/Spinner';
import { connect } from 'react-redux';
import './UserLocation.css';
import axios from 'axios';

class UserLocation extends Component<any, any> {
  constructor(props) {
    super(props);
    this.state = {
      currentLocation: '',
      previousLocation: '',
      loading: false
    }
  }

  currentLocation = (event) => {
    this.setState({ currentLocation: event.target.value })
  }
  previousLocation = (event) => {
    this.setState({ previousLocation: event.target.value })
  }

  addLocation() {
    this.setState({ loading: true })
    const { currentLocation, previousLocation } = this.state;

    const { token } = this.props
    const { user, changeRoute } = this.props;

    axios.post('https://covider.herokuapp.com/api/user-locations/', {
      idNumber: user.idNumber,
      currentLocation: currentLocation,
      previousLocation: [
        previousLocation
      ],
    }, {
      headers: {
        'Content-Type': 'application/json',
        authorization: token,
      }
    })
      .then(res => {
        this.setState({ loading: false })
        changeRoute()
        console.log(res.data);
      })
      .catch(err => {
        this.setState({ loading: false })
        console.log(err)
      })
  }


  render() {
    const { changeStage } = this.props;
    const { loading } = this.state;
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
        <p style={{ fontSize: ".8rem" }}>Fill in details about the different areas you have visited. </p>

        <div style={{ paddingTop: "3rem", width: '40%' }}>
          <Form.Group>
            <Form.Label>Your current address</Form.Label>
            <Form.Control onChange={this.currentLocation} type="text" placeholder="current address" />
          </Form.Group>
          <Form.Group>
            <Form.Label>Your previous address</Form.Label>
            <Form.Control onChange={this.previousLocation} type="text" placeholder="previouse address" />
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
            this.addLocation()
          }}
            className="nextBtn link pointer ib br2 grow bw2 shadow-3">
            {
              loading ?
                <Spinner animation="border" variant="light" className='ma1' />
                :
                <p style={{ textAlign: 'center', position: "relative", bottom: -7, color: 'white' }}>Finish</p>
            }
          </div>
        </div>


      </div>
    )
  }
}

const mapStateToProps = ({ token }) => {

  return {
    token: token.token
  }
}

export default connect(mapStateToProps, null)(UserLocation);
