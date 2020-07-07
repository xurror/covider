<<<<<<< HEAD
<<<<<<< HEAD
import React from 'react';
import {withRouter} from 'react-router-dom';
import Menu from './Menu';

const TopNav =(props)=> {

    return (
      <div className={`app-top-nav d-none d-md-block ${props.styleName}`}>
        <div className="d-flex app-toolbar align-items-center">
          <Menu/>
        </div>
      </div>
    );
  }

export default withRouter(TopNav);

TopNav.defaultProps = {
  styleName: ''
};
=======
=======
>>>>>>> 4d2bbb99f7304fe93e114a6909260496de0e6fc0
import React from 'react';
import {withRouter} from 'react-router-dom';
import Menu from './Menu';

const TopNav =(props)=> {

    return (
      <div className={`app-top-nav d-none d-md-block ${props.styleName}`}>
        <div className="d-flex app-toolbar align-items-center">
          <Menu/>
        </div>
      </div>
    );
  }

export default withRouter(TopNav);

TopNav.defaultProps = {
  styleName: ''
};
<<<<<<< HEAD
>>>>>>> 4d2bbb9... backbone for the dashboard
=======
>>>>>>> 4d2bbb99f7304fe93e114a6909260496de0e6fc0
