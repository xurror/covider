import React from 'react';
import "./Home.css"
 
const home = () => {
    return (       
        <div className="container">
                <h1>Distribution of Commodities</h1>
                <h3>keeping every user localization during registration and make it available for
                        agents who are in charge of distributing donations.
                        On the field, agents are supposed to verify the authenticity of information
                        providing by users and after verification, they will validate user profile
                        through their interface and must signal to the system that a user has been
                        served(the system will change user state from “no served” to “served”.
                        Finally, our system will record some information like COVID 19 symptoms,
                        3 last trips and maybe other information concerning each user who has
                        been served.
                        The project scenario of the platform is better explained with its use-case:
                        The platform was created as an assistance measure for the Cameroonian
                        population who was to contain, it basically helps track the inhabitants of
                        particular areas(cities, towns and villages) place of residence as well as
                        contact or infection with COVID-19
                </h3>
            </div>
    );
}

 
export default home;