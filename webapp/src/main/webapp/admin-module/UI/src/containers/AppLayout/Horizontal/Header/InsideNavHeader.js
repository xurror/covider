<<<<<<< HEAD
import React, {useState} from "react";
import {Link, withRouter} from "react-router-dom";
import {useDispatch, useSelector} from "react-redux";
import AppBar from "@material-ui/core/AppBar";
import Avatar from "@material-ui/core/Avatar";
import Toolbar from "@material-ui/core/Toolbar";
import IconButton from "@material-ui/core/IconButton";
import {Dropdown, DropdownMenu, DropdownToggle} from "reactstrap";
import SearchBox from "components/SearchBox";
import CardHeader from "components/dashboard/Common/CardHeader/index";
import IntlMessages from "util/IntlMessages";
import LanguageSwitcher from "components/LanguageSwitcher/index";
import Menu from "./TopNav/Menu";
import UserInfoPopup from "components/UserInfo/UserInfoPopup";
import { switchLanguage, toggleCollapsedNav } from "actions/Setting";


const InsideNavHeader = (props) => {

  const {locale} = useSelector(({settings}) => settings);
  const dispatch = useDispatch();
  const [searchBox, setSearchBox] = useState(undefined);
  const [searchText, setSearchText] = useState('');
  const [mailNotification, setMailNotification] = useState(false);
  const [userInfo, setUserInfo] = useState(false);
  const [langSwitcher, setLangSwitcher] = useState(false);
  const [appNotification, setAppNotification] = useState(false);
  const [apps, setApps] = useState(false);


  const onAppNotificationSelect = () => {
    setAppNotification(!appNotification);
  };
  const onMailNotificationSelect = () => {
    setMailNotification(!mailNotification)
  };
  const onLangSwitcherSelect = (event) => {
    setLangSwitcher(!langSwitcher);
  };
  const onSearchBoxSelect = () => {
    setSearchBox(!setSearchBox)
  };
  const onAppsSelect = () => {
    setApps(!apps);
  };
  const onUserInfoSelect = () => {
    setUserInfo(!userInfo);
  };
  const handleRequestClose = () => {
    setLangSwitcher(false);
    setUserInfo(false);
    setMailNotification(false);
    setAppNotification(false);
    setAppNotification(false);
    setSearchBox(false);
    setApps(false);
  };
  const onToggleCollapsedNav = (e) => {
    const val = !props.navCollapsed;
    dispatch(toggleCollapsedNav(val));
  };

  const updateSearchText = (evt) => {
    setSearchText(evt.target.value);
  };

  const onSwitchLanguage = (lang) => {
    dispatch(switchLanguage(lang))
  };

    return (
      <AppBar
        className="app-main-header">
        <Toolbar className="app-toolbar" disableGutters={false}>
            <div className="d-block d-md-none pointer mr-3" onClick={onToggleCollapsedNav}>
                <span className="jr-menu-icon">
                    <span className="menu-icon"/>
                </span>
            </div>

          <SearchBox styleName="d-none d-lg-block" placeholder=""
                     onChange={updateSearchText}
                     value={searchText}/>
          <Menu/>

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
     

            <li className="list-inline-item user-nav">
              <Dropdown
                className="quick-menu"
                isOpen={userInfo}
                toggle={onUserInfoSelect}>

                <DropdownToggle
                  className="d-inline-block"
                  tag="span"
                  data-toggle="dropdown">
                  <IconButton className="icon-btn size-30">
                    <Avatar
                      alt='...'
                      src={"https://via.placeholder.com/150x150"}
                      className="size-30"
                    />
                  </IconButton>
                </DropdownToggle>

                <DropdownMenu right>
                  <UserInfoPopup/>
                </DropdownMenu>
              </Dropdown>
            </li>
          </ul>

          <div className="ellipse-shape"/>
        </Toolbar>
      </AppBar>
    );
  };

export default withRouter(InsideNavHeader);
=======
import React, {useState} from "react";
import {Link, withRouter} from "react-router-dom";
import {useDispatch, useSelector} from "react-redux";
import AppBar from "@material-ui/core/AppBar";
import Avatar from "@material-ui/core/Avatar";
import Toolbar from "@material-ui/core/Toolbar";
import IconButton from "@material-ui/core/IconButton";
import {Dropdown, DropdownMenu, DropdownToggle} from "reactstrap";
import SearchBox from "components/SearchBox";
import CardHeader from "components/dashboard/Common/CardHeader/index";
import IntlMessages from "util/IntlMessages";
import LanguageSwitcher from "components/LanguageSwitcher/index";
import Menu from "./TopNav/Menu";
import UserInfoPopup from "components/UserInfo/UserInfoPopup";
import { switchLanguage, toggleCollapsedNav } from "actions/Setting";


const InsideNavHeader = (props) => {

  const {locale} = useSelector(({settings}) => settings);
  const dispatch = useDispatch();
  const [searchBox, setSearchBox] = useState(undefined);
  const [searchText, setSearchText] = useState('');
  const [mailNotification, setMailNotification] = useState(false);
  const [userInfo, setUserInfo] = useState(false);
  const [langSwitcher, setLangSwitcher] = useState(false);
  const [appNotification, setAppNotification] = useState(false);
  const [apps, setApps] = useState(false);


  const onAppNotificationSelect = () => {
    setAppNotification(!appNotification);
  };
  const onMailNotificationSelect = () => {
    setMailNotification(!mailNotification)
  };
  const onLangSwitcherSelect = (event) => {
    setLangSwitcher(!langSwitcher);
  };
  const onSearchBoxSelect = () => {
    setSearchBox(!setSearchBox)
  };
  const onAppsSelect = () => {
    setApps(!apps);
  };
  const onUserInfoSelect = () => {
    setUserInfo(!userInfo);
  };
  const handleRequestClose = () => {
    setLangSwitcher(false);
    setUserInfo(false);
    setMailNotification(false);
    setAppNotification(false);
    setAppNotification(false);
    setSearchBox(false);
    setApps(false);
  };
  const onToggleCollapsedNav = (e) => {
    const val = !props.navCollapsed;
    dispatch(toggleCollapsedNav(val));
  };

  const updateSearchText = (evt) => {
    setSearchText(evt.target.value);
  };

  const onSwitchLanguage = (lang) => {
    dispatch(switchLanguage(lang))
  };

    return (
      <AppBar
        className="app-main-header">
        <Toolbar className="app-toolbar" disableGutters={false}>
            <div className="d-block d-md-none pointer mr-3" onClick={onToggleCollapsedNav}>
                <span className="jr-menu-icon">
                    <span className="menu-icon"/>
                </span>
            </div>

          <SearchBox styleName="d-none d-lg-block" placeholder=""
                     onChange={updateSearchText}
                     value={searchText}/>
          <Menu/>

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
     

            <li className="list-inline-item user-nav">
              <Dropdown
                className="quick-menu"
                isOpen={userInfo}
                toggle={onUserInfoSelect}>

                <DropdownToggle
                  className="d-inline-block"
                  tag="span"
                  data-toggle="dropdown">
                  <IconButton className="icon-btn size-30">
                    <Avatar
                      alt='...'
                      src={"https://via.placeholder.com/150x150"}
                      className="size-30"
                    />
                  </IconButton>
                </DropdownToggle>

                <DropdownMenu right>
                  <UserInfoPopup/>
                </DropdownMenu>
              </Dropdown>
            </li>
          </ul>

          <div className="ellipse-shape"/>
        </Toolbar>
      </AppBar>
    );
  };

export default withRouter(InsideNavHeader);
>>>>>>> 4d2bbb9... backbone for the dashboard
