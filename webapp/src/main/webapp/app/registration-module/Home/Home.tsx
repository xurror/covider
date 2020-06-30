import React, { Component } from 'react';
import './Home.css';
import { Card } from 'react-bootstrap';
import Register from '../registration/Register';
import Login from '../login/Login';
import RegisterSidebarCounter from '../component/RegisterSidebarCounter/RegisterSidebarCounter';
import LoginSidebarCounter from '../component/LoginSidebarCounter/LoginSidebarCounter';

class Home extends Component {
  constructor() {
    super();
    this.state = {
      route: 'home',
      stage: 1,
      role: 'agent',
      isfirstTime: false,
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
        <Login
          changeRoute={(route) => this.setState({route})}
          changeStage={(stage) => this.setState({ stage })}
          setFirstTime={(isfirstTime) => this.setState({ isfirstTime })}
        />
      )
    }
  }

  renderSideBar() {
    const { stage, role, route, isfirstTime } = this.state;
    console.log(isfirstTime)
    if (stage === 1 && route === 'home') {
      return (
        <div>
          <Card.Subtitle>
            <h6 className="mb-2 text-center" style={{ marginTop: "4rem", color: "antiquewhite" }}>
              A few clicks away from becoming a member</h6>
          </Card.Subtitle>
          <Card.Text className="text-center" style={{ marginTop: "2rem", fontSize: ".8rem", color: "antiquewhite" }}>
            fill in every information. to make things go faster
                  </Card.Text>
          <div className="button" onClick={() => this.setState({ route: 'login' })} >
            <p className='link dim underline pointer'
              style={{ color: "#faebd7", textDecoration: "underline" }}>Do you Have an Account ? <strong> Login</strong></p>
          </div>
        </div>
      )
    } else if (route !== 'home') {
      return <LoginSidebarCounter stage={stage} isfirstTime={isfirstTime} />
    } else {
      return (
        <RegisterSidebarCounter stage={stage} role={role} route={route} />
      )
    }
  }

  render() {
    return (
      <div className="app">

        <Card>
          <div className="cardstyle shadow ct">
            <Card.Body>
              <div>
                <h4 className="text-center" style={{ marginTop: ".5rem", color: 'antiquewhite', fontSize: "2rem" }}>Covider</h4>
              </div>

              <div>
                {this.renderSideBar()}
              </div>

            </Card.Body>
          </div>
        </Card>
        {this.renderElement()}

      </div>
    );
  }
}

export default Home;
