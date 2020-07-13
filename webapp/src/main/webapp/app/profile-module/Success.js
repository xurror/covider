import React, { Component } from 'react';
import MuiThemeProvider from 'material-ui/styles/MuiThemeProvider';
import AppBar from 'material-ui/AppBar';
import RaisedButton from 'material-ui/RaisedButton';


export class Success extends Component {

  
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
                        onClick={this.continue} //what does continue do? It calls nextStep
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
