import React from 'react';
import {useDispatch, useSelector} from 'react-redux';
import FormControl from '@material-ui/core/FormControl';
import FormControlLabel from '@material-ui/core/FormControlLabel';
import Radio from '@material-ui/core/Radio';
import RadioGroup from '@material-ui/core/RadioGroup';
import {
  ABOVE_THE_HEADER,
  BELOW_THE_HEADER,
  COLLAPSED_DRAWER,
  FIXED_DRAWER,
  HORIZONTAL_NAVIGATION,
  INSIDE_THE_HEADER,
  MINI_DRAWER,
  VERTICAL_NAVIGATION
} from 'constants/ActionTypes'

import {changeNavigationStyle, setDrawerType, setHorizontalMenuPosition} from '../../actions/index';

import {Button, ButtonGroup} from 'reactstrap';

const Customizer =()=> {

  const dispatch = useDispatch();

  const drawerType = useSelector(({settings}) => settings.drawerType);
  const navigationStyle = useSelector(({settings}) => settings.navigationStyle);
  const horizontalNavPosition = useSelector(({settings}) => settings.horizontalNavPosition);


 const setFixedDrawer = () => {
   dispatch(setDrawerType(FIXED_DRAWER));
  };

  const setCollapsedDrawer = () => {
    dispatch(setDrawerType(COLLAPSED_DRAWER));
  };

  const setMiniDrawer = () => {
    dispatch(setDrawerType(MINI_DRAWER));
  };


    return (
      <div className="side-nav-option">

        <div className="mb-1">
          <h3 className="mb-1 mt-4">Navigation Style</h3>
          <div className="text-left py-3">
            <FormControl className="d-block" component="fieldset" required>
              <RadioGroup className="sidenav-dir"
                          aria-label="nav-style"
                          name="navStyle"
                          value={navigationStyle}
                          onChange={(event) => {
                           dispatch(changeNavigationStyle(event.target.value))
                          }}
              >
                <FormControlLabel control={
                  <Radio/>} value={HORIZONTAL_NAVIGATION} label="Horizontal"/>
                <FormControlLabel control={
                  <Radio/>} value={VERTICAL_NAVIGATION} label="Vertical"/>

              </RadioGroup>
            </FormControl>
          </div>
        </div>
        {navigationStyle === HORIZONTAL_NAVIGATION ? <ButtonGroup>
          {console.log("navigationStyle",horizontalNavPosition)}
            <Button color="default"
                    className={`jr-btn  ${horizontalNavPosition === INSIDE_THE_HEADER && 'active' } `}
                    onClick={() => {
                      dispatch(setHorizontalMenuPosition(INSIDE_THE_HEADER))
                    }}>Inside</Button>
            <Button color="default"
                    className={`jr-btn ${horizontalNavPosition === ABOVE_THE_HEADER && 'active'} `}
                    onClick={() => {
                     dispatch(setHorizontalMenuPosition(ABOVE_THE_HEADER))
                    }}>Top</Button>
            <Button color="default"
                    className={`jr-btn ${horizontalNavPosition === BELOW_THE_HEADER && 'active' } `}
                    onClick={() => {
                      dispatch(setHorizontalMenuPosition(BELOW_THE_HEADER))
                    }}>Below</Button>
          </ButtonGroup>
          :
          <ButtonGroup>
            <Button color="default"
                    className={`jr-btn  ${drawerType === FIXED_DRAWER && 'active' } `}
                    onClick={setFixedDrawer}>Fixed</Button>
            <Button color="default"
                    className={`jr-btn ${drawerType === COLLAPSED_DRAWER && 'active'} `}
                    onClick={setCollapsedDrawer}>Collapsed</Button>
            <Button color="default"
                    className={`jr-btn ${drawerType === MINI_DRAWER && 'active' } `}
                    onClick={setMiniDrawer}>Mini</Button>
          </ButtonGroup>
        }

      </div>);
  };


export default (Customizer);

