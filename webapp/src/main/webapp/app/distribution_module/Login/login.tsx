import React, {Component} from 'react'

import { faEdit, faIdCard, faTag, faUser } from "@fortawesome/free-solid-svg-icons";
import { FontAwesomeIcon } from "@fortawesome/react-fontawesome";

class login extends Component {
    render() {
        return (
            <div className="bab">
                <div className="">
                    <div className="">
                        <div className="da"></div>
                        <FontAwesomeIcon icon={faUser} className=""/>
                        <div className="title"> 
                            <h1>Login</h1>
                        </div>
                        <div className="textbox">
                        <FontAwesomeIcon icon={faEdit}/><input type="text" placeholder='enter full names' id="da"/>
                        </div>
                        <div className="textbox">
                        <FontAwesomeIcon icon={faIdCard}/> <input type="password" placeholder="ID Card number" id=""/>
                        </div>
                        <div className="textbox">
                        <FontAwesomeIcon icon={faTag}/><input type="password" placeholder=" Agent Token" id=""/>
                        </div>
                        <button className="" type="submit">
                            Confirmation</button>

                    </div>
                </div>
            </div>
        )
    }
}

export default login;
