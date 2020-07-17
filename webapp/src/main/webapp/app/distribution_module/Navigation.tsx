import React from 'react'; 
import  './Navigation.css'
import { NavLink } from 'react-router-dom';
 
const Navigation = () => {
    return (
       <div>
          <NavLink  to="/"></NavLink>
          <NavLink to="/Home">Home</NavLink>
          <NavLink  to="/Geolocation">Geolocation</NavLink>
       </div>
    );
}
 
export default Navigation;