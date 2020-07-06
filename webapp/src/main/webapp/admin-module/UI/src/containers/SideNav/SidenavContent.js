import React, {Component} from 'react';
import {NavLink, withRouter} from 'react-router-dom';
import Button from '@material-ui/core/Button';
import IntlMessages from 'util/IntlMessages';
import CustomScrollbars from 'util/CustomScrollbars';


class SidenavContent extends Component {
  componentDidMount() {
    const {history} = this.props;
    const that = this;
    const pathname = `${history.location.pathname}`;// get current path

    const menuLi = document.getElementsByClassName('menu');
    for (let i = 0; i < menuLi.length; i++) {
      menuLi[i].onclick = function (event) {

        const parentLiEle = that.closest(this, 'li');
        if(menuLi[i].classList.contains('menu') && parentLiEle !== null) {
          event.stopPropagation();

          if(menuLi[i].classList.contains('open')) {
            menuLi[i].classList.remove('open', 'active');
          } else {
            menuLi[i].classList.add('open', 'active');
          }
        } else {
          for (let j = 0; j < menuLi.length; j++) {
            const parentLi = that.closest(this, 'li');
            if (menuLi[j] !== this && (parentLi === null || !parentLi.classList.contains('open'))) {
              menuLi[j].classList.remove('open');
            } else {
              if(menuLi[j].classList.contains('open')) {
                menuLi[j].classList.remove('open');
              } else {
                menuLi[j].classList.add('open');
              }
            }
          }
        }
      }
    }

    const activeLi = document.querySelector('a[href="' + pathname + '"]');// select current a element
    try {
      const activeNav = this.closest(activeLi, 'ul'); // select closest ul
      if (activeNav.classList.contains('sub-menu')) {
        this.closest(activeNav, 'li').classList.add('open');
      } else {
        this.closest(activeLi, 'li').classList.add('open');
      }
    } catch (error) {

    }
  }

  componentWillReceiveProps(nextProps) {
    const {history} = nextProps;
    const pathname = `${history.location.pathname}`;// get current path

    const activeLi = document.querySelector('a[href="' + pathname + '"]');// select current a element
    try {
      const activeNav = this.closest(activeLi, 'ul'); // select closest ul
      if (activeNav.classList.contains('sub-menu')) {
        this.closest(activeNav, 'li').classList.add('open');
      } else {
        this.closest(activeLi, 'li').classList.add('open');
      }
    } catch (error) {

    }
  }

  closest(el, selector) {
    try {
      let matchesFn;
      // find vendor prefix
      ['matches', 'webkitMatchesSelector', 'mozMatchesSelector', 'msMatchesSelector', 'oMatchesSelector'].some(function (fn) {
        if (typeof document.body[fn] === 'function') {
          matchesFn = fn;
          return true;
        }
        return false;
      });

      let parent;

      // traverse parents
      while (el) {
        parent = el.parentElement;
        if (parent && parent[matchesFn](selector)) {
          return parent;
        }
        el = parent;
      }
    } catch (e) {

    }

    return null;
  }

  render() {
    return (
      <CustomScrollbars className=" scrollbar">
        <ul className="nav-menu">

          <li className="nav-header">
            <IntlMessages id="sidebar.main"/>
          </li>

          <li className="menu collapse-box">
            <Button>
              <i className="zmdi zmdi-view-dashboard zmdi-hc-fw"/>
              <span className="nav-text">
                <IntlMessages id="sidebar.dashboard"/>
              </span>
            </Button>
            <ul className="sub-menu">

              <li>
                <NavLink className="prepend-icon" to="/app/dashboard/listing">
                  <span className="nav-text"><IntlMessages id="sidebar.dashboard.listing"/></span>
                </NavLink>
              </li>
              <li>
                <NavLink className="prepend-icon" to="/app/dashboard/crm">
                  <span className="nav-text"><IntlMessages id="sidebar.dashboard.crm"/></span>
                </NavLink>
              </li>
              <li>
                <NavLink className="prepend-icon" to="/app/dashboard/intranet">
                  <span className="nav-text"><IntlMessages id="sidebar.dashboard.intranet"/></span>
                </NavLink>
              </li>
              <li>
                <NavLink className="prepend-icon" to="/app/dashboard/eCommerce">
                                    <span className="nav-text text-transform-none"><IntlMessages
                                      id="sidebar.dashboard.ecommerce"/></span>
                </NavLink>
              </li>
              <li>
                <NavLink className="prepend-icon" to="/app/dashboard/news">
                  <span className="nav-text"><IntlMessages id="sidebar.dashboard.news"/></span>
                </NavLink>
              </li>
              <li>
                <NavLink className="prepend-icon" to="/app/dashboard/misc">
                  <span className="nav-text"><IntlMessages id="sidebar.dashboard.misc"/></span>
                </NavLink>
              </li>
            </ul>
          </li>

    

          <li className="map_tooltip menu">
            <Button>
              <i className="zmdi zmdi-google-maps zmdi-hc-fw"/>
              <span className="nav-text"><IntlMessages id="sidebar.map"/></span>
            </Button>

            <ul className="sub-menu">
              <li>
                <NavLink className="prepend-icon" to="/app/map/simple">
                  <span className="nav-text"><IntlMessages id="sidebar.map.simple"/></span>
                </NavLink>
              </li>
              <li>
                <NavLink className="prepend-icon" to="/app/map/styled">
                  <span className="nav-text"><IntlMessages id="sidebar.map.styled"/></span>
                </NavLink>
              </li>
              <li>
                <NavLink className="prepend-icon" to="/app/map/geo-location">
                  <span className="nav-text"><IntlMessages id="sidebar.map.geoLocation"/></span>
                </NavLink>
              </li>
              <li>
                <NavLink className="prepend-icon" to="/app/map/directions">
                  <span className="nav-text"><IntlMessages id="sidebar.map.mapDirection"/></span>
                </NavLink>
              </li>
              <li>
                <NavLink className="prepend-icon" to="/app/map/overlay">
                  <span className="nav-text"><IntlMessages id="sidebar.map.overlay"/></span>
                </NavLink>
              </li>
              <li>
                <NavLink className="prepend-icon" to="/app/map/kml">
                  <span className="nav-text"><IntlMessages id="sidebar.map.kmLayer"/></span>
                </NavLink>
              </li>
              <li>
                <NavLink className="prepend-icon" to="/app/map/popup-info">
                  <span className="nav-text"><IntlMessages id="sidebar.map.popupInfo"/></span>
                </NavLink>
              </li>
              <li>
                <NavLink className="prepend-icon" to="/app/map/traffic">
                  <span className="nav-text"><IntlMessages id="sidebar.map.trafficLayer"/></span>
                </NavLink>
              </li>
              <li>
                <NavLink className="prepend-icon" to="/app/map/street-view">
                  <span className="nav-text"><IntlMessages id="sidebar.map.streetView"/></span>
                </NavLink>
              </li>
              <li>
                <NavLink className="prepend-icon" to="/app/map/event">
                  <span className="nav-text"><IntlMessages id="sidebar.map.eventListener"/></span>
                </NavLink>
              </li>
              <li>
                <NavLink className="prepend-icon" to="/app/map/drawing">
                  <span className="nav-text"><IntlMessages id="sidebar.map.mapDrawing"/></span>
                </NavLink>
              </li>
              <li>
                <NavLink className="prepend-icon" to="/app/map/clustering">
                  <span className="nav-text"><IntlMessages id="sidebar.map.mapClustering"/></span>
                </NavLink>
              </li>
            </ul>
          </li>

          <li className="nav-header">
            <IntlMessages id="sidebar.modules"/>
          </li>

          <li className="menu">
            <Button className="void">
              <i className="zmdi zmdi-calendar zmdi-hc-fw"/>
              <span className="nav-text"><IntlMessages id="sidebar.calendar"/></span>
            </Button>

            <ul className="sub-menu">
              <li>
                <NavLink className="prepend-icon" to="/app/calendar/basic">
                  <span className="nav-text"><IntlMessages id="sidebar.calendar.basic"/></span>
                </NavLink>
              </li>
              <li>
                <NavLink className="prepend-icon" to="/app/calendar/cultures">
                  <span className="nav-text"><IntlMessages id="sidebar.calendar.cultures"/></span>
                </NavLink>
              </li>

              <li>
                <NavLink className="prepend-icon" to="/app/calendar/popup">
                  <span className="nav-text"><IntlMessages id="sidebar.calendar.popup"/></span>
                </NavLink>
              </li>
              <li>
                <NavLink className="prepend-icon" to="/app/calendar/rendering">
                  <span className="nav-text"><IntlMessages id="sidebar.calendar.rendering"/></span>
                </NavLink>
              </li>
              <li>
                <NavLink className="prepend-icon"
                         to="/app/calendar/selectable">
                  <span className="nav-text"><IntlMessages id="sidebar.calendar.selectable"/></span>
                </NavLink>
              </li>
              <li>
                <NavLink className="prepend-icon" to="/app/calendar/timeslots">
                  <span className="nav-text"><IntlMessages id="sidebar.calendar.timeslots"/></span>
                </NavLink>
              </li>
            </ul>

          </li>

        </ul>
      </CustomScrollbars>
    );
  }
}

export default withRouter(SidenavContent);
