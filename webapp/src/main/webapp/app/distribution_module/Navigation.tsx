import React from 'react'; 
import  './Navigation.css'
import { NavLink } from 'react-router-dom';
 
const Navigation = () => {
    return (
       <nav className='navbar'>
       <div className='navbar__title'>
          <NavLink className='navbar__item' to="/"></NavLink>
          <NavLink className='navbar__item' to="/Home">Home</NavLink>
          <NavLink  className='navbar__item' to="/Geolocation">Geolocation</NavLink>
       </div>
       </nav>
    );
}
 
export default Navigation;