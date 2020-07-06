<<<<<<< HEAD
import React, {useState} from "react";
import { Link, withRouter } from "react-router-dom";
import {useDispatch, useSelector} from "react-redux";
import AppBar from "@material-ui/core/AppBar";
import Toolbar from "@material-ui/core/Toolbar";
import IconButton from "@material-ui/core/IconButton";
import { Dropdown, DropdownMenu, DropdownToggle } from "reactstrap";
import { COLLAPSED_DRAWER, FIXED_DRAWER } from "constants/ActionTypes";
import SearchBox from "components/SearchBox";

import CardHeader from "components/dashboard/Common/CardHeader/index";
import { switchLanguage, toggleCollapsedNav } from "actions/Setting";
import IntlMessages from "util/IntlMessages";
import LanguageSwitcher from "components/LanguageSwitcher/index";

const Index =(props)=> {

  const dispatch = useDispatch();
  const { drawerType, locale } = useSelector(({settings}) => settings);
  const [langSwitcher,setLangSwitcher]=useState(false);
  const [mailNotification,setMailNotification]=useState(false);
  const [appNotification,setAppNotification]=useState(false);
  const [searchBox,setSearchBox]=useState(false);
  const [apps,setApps]=useState(false);
  const [userInfo,setUserInfo]=useState(false);
  const [searchText,setSearchText]=useState('');
  const [anchorEl,setAnchorEl]=useState(undefined);

  const onAppNotificationSelect = () => {
    setAppNotification(!appNotification)
  };

  const onMailNotificationSelect = () => {
    setMailNotification(!mailNotification)
  };
  const onLangSwitcherSelect = (event) => {
    setLangSwitcher(!langSwitcher);
    setAnchorEl(event.target.value);
  };

  const onSearchBoxSelect = () => {
    setSearchBox(!searchBox)
  };
  const onAppsSelect = () => {
    setApps(!apps)
  };
  const onUserInfoSelect = () => {
    setUserInfo(!userInfo);
  };

  const handleRequestClose = () => {
    setSearchBox(false);
    setLangSwitcher(false);
    setUserInfo(false);
    setMailNotification(false);
    setSearchBox(false);
    setApps(false);
  };

  const onToggleCollapsedNav = (e) => {
    const val = !props.navCollapsed;
    dispatch(toggleCollapsedNav(val));
  };


  const Apps = () => {
    return (
      <ul className="jr-list jr-list-half">
        <li className="jr-list-item">
          <Link className="jr-list-link" to="/app/calendar/basic">
            <i className="zmdi zmdi-calendar zmdi-hc-fw"/>
            <span className="jr-list-text"><IntlMessages id="sidebar.calendar.basic"/></span>
          </Link>
        </li>

        <li className="jr-list-item">
          <Link className="jr-list-link" to="/app/to-do">
            <i className="zmdi zmdi-check-square zmdi-hc-fw"/>
            <span className="jr-list-text"><IntlMessages id="sidebar.appModule.toDo"/></span>
          </Link>
        </li>


        <li className="jr-list-item">
          <Link className="jr-list-link" to="/app/chat">
            <i className="zmdi zmdi-comment zmdi-hc-fw"/>
            <span className="jr-list-text"><IntlMessages id="sidebar.appModule.chat"/></span>
          </Link>
        </li>

        <li className="jr-list-item">
          <Link className="jr-list-link" to="/app/contact">
            <i className="zmdi zmdi-account-box zmdi-hc-fw"/>
            <span className="jr-list-text"><IntlMessages id="sidebar.appModule.contact"/></span>
          </Link>
        </li>

        <li className="jr-list-item">
          <Link className="jr-list-link" to="/">
            <i className="zmdi zmdi-plus-circle-o zmdi-hc-fw"/>
            <span className="jr-list-text">Add New</span>
          </Link>
        </li>
      </ul>);
  };


  const updateSearchText =(evt)=> {
    setSearchText(evt.target.value);
  };

  const onSwitchLanguage = (lang) => {
    dispatch(switchLanguage(lang))
  };

    const drawerStyle = drawerType.includes(FIXED_DRAWER) ? "d-block d-xl-none" : drawerType.includes(COLLAPSED_DRAWER) ? "d-block" : "d-none";

    return (
      <AppBar className="app-main-header">
        <Toolbar className="app-toolbar" disableGutters={false}>

          <IconButton className={`jr-menu-icon mr-3 ${drawerStyle}`} aria-label="Menu"
                      onClick={onToggleCollapsedNav}>
            <span className="menu-icon"/>
          </IconButton>

          <SearchBox styleName="d-none d-lg-block" placeholder=""
                     onChange={updateSearchText}
                     value={searchText}/>

          <ul className="header-notifications list-inline ml-auto">
            <li className="d-inline-block d-lg-none list-inline-item">
              <Dropdown
                className="quick-menu nav-searchbox"
                isOpen={searchBox}
                toggle={onSearchBoxSelect}>

                <DropdownToggle
                  className="d-inline-block"
                  tag="span"
                  data-toggle="dropdown">
                  <IconButton className="icon-btn">
                    <i className="zmdi zmdi-search zmdi-hc-fw"/>
                  </IconButton>
                </DropdownToggle>

                <DropdownMenu right className="p-0">
                  <SearchBox styleName="search-dropdown" placeholder=""
                             onChange={updateSearchText}
                             value={searchText}/>
                </DropdownMenu>
              </Dropdown>
            </li>
            <li className="list-inline-item">
              <Dropdown
                className="quick-menu"
                isOpen={langSwitcher}
                toggle={onLangSwitcherSelect}>

                <DropdownToggle
                  className="d-inline-block"
                  tag="span"
                  data-toggle="dropdown">
                  <IconButton className="icon-btn">
                    <i className={`flag flag-24 flag-${locale.icon}`}/>
                  </IconButton>
                </DropdownToggle>

                <DropdownMenu right className="w-50">
                  <LanguageSwitcher switchLanguage={onSwitchLanguage}
                                    handleRequestClose={handleRequestClose}/>
                </DropdownMenu>
              </Dropdown>


            </li>

          </ul>

          <div className="ellipse-shape"/>
        </Toolbar>
      </AppBar>
    );
  };


export default withRouter(Index);
=======
import React, {useState} from "react";
import { Link, withRouter } from "react-router-dom";
import {useDispatch, useSelector} from "react-redux";
import AppBar from "@material-ui/core/AppBar";
import Toolbar from "@material-ui/core/Toolbar";
import IconButton from "@material-ui/core/IconButton";
import { Dropdown, DropdownMenu, DropdownToggle } from "reactstrap";
import { COLLAPSED_DRAWER, FIXED_DRAWER } from "constants/ActionTypes";
import SearchBox from "components/SearchBox";

import CardHeader from "components/dashboard/Common/CardHeader/index";
import { switchLanguage, toggleCollapsedNav } from "actions/Setting";
import IntlMessages from "util/IntlMessages";
import LanguageSwitcher from "components/LanguageSwitcher/index";

const Index =(props)=> {

  const dispatch = useDispatch();
  const { drawerType, locale } = useSelector(({settings}) => settings);
  const [langSwitcher,setLangSwitcher]=useState(false);
  const [mailNotification,setMailNotification]=useState(false);
  const [appNotification,setAppNotification]=useState(false);
  const [searchBox,setSearchBox]=useState(false);
  const [apps,setApps]=useState(false);
  const [userInfo,setUserInfo]=useState(false);
  const [searchText,setSearchText]=useState('');
  const [anchorEl,setAnchorEl]=useState(undefined);

  const onAppNotificationSelect = () => {
    setAppNotification(!appNotification)
  };

  const onMailNotificationSelect = () => {
    setMailNotification(!mailNotification)
  };
  const onLangSwitcherSelect = (event) => {
    setLangSwitcher(!langSwitcher);
    setAnchorEl(event.target.value);
  };

  const onSearchBoxSelect = () => {
    setSearchBox(!searchBox)
  };
  const onAppsSelect = () => {
    setApps(!apps)
  };
  const onUserInfoSelect = () => {
    setUserInfo(!userInfo);
  };

  const handleRequestClose = () => {
    setSearchBox(false);
    setLangSwitcher(false);
    setUserInfo(false);
    setMailNotification(false);
    setSearchBox(false);
    setApps(false);
  };

  const onToggleCollapsedNav = (e) => {
    const val = !props.navCollapsed;
    dispatch(toggleCollapsedNav(val));
  };


  const Apps = () => {
    return (
      <ul className="jr-list jr-list-half">
        <li className="jr-list-item">
          <Link className="jr-list-link" to="/app/calendar/basic">
            <i className="zmdi zmdi-calendar zmdi-hc-fw"/>
            <span className="jr-list-text"><IntlMessages id="sidebar.calendar.basic"/></span>
          </Link>
        </li>

        <li className="jr-list-item">
          <Link className="jr-list-link" to="/app/to-do">
            <i className="zmdi zmdi-check-square zmdi-hc-fw"/>
            <span className="jr-list-text"><IntlMessages id="sidebar.appModule.toDo"/></span>
          </Link>
        </li>


        <li className="jr-list-item">
          <Link className="jr-list-link" to="/app/chat">
            <i className="zmdi zmdi-comment zmdi-hc-fw"/>
            <span className="jr-list-text"><IntlMessages id="sidebar.appModule.chat"/></span>
          </Link>
        </li>

        <li className="jr-list-item">
          <Link className="jr-list-link" to="/app/contact">
            <i className="zmdi zmdi-account-box zmdi-hc-fw"/>
            <span className="jr-list-text"><IntlMessages id="sidebar.appModule.contact"/></span>
          </Link>
        </li>

        <li className="jr-list-item">
          <Link className="jr-list-link" to="/">
            <i className="zmdi zmdi-plus-circle-o zmdi-hc-fw"/>
            <span className="jr-list-text">Add New</span>
          </Link>
        </li>
      </ul>);
  };


  const updateSearchText =(evt)=> {
    setSearchText(evt.target.value);
  };

  const onSwitchLanguage = (lang) => {
    dispatch(switchLanguage(lang))
  };

    const drawerStyle = drawerType.includes(FIXED_DRAWER) ? "d-block d-xl-none" : drawerType.includes(COLLAPSED_DRAWER) ? "d-block" : "d-none";

    return (
      <AppBar className="app-main-header">
        <Toolbar className="app-toolbar" disableGutters={false}>

          <IconButton className={`jr-menu-icon mr-3 ${drawerStyle}`} aria-label="Menu"
                      onClick={onToggleCollapsedNav}>
            <span className="menu-icon"/>
          </IconButton>

          <SearchBox styleName="d-none d-lg-block" placeholder=""
                     onChange={updateSearchText}
                     value={searchText}/>

          <ul className="header-notifications list-inline ml-auto">
            <li className="d-inline-block d-lg-none list-inline-item">
              <Dropdown
                className="quick-menu nav-searchbox"
                isOpen={searchBox}
                toggle={onSearchBoxSelect}>

                <DropdownToggle
                  className="d-inline-block"
                  tag="span"
                  data-toggle="dropdown">
                  <IconButton className="icon-btn">
                    <i className="zmdi zmdi-search zmdi-hc-fw"/>
                  </IconButton>
                </DropdownToggle>

                <DropdownMenu right className="p-0">
                  <SearchBox styleName="search-dropdown" placeholder=""
                             onChange={updateSearchText}
                             value={searchText}/>
                </DropdownMenu>
              </Dropdown>
            </li>
            <li className="list-inline-item">
              <Dropdown
                className="quick-menu"
                isOpen={langSwitcher}
                toggle={onLangSwitcherSelect}>

                <DropdownToggle
                  className="d-inline-block"
                  tag="span"
                  data-toggle="dropdown">
                  <IconButton className="icon-btn">
                    <i className={`flag flag-24 flag-${locale.icon}`}/>
                  </IconButton>
                </DropdownToggle>

                <DropdownMenu right className="w-50">
                  <LanguageSwitcher switchLanguage={onSwitchLanguage}
                                    handleRequestClose={handleRequestClose}/>
                </DropdownMenu>
              </Dropdown>


            </li>

          </ul>

          <div className="ellipse-shape"/>
        </Toolbar>
      </AppBar>
    );
  };


export default withRouter(Index);
>>>>>>> 4d2bbb9... backbone for the dashboard
