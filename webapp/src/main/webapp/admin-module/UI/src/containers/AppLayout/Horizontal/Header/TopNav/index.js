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
