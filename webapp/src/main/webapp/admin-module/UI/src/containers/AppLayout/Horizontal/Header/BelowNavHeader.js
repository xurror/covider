<<<<<<< HEAD
<<<<<<< HEAD
import React, {useState} from "react";
import { Link, withRouter } from "react-router-dom";
import {useDispatch, useSelector} from "react-redux";
import AppBar from "@material-ui/core/AppBar";
import Avatar from "@material-ui/core/Avatar";
import Toolbar from "@material-ui/core/Toolbar";
import IconButton from "@material-ui/core/IconButton";
import { Dropdown, DropdownMenu, DropdownToggle } from "reactstrap";
import SearchBox from "components/SearchBox";
import MailNotification from "../../../../components/MailNotification";
import AppNotification from "../../../../components/AppNotification";
import CardHeader from "components/dashboard/Common/CardHeader/index";
import { switchLanguage, toggleCollapsedNav } from "actions/Setting";
import IntlMessages from "util/IntlMessages";
import LanguageSwitcher from "components/LanguageSwitcher/index";
import UserInfoPopup from "components/UserInfo/UserInfoPopup";

const Header =(props)=> {

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
          <Link className="jr-list-link" to="/app/mail">
            <i className="zmdi zmdi-email zmdi-hc-fw"/>
            <span className="jr-list-text"><IntlMessages id="sidebar.appModule.mail"/></span>
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

    return (
      <AppBar
        className='app-main-header app-main-header-top'>
        <Toolbar className="app-toolbar" disableGutters={false}>
          <div className="d-block d-md-none pointer mr-3" onClick={onToggleCollapsedNav}>
                            <span className="jr-menu-icon">
                              <span className="menu-icon"/>
                            </span>
          </div>


          <Link className="app-logo mr-2 d-none d-sm-block" to="/">
            <img src={require("assets/images/logo.png")} alt="Jambo" title="Jambo"/>
          </Link>


          <SearchBox styleName="d-none d-lg-block" placeholder=""
                     onChange={updateSearchText}
                     value={searchText}/>

          <ul className="header-notifications list-inline ml-auto">
            <li className="list-inline-item">
              <Dropdown
                className="quick-menu app-notification"
                isOpen={apps}
                toggle={onAppsSelect}>

                <DropdownToggle
                  className="d-inline-block"
                  tag="span"
                  data-toggle="dropdown">
                  <span className="app-notification-menu">
                    <i className="zmdi zmdi-apps zmdi-hc-fw zmdi-hc-lg"/>
                    <span>Apps</span>
                  </span>
                </DropdownToggle>

                <DropdownMenu>
                  {Apps()}
                </DropdownMenu>
              </Dropdown>
            </li>
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
            <li className="list-inline-item app-tour">
              <Dropdown
                className="quick-menu"
                isOpen={appNotification}
                toggle={onAppNotificationSelect}>

                <DropdownToggle
                  className="d-inline-block"
                  tag="span"
                  data-toggle="dropdown">
                  <IconButton className="icon-btn">
                    <i className="zmdi zmdi-notifications-none icon-alert animated infinite wobble"/>
                  </IconButton>
                </DropdownToggle>

                <DropdownMenu right>
                  <CardHeader styleName="align-items-center"
                              heading={<IntlMessages id="appNotification.title"/>}/>
                  <AppNotification/>
                </DropdownMenu>
              </Dropdown>
            </li>
            <li className="list-inline-item mail-tour">
              <Dropdown
                className="quick-menu"
                isOpen={mailNotification}
                toggle={onMailNotificationSelect}
              >
                <DropdownToggle
                  className="d-inline-block"
                  tag="span"
                  data-toggle="dropdown">

                  <IconButton className="icon-btn">
                    <i className="zmdi zmdi-comment-alt-text zmdi-hc-fw"/>
                  </IconButton>
                </DropdownToggle>


                <DropdownMenu right>
                  <CardHeader styleName="align-items-center"
                              heading={<IntlMessages id="mailNotification.title"/>}/>
                  <MailNotification/>
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


export default withRouter(Header);
=======
=======
>>>>>>> 4d2bbb99f7304fe93e114a6909260496de0e6fc0
import React, {useState} from "react";
import { Link, withRouter } from "react-router-dom";
import {useDispatch, useSelector} from "react-redux";
import AppBar from "@material-ui/core/AppBar";
import Avatar from "@material-ui/core/Avatar";
import Toolbar from "@material-ui/core/Toolbar";
import IconButton from "@material-ui/core/IconButton";
import { Dropdown, DropdownMenu, DropdownToggle } from "reactstrap";
import SearchBox from "components/SearchBox";
import MailNotification from "../../../../components/MailNotification";
import AppNotification from "../../../../components/AppNotification";
import CardHeader from "components/dashboard/Common/CardHeader/index";
import { switchLanguage, toggleCollapsedNav } from "actions/Setting";
import IntlMessages from "util/IntlMessages";
import LanguageSwitcher from "components/LanguageSwitcher/index";
import UserInfoPopup from "components/UserInfo/UserInfoPopup";

const Header =(props)=> {

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
          <Link className="jr-list-link" to="/app/mail">
            <i className="zmdi zmdi-email zmdi-hc-fw"/>
            <span className="jr-list-text"><IntlMessages id="sidebar.appModule.mail"/></span>
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

    return (
      <AppBar
        className='app-main-header app-main-header-top'>
        <Toolbar className="app-toolbar" disableGutters={false}>
          <div className="d-block d-md-none pointer mr-3" onClick={onToggleCollapsedNav}>
                            <span className="jr-menu-icon">
                              <span className="menu-icon"/>
                            </span>
          </div>


          <Link className="app-logo mr-2 d-none d-sm-block" to="/">
            <img src={require("assets/images/logo.png")} alt="Jambo" title="Jambo"/>
          </Link>


          <SearchBox styleName="d-none d-lg-block" placeholder=""
                     onChange={updateSearchText}
                     value={searchText}/>

          <ul className="header-notifications list-inline ml-auto">
            <li className="list-inline-item">
              <Dropdown
                className="quick-menu app-notification"
                isOpen={apps}
                toggle={onAppsSelect}>

                <DropdownToggle
                  className="d-inline-block"
                  tag="span"
                  data-toggle="dropdown">
                  <span className="app-notification-menu">
                    <i className="zmdi zmdi-apps zmdi-hc-fw zmdi-hc-lg"/>
                    <span>Apps</span>
                  </span>
                </DropdownToggle>

                <DropdownMenu>
                  {Apps()}
                </DropdownMenu>
              </Dropdown>
            </li>
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
            <li className="list-inline-item app-tour">
              <Dropdown
                className="quick-menu"
                isOpen={appNotification}
                toggle={onAppNotificationSelect}>

                <DropdownToggle
                  className="d-inline-block"
                  tag="span"
                  data-toggle="dropdown">
                  <IconButton className="icon-btn">
                    <i className="zmdi zmdi-notifications-none icon-alert animated infinite wobble"/>
                  </IconButton>
                </DropdownToggle>

                <DropdownMenu right>
                  <CardHeader styleName="align-items-center"
                              heading={<IntlMessages id="appNotification.title"/>}/>
                  <AppNotification/>
                </DropdownMenu>
              </Dropdown>
            </li>
            <li className="list-inline-item mail-tour">
              <Dropdown
                className="quick-menu"
                isOpen={mailNotification}
                toggle={onMailNotificationSelect}
              >
                <DropdownToggle
                  className="d-inline-block"
                  tag="span"
                  data-toggle="dropdown">

                  <IconButton className="icon-btn">
                    <i className="zmdi zmdi-comment-alt-text zmdi-hc-fw"/>
                  </IconButton>
                </DropdownToggle>


                <DropdownMenu right>
                  <CardHeader styleName="align-items-center"
                              heading={<IntlMessages id="mailNotification.title"/>}/>
                  <MailNotification/>
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


export default withRouter(Header);
<<<<<<< HEAD
>>>>>>> 4d2bbb9... backbone for the dashboard
=======
>>>>>>> 4d2bbb99f7304fe93e114a6909260496de0e6fc0
