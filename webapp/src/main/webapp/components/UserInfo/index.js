import React, {useState} from 'react';
import Avatar from '@material-ui/core/Avatar'
import {useDispatch} from 'react-redux'
import Menu from '@material-ui/core/Menu';
import MenuItem from '@material-ui/core/MenuItem';
import {userSignOut} from 'actions/Auth';
import IntlMessages from 'util/IntlMessages';

const UserInfo = () => {

  const dispatch = useDispatch();

  const [anchorE1, setAnchorE1] = useState(null);
  const [open, setOpen] = useState(false);

  const handleClick = event => {
    setOpen(true);
    setAnchorE1(event.currentTarget);
  };

  const handleRequestClose = () => {
    setOpen(false);
  };

  return (
    <div className="user-profile d-flex flex-row align-items-center">
      <Avatar
        alt='...'
        src={"https://via.placeholder.com/150x150"}
        className="user-avatar "
      />
      <div className="user-detail">
        <h4 className="user-name" onClick={handleClick}>Robert Johnson <i
          className="zmdi zmdi-caret-down zmdi-hc-fw align-middle"/>
        </h4>
      </div>
      <Menu className="user-info"
            id="simple-menu"
            anchorEl={anchorE1}
            open={open}
            onClose={handleRequestClose}
            PaperProps={{
              style: {
                minWidth: 120,
                paddingTop: 0,
                paddingBottom: 0
              }
            }}
      >
        <MenuItem onClick={handleRequestClose}>
          <i className="zmdi zmdi-account zmdi-hc-fw mr-2"/>
          <IntlMessages id="popup.profile"/>
        </MenuItem>
        <MenuItem onClick={handleRequestClose}>
          <i className="zmdi zmdi-settings zmdi-hc-fw mr-2"/>
          <IntlMessages id="popup.setting"/>
        </MenuItem>
        <MenuItem onClick={() => {
          handleRequestClose();
          dispatch(userSignOut());
        }}>
          <i className="zmdi zmdi-sign-in zmdi-hc-fw mr-2"/>

          <IntlMessages id="popup.logout"/>
        </MenuItem>
      </Menu>
    </div>
  );
};

export default UserInfo;


