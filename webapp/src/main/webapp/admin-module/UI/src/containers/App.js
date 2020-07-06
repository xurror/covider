import React, {useEffect} from "react";
import { createMuiTheme } from "@material-ui/core/styles";
import { ThemeProvider } from "@material-ui/styles";
import URLSearchParams from "url-search-params";
import MomentUtils from "@date-io/moment";
import { MuiPickersUtilsProvider} from '@material-ui/pickers';
import { Redirect, Route, Switch } from "react-router-dom";
import {useDispatch, useSelector} from "react-redux";
import { IntlProvider } from "react-intl";
import "assets/vendors/style";
import indigoTheme from "./themes/indigoTheme";
import cyanTheme from "./themes/cyanTheme";
import orangeTheme from "./themes/orangeTheme";
import amberTheme from "./themes/amberTheme";
import pinkTheme from "./themes/pinkTheme";
import blueTheme from "./themes/blueTheme";
import purpleTheme from "./themes/purpleTheme";
import greenTheme from "./themes/greenTheme";
import AppLocale from "../lngProvider";

import {
  AMBER,
  BLUE,
  CYAN,
  DARK_AMBER,
  DARK_BLUE,
  DARK_CYAN,
  DARK_DEEP_ORANGE,
  DARK_DEEP_PURPLE,
  DARK_GREEN,
  DARK_INDIGO,
  DARK_PINK,
  DEEP_ORANGE,
  DEEP_PURPLE,
  GREEN,
  INDIGO,
  PINK
} from "constants/ThemeColors";
import SignIn from "./SignIn";
import SignUp from "./SignUp";
import { setInitUrl } from "../actions/Auth";
import RTL from "util/RTL";
import asyncComponent from "util/asyncComponent";
import { setDarkTheme, setThemeColor } from "../actions/Setting";
import AppLayout from "./AppLayout";

const RestrictedRoute = ({component: Component, authUser, ...rest}) =>
  <Route
    {...rest}
    render={props =>
      authUser
        ? <Component {...props} />
        : <Redirect
          to={{
            pathname: '/signin',
            state: {from: props.location}
          }}
        />}
  />;

const App = (props) => {
  const dispatch = useDispatch();
  const {themeColor, darkTheme, locale, isDirectionRTL} = useSelector(({settings}) => settings);
  const {authUser, initURL} = useSelector(({auth}) => auth);
  const isDarkTheme = darkTheme;
  const {match, location} = props;

  useEffect(() => {
    window.__MUI_USE_NEXT_TYPOGRAPHY_VARIANTS__ = true;
    if (initURL === '') {
      dispatch(setInitUrl(props.history.location.pathname));
    }
    const params = new URLSearchParams(props.location.search);
    if (params.has("theme-name")) {
      dispatch(setThemeColor(params.get('theme-name')));
    }
    if (params.has("dark-theme")) {
      dispatch(setDarkTheme());
    }
  }, [dispatch, initURL, props.history.location.pathname, props.location.search]);


  const getColorTheme = (themeColor, applyTheme) => {
    switch (themeColor) {
      case INDIGO: {
        applyTheme = createMuiTheme(indigoTheme);
        break;
      }
      case CYAN: {
        applyTheme = createMuiTheme(cyanTheme);
        break;
      }
      case AMBER: {
        applyTheme = createMuiTheme(amberTheme);
        break;
      }
      case DEEP_ORANGE: {
        applyTheme = createMuiTheme(orangeTheme);
        break;
      }
      case PINK: {
        applyTheme = createMuiTheme(pinkTheme);
        break;
      }
      case BLUE: {
        applyTheme = createMuiTheme(blueTheme);
        break;
      }
      case DEEP_PURPLE: {
        applyTheme = createMuiTheme(purpleTheme);
        break;
      }
      case GREEN: {
        applyTheme = createMuiTheme(greenTheme);
        break;
      }
      case DARK_INDIGO: {
        applyTheme = createMuiTheme({...indigoTheme, direction: 'rtl'});
        break;
      }
      case DARK_CYAN: {
        applyTheme = createMuiTheme(cyanTheme);
        break;
      }
      case DARK_AMBER: {
        applyTheme = createMuiTheme(amberTheme);
        break;
      }
      case DARK_DEEP_ORANGE: {
        applyTheme = createMuiTheme(orangeTheme);
        break;
      }
      case DARK_PINK: {
        applyTheme = createMuiTheme(pinkTheme);
        break;
      }
      case DARK_BLUE: {
        applyTheme = createMuiTheme(blueTheme);
        break;
      }
      case DARK_DEEP_PURPLE: {
        applyTheme = createMuiTheme(purpleTheme);
        break;
      }
      case DARK_GREEN: {
        applyTheme = createMuiTheme(greenTheme);
        break;
      }
      default : createMuiTheme(indigoTheme);
    }
    return applyTheme;
  };

  let applyTheme = createMuiTheme(indigoTheme);
  if (isDarkTheme) {
    document.body.classList.add('dark-theme');
    applyTheme = createMuiTheme(darkTheme)
  } else {
    applyTheme = getColorTheme(themeColor, applyTheme);
  }
  if (location.pathname === '/') {
    if (authUser === null) {
      return ( <Redirect to={'/signin'}/> );
    } else if (initURL === '' || initURL === '/' || initURL === '/signin') {
      return ( <Redirect to={'/app/dashboard/crypto'}/> );
    } else {
      return ( <Redirect to={initURL}/> );
    }
  }
  if (isDirectionRTL) {
    applyTheme.direction = 'rtl';
    document.body.classList.add('rtl')
  } else {
    document.body.classList.remove('rtl');
    applyTheme.direction = 'ltr';
  }

  const currentAppLocale = AppLocale[locale.locale];
  return (
    <ThemeProvider theme={applyTheme}>
      <MuiPickersUtilsProvider utils={MomentUtils}>
        <IntlProvider
          locale={currentAppLocale.locale}
          messages={currentAppLocale.messages}>
          <RTL>
            <div className="app-main">
              <Switch>
                <RestrictedRoute path={`${match.url}app`} authUser={authUser}
                                 component={AppLayout}/>
                <Route path='/signin' component={SignIn}/>
                <Route path='/signup' component={SignUp}/>

              </Switch>
            </div>
          </RTL>
        </IntlProvider>
      </MuiPickersUtilsProvider>
    </ThemeProvider>
  );
};

export default App;
