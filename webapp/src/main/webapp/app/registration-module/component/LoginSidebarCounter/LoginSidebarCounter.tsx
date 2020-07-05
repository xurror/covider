import React from 'react';
import { FaCheckCircle } from "react-icons/fa";
import { Card } from 'react-bootstrap';

import './SidebarCounter.css';

const LoginSidebarCounter = (props) => {
  const { isfirstTime, stage } = props;
  console.log(isfirstTime)
  return (
    <div>
      {
        !isfirstTime ?
          <div>
            <Card.Subtitle>
              <h6 className="mb-2 text-center" style={{ marginTop: "4rem", color: "antiquewhite" }}>
                Login to continue</h6>
            </Card.Subtitle>
            <Card.Text className="text-center" style={{ marginTop: "2rem", fontSize: ".8rem", color: "antiquewhite" }}>
              Do Your Free Covid Registration
            Here</Card.Text>
          </div>
          :
          <div>

            {stage === 1 ?
              <div>
                <div style={{ textAlign: 'center', display: 'flex', justifyContent: 'center', alignItems: 'center', }}>
                  <div style={{ marginTop: "1rem", marginRight: "2rem", marginBottom: "1rem" }}>
                    <h3 className="icons" style={{ color: "white", fontSize: "2rem" }}><FaCheckCircle fontSize='2.7rem' /></h3>
                  </div>
                  <h5 style={{ color: 'white', flex: .8 }}>Log in</h5>
                </div>

                <div style={{ textAlign: 'center', display: 'flex', justifyContent: 'center', alignItems: 'center', }}>
                  <div className="iconStyles">
                    <h3 className="icons" style={{ color: "white", fontSize: "2rem" }}>2</h3>
                  </div>
                  <h5 style={{ color: 'white', flex: .8 }}>Medical information</h5>
                </div>

                <div style={{ textAlign: 'center', display: 'flex', justifyContent: 'center', alignItems: 'center', }}>
                  <div className="iconStyles">
                    <h3 className="icons" style={{ color: "white", fontSize: "2rem" }}>3</h3>
                  </div>
                  <h5 style={{ color: 'white', flex: .8 }}>Locations</h5>
                </div>
              </div>
              : null}

            {stage === 2 ?
              <div>
                <div style={{ textAlign: 'center', display: 'flex', justifyContent: 'center', alignItems: 'center', }}>
                  <div style={{ marginTop: "1rem", marginRight: "2rem", marginBottom: "1rem" }}>
                    <h3 className="icons" style={{ color: "white", fontSize: "2rem" }}><FaCheckCircle fontSize='2.7rem' /></h3>
                  </div>
                  <h5 style={{ color: 'white', flex: .8 }}>Logged in</h5>
                </div>

                <div style={{ textAlign: 'center', display: 'flex', justifyContent: 'center', alignItems: 'center', }}>
                  <div className="iconStyles">
                    <h3 className="icons" style={{ color: "white", fontSize: "2rem" }}>2</h3>
                  </div>
                  <h5 style={{ color: 'white', flex: .8 }}>Medical information</h5>
                </div>

                <div style={{ textAlign: 'center', display: 'flex', justifyContent: 'center', alignItems: 'center', }}>
                  <div className="iconStyles">
                    <h3 className="icons" style={{ color: "white", fontSize: "2rem" }}>3</h3>
                  </div>
                  <h5 style={{ color: 'white', flex: .8 }}>Locations</h5>
                </div>
              </div>
              : null}
            
            {stage === 3 ?
              <div>
                <div style={{ textAlign: 'center', display: 'flex', justifyContent: 'center', alignItems: 'center', }}>
                  <div style={{ marginTop: "1rem", marginRight: "2rem", marginBottom: "1rem" }}>
                    <h3 className="icons" style={{ color: "white", fontSize: "2rem" }}><FaCheckCircle fontSize='2.7rem' /></h3>
                  </div>
                  <h5 style={{ color: 'white', flex: .8 }}>Logged in</h5>
                </div>

                <div style={{ textAlign: 'center', display: 'flex', justifyContent: 'center', alignItems: 'center', }}>
                  <div style={{ marginTop: "1rem", marginRight: "2rem", marginBottom: "1rem" }}>
                    <h3 className="icons" style={{ color: "white", fontSize: "2rem" }}><FaCheckCircle fontSize='2.7rem' /></h3>
                  </div>
                  <h5 style={{ color: 'white', flex: .8 }}>Medical information</h5>
                </div>

                <div style={{ textAlign: 'center', display: 'flex', justifyContent: 'center', alignItems: 'center', }}>
                  <div className="iconStyles">
                    <h3 className="icons" style={{ color: "white", fontSize: "2rem" }}>3</h3>
                  </div>
                  <h5 style={{ color: 'white', flex: .8 }}>Locations</h5>
                </div>
              </div>
              : null}

          </div>
      }
    </div>
  )
}

export default LoginSidebarCounter;