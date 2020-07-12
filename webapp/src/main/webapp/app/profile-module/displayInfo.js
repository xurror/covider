import React, { Component } from 'react'
import MuiThemeProvider from 'material-ui/styles/MuiThemeProvider';
import AppBar from 'material-ui/AppBar';
import {List, ListItem} from 'material-ui/List';
import RaisedButton from 'material-ui/RaisedButton';



export class displayInfo extends Component {
    continue = e => {   
        e.preventDefault();
        //PROCESS YOUR FORM // This is whare you send information to you API for processing
        this.props.nextStep();
    };

    back = e => {
        e.preventDefault();
        this.props.prevStep();
    }

    //Now we want to pull out all the values since values are in the props



    render() {
        const {values: {Username,idcardnumber,Email,Present_Location, Previous_Location}} = this.props;

        return (
            <MuiThemeProvider>
                <React.Fragment>
                    <AppBar title="User Information"/>

                <List>

                    <ListItem
                        primaryText="User Name"
                        secondaryText={ Username }
                    />

                    <ListItem
                        primaryText="ID CARD NUMBER"
                        secondaryText={ idcardnumber }
                    />

                    <ListItem
                        primaryText="Email"
                        secondaryText={ Email }
                    />

                    <ListItem
                        primaryText="Present Location"
                        secondaryText={ Present_Location }
                    />

                    <ListItem
                        primaryText=" Previous Location"
                        secondaryText={ Previous_Location}
                    />

                


                </List>

                    <br/>

                    <RaisedButton
                        label="Continue"
                        primary={true}
                        style={styles.button}
                        onClick={this.continue} //what does continue do? It calls nextStep
                    />

                    

                    <RaisedButton
                        label="UPDATE"
                        primary={true}
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

export default displayInfo
