import React, {useEffect, useState} from 'react';
import {useDispatch, useSelector} from 'react-redux';
import TextField from '@material-ui/core/TextField';
import IconButton from '@material-ui/core/IconButton';
import Button from '@material-ui/core/Button';
import {NotificationContainer, NotificationManager} from 'react-notifications';
import CircularProgress from '@material-ui/core/CircularProgress';
import {Link} from 'react-router-dom';
import IntlMessages from 'util/IntlMessages';
import {
  hideMessage,
  showAuthLoader,
  userSignUp,
} from 'actions/Auth';

const SignUp = (props) => {

  const [name, setName] = useState("");
  const [email, setEmail] = useState("");
  const [password, setPassword] = useState("");

  const dispatch = useDispatch();
  const {loader, alertMessage, showMessage, authUser} = useSelector(({auth}) => auth);

  useEffect(() => {
    if (showMessage) {
      setTimeout(() => {
        dispatch(hideMessage());
      }, 3000);
    }
    if (authUser !== null) {
      props.history.push('/');
    }
  }, [showMessage, authUser, props.history, dispatch]);

  return (
    <div
      className="app-login-container d-flex justify-content-center align-items-center animated slideInUpTiny animation-duration-3">
      <div className="app-login-main-content">
        <div className="app-logo-content d-flex align-items-center justify-content-center">
          <Link className="logo-lg" to="/" title="Jambo">
            <img src={require("assets/images/logo.png")} alt="jambo" title="jambo"/>
          </Link>
        </div>

        <div className="app-login-content">
          <div className="app-login-header">
            <h1>Sign Up</h1>
          </div>

          <div className="mb-4">
            <h2><IntlMessages id="appModule.createAccount"/></h2>
          </div>

          <div className="app-login-form">
            <form method="post" action="/">
              <TextField
                type="text"
                label="Name"
                onChange={(event) => setName(event.target.value)}
                fullWidth
                defaultValue={name}
                margin="normal"
                className="mt-0 mb-2"
              />

              <TextField
                type="email"
                onChange={(event) => setEmail(event.target.value)}
                label={<IntlMessages id="appModule.email"/>}
                fullWidth
                defaultValue={email}
                margin="normal"
                className="mt-0 mb-2"
              />

              <TextField
                type="password"
                onChange={(event) => setPassword(event.target.value)}
                label={<IntlMessages id="appModule.password"/>}
                fullWidth
                defaultValue={password}
                margin="normal"
                className="mt-0 mb-4"
              />

              <div className="mb-3 d-flex align-items-center justify-content-between">
                <Button variant="contained" onClick={() => {
                  dispatch(showAuthLoader());
                  dispatch(userSignUp({email, password}));
                }} color="primary">
                  <IntlMessages
                    id="appModule.regsiter"/>
                </Button>
                <Link to="/signin">
                  <IntlMessages id="signUp.alreadyMember"/>
                </Link>
              </div>

            </form>
          </div>
        </div>

      </div>

      {
        loader &&
        <div className="loader-view">
          <CircularProgress/>
        </div>
      }
      {showMessage && NotificationManager.error(alertMessage)}
      <NotificationContainer/>
    </div>
  )
};


export default SignUp;
