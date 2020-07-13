import React, { Component } from 'react';
import MuiThemeProvider from 'material-ui/styles/MuiThemeProvider';
import AppBar from 'material-ui/AppBar';
import RaisedButton from 'material-ui/RaisedButton';


export class Success extends Component {

    back = e => {
        e.preventDefault();
        this.props.prevStep();
    }

    signOut = e =>{
        e.preventDefault();

         localStorage.clear();
         window.location.href='/'
    }

    render() {
        return (
            <MuiThemeProvider>
                <React.Fragment>
                    <AppBar title="Confirmation"/>
                    
                   <h1>Thanks for your cooperation you can Sign Out 
                       <br /> 
                       If you wish
                   </h1>

                        <br/>

                    <RaisedButton
                        label="Sign Out"
                        primary={true}
                        style={styles.button}
                        onClick={this.signOut} //what does continue do? It calls nextStep
                    />

                    <RaisedButton
                        label="Back"
                        primary={true}
                        style={styles.button}
                        onClick={this.back} //what does back do? It calls prevStep
                    />

                </React.Fragment>
            </MuiThemeProvider>
        )
    }
}

const styles = {
    button:{
        margin:15
    }
}

export default Success
