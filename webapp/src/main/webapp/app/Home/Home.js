import React, { Component } from 'react';
import './Home.css';
import { Card } from 'react-bootstrap';
import Register from '../registration/Register';
import Login from '../login/Login';
import SidebarCounter from '../component/SidebarCounter/SidebarCounter';

class Home extends Component {
  constructor() {
    super();
    this.state = {
      route: 'home',
      stage: 1,
      role: 'agent'
    }
  }

  changeRoute(route) {
    this.setState({ route })
  }

  renderElement() {
    const { route } = this.state;
    if (route === 'home') {
      return (
        <Register
          changeStage={(stage) => this.setState({ stage })}
          setRole={(role) => this.setState({ role })}
        />
      )
    } else {
      return (
        <Login />
      )
    }
  }

  renderSideBar() {
    const { stage, role } = this.state;
    if (stage === 1) {
      return (
        <div>
          <Card.Subtitle>
            <h6 className="mb-2 text-center" style={{ marginTop: "4rem", color: "antiquewhite" }}>
              A few clicks away from becoming a member</h6>
          </Card.Subtitle>
          <Card.Text className="text-center" style={{ marginTop: "2rem", fontSize: ".8rem", color: "antiquewhite" }}>
            Lorem ipsum dolor sit amet et
                  delectus</Card.Text>
          <div className="button" onClick={() => this.setState({ route: 'login' })} >
            <p  className='link dim underline pointer'
            style={{ color: "#faebd7", textDecoration: "underline" }}>Have an Account ? <strong>Login</strong></p>
          </div>
        </div>
      )
    } else {
      return (
        <SidebarCounter stage={stage} role={role} />
      )
    }
  }

  render() {
    return (
      <div className="app">

        <Card>
          <div className="cardstyle shadow">
            <Card.Body>
              <div>
                <h4 className="text-center" style={{ marginTop: ".5rem", color: 'antiquewhite', fontSize: "2rem" }}>Covider</h4>
              </div>
              {
                this.state.route === 'home' ?
                  <div>
                    {this.renderSideBar()}
                  </div>
                  :
                  <div>
                    <Card.Subtitle>
                      <h6 className="mb-2 text-center" style={{ marginTop: "4rem", color: "antiquewhite" }}>
                        Login to continue</h6>
                    </Card.Subtitle>
                    <Card.Text className="text-center" style={{ marginTop: "2rem", fontSize: ".8rem", color: "antiquewhite" }}>
                      Lorem ipsum dolor sit amet et
                  delectus</Card.Text>
                  </div>
              }

            </Card.Body>
          </div>
        </Card>
        {this.renderElement()}

      </div>
    );
  }
}

export default Home;