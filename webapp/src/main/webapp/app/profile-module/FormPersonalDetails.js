import React, { Component } from 'react';
import MuiThemeProvider from 'material-ui/styles/MuiThemeProvider';
import AppBar from 'material-ui/AppBar';
import TextField from 'material-ui/TextField';
import RaisedButton from 'material-ui/RaisedButton';




export class FormPersonalDetails extends Component {
    continue = e => {
        e.preventDefault();
        this.props.nextStep();
    }

    back = e => {
        e.preventDefault();
        this.props.prevStep();
    };


    render() {
        const {values,handleChange } = this.props;

        return (
            <MuiThemeProvider>
                <React.Fragment>
                    <AppBar title="Enter Personal Details"/>

                    <TextField
                    hintText="Enter your Username"
                    floatingLabelText="Username"
                    onChange={handleChange('Username')}
                    defaultValue={values.Username}
                    />

                       <br/>

                    <TextField
                    hintText="Enter your Password"
                    floatingLabelText="UserPassword"
                    onChange={handleChange('UserPassword')}
                    defaultValue={values.Userpassword}
                    />

                        <br/>

                    <TextField
                    hintText="Enter your ID CARD NUMBER"
                    floatingLabelText="Email address"
                    onChange={handleChange('idcardNumber')}
                    defaultValue={values.idcardNumber}
                    />

                    <br/>
                   

                    <RaisedButton
                        label="Continue"
                        primary={true}
                        style={styles.button}
                        onClick={this.continue} //what does continue do? It calls nextStep
                    />

                  
                    <RaisedButton
                        label="Back"
                        primary={false}
                        style={styles.button}
                        onClick={this.back} //what does continue do? It calls nextStep
                    />

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

export default FormPersonalDetails;
