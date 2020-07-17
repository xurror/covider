import React from "react";
import {Sidebar, InputItem, DropdownItem, Icon, Item, Logo, LogoText} from 'react-sidebar-ui'
import 'react-sidebar-ui/dist/index.css';
import icon from './cov.gif'
import { NavLink } from 'react-router-dom';
import Iframe from 'react-iframe'
import "./Home.css"

class Home extends React.Component {
  render() {
    return (
        <div className='con'>
        <div className='reg'>
          <Sidebar bgColor='black' isCollapsed={false}>
            <Logo
              image={icon}
              imageName='react logo'/>
            <LogoText>COVIDER</LogoText>
            <DropdownItem
              values={['Jasper', 'Yoland', 'Christoph','Jasper', 'Yoland', 'Christoph','Jasper', 'Yoland', 'Christoph']}
              bgColor={'black'}>
              REGISTERED USERS
            </DropdownItem>
    
            <Item bgColor='black'>
              <Icon><i className="fas fa-home"/></Icon>
              NOTIFICATIONS
            </Item>
            <Item bgColor='black'>
              <Icon><i className="fas fa-info"/></Icon>
              <NavLink to="/Geolocation">Help and Assistance</NavLink>
            </Item>
            <InputItem type='text' placeholder={'Search...'}/>
          </Sidebar>
        </div>
        </div>
      )
    }
}
export default Home;