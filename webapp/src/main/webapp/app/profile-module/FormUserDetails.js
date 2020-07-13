import React, { Component } from 'react';
import MuiThemeProvider from 'material-ui/styles/MuiThemeProvider';
import AppBar from 'material-ui/AppBar';
import TextField from 'material-ui/TextField';
import RaisedButton from 'material-ui/RaisedButton';



export class FormUserDetails extends Component {

    //continue method for continue button
    continue = e => {
        e.preventDefault();
        this.props.nextStep();
    };
    //back method for back button
    back = e => {
        e.preventDefault();
        this.props.prevStep();
    };

    //method to submit form
    formSubmit(event) {
        event.preventDefault();
        console.log(this.state.selectedOption)
      }

   


    render() {
        const {values,handleChange } = this.props;

        return (

        
            <MuiThemeProvider>
                <React.Fragment>
                    <AppBar title="Insert Information"/>

                <form onSubmit={this.formSubmit} >    
                    <TextField
                    hintText="Enter your User Name"
                    floatingLabelText="Username"
                    onChange={handleChange('Username')}
                    defaultValue={values.Username}
                    />

                       <br/>

                    <TextField
                    hintText="Enter your ID CARD NUMBER"
                    floatingLabelText="Id Card Number"
                    onChange={handleChange('idcardnumber')}
                    defaultValue={values.idcardnumber}
                    />


                       <br />

                       <TextField
                    hintText="Email"
                    floatingLabelText="Email"
                    onChange={handleChange('Email')}
                    defaultValue={values.Email}
                    />

                    <br/>

                    <h2>Symptoms</h2>
                    

                    <TextField
                        hintText="Symptoms"
                        floatingLabelText=" Symptoms"
                        onChange={handleChange('Symptoms')}
                        defaultValue={values.Symptoms}       
                    />

                    <br/>

                    <TextField
                             hintText="Symptoms"
                            floatingLabelText="Symptoms"
                            onChange={handleChange('Symptoms')}
                            defaultValue={values.Symptoms}    
                    />

                    <br/>

                    <h4>LOCATION</h4>

                    <TextField
                        hintText="Present Location"
                        floatingLabelText="Present Location"
                        onChange={handleChange('Present_Location')}
                        defaultValue={values.Present_Location }       
                    />

                    <br/>

                    <TextField
                        hintText="Previous Location"
                        floatingLabelText="Previous Location"
                        onChange={handleChange('Previous_Location')}
                        defaultValue={values.Previous_Location }       
                    />
                
                        <br/>

                    <RaisedButton
                        label="Continue"
                        primary={true}
                        style={styles.button}
                        onClick={this.continue} //what does continue do? It calls nextStep
                    />

                </form>

                </React.Fragment>
            </MuiThemeProvider>
        );   
    }
}

const styles = {
    button:{
        margin:15
    }
}

export default FormUserDetails;

