import React from "react";
import PropTypes from "prop-types";

export default class Form extends React.Component {

state = {
     firstPlace : "",
     secondPlace : "",
     thirdPlace : ""
};

  changes = e => {
      this.setState({
[e.target.name] : e.target.value
      });
  }

  state = { acceptedAgreement: false };

  handleAcceptAgreementChange = (e) => {
  const acceptedAgreement = e.target.checked;
  this.setState({ acceptedAgreement });
  
  };

  onSubmit = e => {
    e.preventDefault();
    this.props.onSubmit(this.state);
    this.setState({
       
        firstPlace : "",
        secondPlace : "",
        thirdPlace : ""

    });
  };
  
   render() {
       return (
           <form>
              <h1>Health Container</h1>

              <h2>3 places you lastly visited</h2>

              <input 
               name = "firstPlace"
               placeholder = "Country, Region, City"
               value = {this.state.firstPlace}
               onChange = {e => this.changes(e)}
               />
                
                <br />

              <input 
               name = "secondPlace"
               placeholder = "Country, Region, City"
               value = {this.state.secondPlace}
               onChange = {e => this.changes(e)}
               />

               <br />

             <input 
               name = "thirdPlace"
               placeholder = "Country, Region, City"
               value = {this.state.thirdPlace}
               onChange = {e => this.changes(e)}
               /> 
             
               <br />

               <h2>Signs and Symptoms</h2>

               <label>
               Fever
               <input
                 checked={this.state.acceptedAgreement}
                 onChange={this.handleAcceptAgreementChange}
                 type="checkbox" />
               </label>

               <br />

               <label>
               Dry Cough
               <input
                 checked={this.state.acceptedAgreement}
                 onChange={this.handleAcceptAgreementChange}
                 type="checkbox" />
               </label>

               <br />

               <label>
               Coughness
               <input
                 checked={this.state.acceptedAgreement}
                 onChange={this.handleAcceptAgreementChange}
                 type="checkbox" />
               </label>

               <button onClick = {e => this.onSubmit(e)}> Submit </button>

           </form>
       )
   }
}