import React from 'react';
import { FaCheckCircle } from "react-icons/fa";

import './SidebarCounter.css';

const RegisterSidebarCounter = (props) => {
  return (
    <div>
      {props.stage === 2 && props.role === 'agent' ?
        <div>
          <div style={{ textAlign: 'center', display: 'flex', justifyContent: 'center', alignItems: 'center', }}>
            <div style={{ marginTop: "1rem", marginRight: "2rem", marginBottom: "1rem" }}>
              <h3 className="icons" style={{ color: "white" }}><FaCheckCircle fontSize='2.7rem' /></h3>
            </div>
            <h5 style={{ color: 'white', flex: .8 }}>User role</h5>
          </div>

          <div style={{ textAlign: 'center', display: 'flex', justifyContent: 'center', alignItems: 'center', }}>
            <div className="iconStyles">
              <h3 className="icons" style={{ color: "white", fontSize: "2rem" }}>2</h3>
            </div>
            <h5 style={{ color: 'white', flex: .8 }}>Agents information</h5>
          </div>
        </div>
        : null}

      {props.stage === 2 && props.role === 'user' ?
        <div>
          <div style={{ textAlign: 'center', display: 'flex', justifyContent: 'center', alignItems: 'center', }}>
            <div style={{ marginTop: "1rem", marginRight: "2rem", marginBottom: "1rem" }}>
              <h3 className="icons" style={{ color: "white" }}><FaCheckCircle fontSize='2.7rem' /></h3>
            </div>
            <h5 style={{ color: 'white', flex: .8 }}>User role</h5>
          </div>

          <div style={{ textAlign: 'center', display: 'flex', justifyContent: 'center', alignItems: 'center', }}>
            <div className="iconStyles">
              <h3 className="icons" style={{ color: "white", fontSize: "2rem" }}>2</h3>
            </div>
            <h5 style={{ color: 'white', flex: .8 }}>User information</h5>
          </div>
        </div>
        : null}


    </div>
  )
}

export default RegisterSidebarCounter;