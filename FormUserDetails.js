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
    }
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
                    <AppBar title="Sign In"/>

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

                    <h2>Medical Information</h2>


                    <h4> HAVE YOU BEEN TESTED FOR COVID'19?</h4>

                    <div>
                        <label>
                           <input 
                                type="radio"
                                value="TEST_YES:"
                                onChange={handleChange('TEST_YES:')}                     
                                defaultValue={values.Status_Positive }
                            />
                             YES
                         </label>   
                    </div>

                    <br />

                    <div>
                        <label>
                           <input 
                                type="radio"
                                value="TEST_NO:"
                                onChange={handleChange('TEST_NO:')}
                                defaultValue={values.TEST_NO}
                            />
                             NO
                         </label>   
                    </div>


                    <h4>WHAT IS YOUT COVID'19 STATUS?</h4>

                    <div>
                        <label>
                           <input 
                                type="radio"
                                value="Status_Positive"
                                onChange={handleChange('Status_Positive')}
                                defaultValue={values.Status_Positive }
                            />
                             POSITIVE
                         </label>   
                    </div>

                    <br />
                    <div>
                        <label>
                           <input 
                                type="radio"
                                value="Status_Negative"
                                onChange={handleChange('Status_Negative')}
                                defaultValue={values.Status_Positive }
                            />
                             NEGATIVE
                         </label>   
                    </div>

                    <TextField
                        hintText="Enter Number of Family Members"
                        floatingLabelText="Number of Family members"
                        onChange={handleChange('NumOfFamilyMembers')}
                        defaultValue={values. NumOfFamilyMembers}       
                    />

                    <br/>

                    <TextField
                          //  hintText="Members That have done COVID'19 Test"
                            floatingLabelText="Members that have done test"
                            onChange={handleChange('HowManyFamilyMembersHaveDoneTest')}
                            defaultValue={values. HowManyFamilyMembersHaveDoneTest}    
                    />

                    <br/>

                    <h4>LOCATION</h4>

                    <TextField
                        hintText="Enter Location"
                        floatingLabelText="Enter Location"
                        onChange={handleChange('Present_Location')}
                        defaultValue={values.Present_Location }       
                    />

                    <br/>

                    <TextField
                        hintText="Enter Location"
                        floatingLabelText="Enter Location"
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

