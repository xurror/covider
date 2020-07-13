import React, { Component } from 'react';
import Form from 'react-bootstrap/Form';
import Button from 'react-bootstrap/Button';

import './Login.css';
import MedicalHistoryInfo from '../medical-history/MedicalHistoryInfo';
import UserLocation from '../location/UserLocation';
import LoginSuccesModal from '../loginSuccesModal/LoginSuccesModal';

import { setToken } from '../redux/actions/authActions';
import { connect } from 'react-redux';

declare const Buffer

class Login extends Component<any,any> {
  constructor(props) {
    super(props);
    this.state = {
      stage: 1,
      role: '',
      modalShow: false,
      password: '',
      idNumber: '',

      user: {}
    }
  }

  changeStage(level) {
    const { stage } = level;
    this.setState({ stage })
    this.props.changeStage(stage)
  }

  passwordChange = (e) => this.setState({ password: e.target.value })
  idNumberChange = (e) => this.setState({ idNumber: e.target.value })

  handleLogin() {
    this.props.setFirstTime(true)
    const { password, idNumber } = this.state;
    this.setState({ modalShow: true })
    const url = 'https://covider.herokuapp.com/api/account';
    const auth = "Basic " + new Buffer(idNumber + ":" + password).toString("base64");
    console.log(auth);
    this.props.setToken(auth)

    const fetchParams = {
      method: 'GET',
      headers: {
        Authorization: auth,
        'Content-Type': 'application/json'
      },
      // body: JSON.stringify(obj)
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

        if (statusCode === 200) {
          console.log(responseJson)

          this.setState({
            modalShow: false,
            user: responseJson,
            stage: 2,
          })

        } else if (statusCode === 401) {
          console.log(responseJson)
          this.setState({ modalShow: false })
          // this.setState({ stage: 2 })
        } else {
          console.log(responseJson)
          this.setState({ modalShow: false })
        }


      })
      .catch(err => {
        console.log(err)
      }).finally(() => console.log('finish'))

  }
  changeRoute(route) {
    this.props.changeRoute(route)
  }

  render() {
    const { stage, modalShow, user } = this.state;

    if (stage === 1) {
      return (
        <RenderLoginPage
          changeRoute={(route) => this.changeRoute(route)}
          handleLogin={() => this.handleLogin()}
          passwordChange={(e) => this.passwordChange(e)}
          idNumberChange={(e) => this.idNumberChange(e)}
          modalShow={modalShow}
          onHide={() => this.setState({ modalShow: false })}
        />
      )
    } else if (stage === 2) {
      return (
        <MedicalHistoryInfo
          user={user}
          changeStage={(stage) => this.changeStage(stage)}
        />
      )
    } else {
      return (
        <UserLocation
          user={user}
          changeStage={(stage) => this.changeStage(stage)}
          changeRoute={() => this.changeRoute('main')}
        />
      )
    }
  }
}

const mapStateToProps = ({ token }) => {

  return {}
}

export default connect(mapStateToProps, { setToken })(Login);


const RenderLoginPage = (props) => {
  const { changeRoute, handleLogin, modalShow, onHide, passwordChange, idNumberChange } = props;

  return (
    <div className="wrapper shadow ct">
      <div className="card-body">
        <p onClick={() => changeRoute('home')} className='f5 link dim black underline pointer'>Back</p>
        <div className="d-flex justify-content-between">
          <div className="p-2" style={{ marginLeft: "-10px" }}>
            <h4>Login</h4>
          </div>
          <div className="p-2">
            <a href="/help" style={{ color: "#B8C5D9" }}>Having trouble? <strong className="helpColor" >Get Help</strong></a>
          </div>
        </div>

        <div style={{ marginTop: "2rem" }}>
          <p style={{ fontSize: "1.2rem" }}>Welcome back, login to continue</p>
          {/* <p style={{ fontSize: ".8rem;" }}>Lorem ipsum dolor sit amet et delectus accommodare his consul copiosae</p> */}
        </div>
        <LoginSuccesModal
          show={modalShow}
          onHide={() => onHide()}
        />

        <div style={{ width: "40%" }}>
          <Form>
            <Form.Group controlId="formBasicEmail">
              <Form.Label>Id card number / Email</Form.Label>
              <Form.Control type="email" placeholder="Id card number / Email" onChange={idNumberChange} />
            </Form.Group>

            <Form.Group controlId="formBasicPassword">
              <Form.Label>Password</Form.Label>
              <Form.Control type="password" placeholder="Password" onChange={passwordChange} />
            </Form.Group>
            <Button onClick={() => handleLogin()} className="grow" variant="primary" style={{ backgroundColor: '#6e13ec', borderWidth: 0 }}>
              Login
            </Button>

          </Form>
        </div>
      </div>
    </div>
  )
}
