import React, { Component } from 'react'
import MuiThemeProvider from 'material-ui/styles/MuiThemeProvider';
import AppBar from 'material-ui/AppBar';
import {List, ListItem} from 'material-ui/List';
import RaisedButton from 'material-ui/RaisedButton';



export class UserInfo extends Component {
    continue = e => {   
        e.preventDefault();
        //PROCESS YOUR FORM // This is whare you send information to you API for processing
        this.props.nextStep();
    }

    //Now we want to pull out all the values since values are in the props



    render() {
        const {values: {Username,idcardnumber,Email,TEST_YES,NumOfFamilyMembers,HowManyFamilyMembersHaveDoneTest,Present_Location, Previous_Location}} = this.props;

        return (
            <MuiThemeProvider>
                <React.Fragment>
                    <AppBar title="Confirm User Information"/>

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
                        primaryText="TEST_YES"
                        secondaryText={TEST_YES}
                    />

                    <ListItem
                        primaryText="NumOfFamilyMembers"
                        secondaryText={ NumOfFamilyMembers }
                    />

                    <ListItem
                        primaryText="HowManyFamilyMembersHaveDoneTest"
                        secondaryText={ HowManyFamilyMembersHaveDoneTest }
                    />

                    <ListItem
                        primaryText="Present_Location"
                        secondaryText={ Present_Location }
                    />

                    <ListItem
                        primaryText=" Previous_Location"
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
                        label="Update"
                        primary={true}
                        style={styles.button}
                        onClick={this.update} //what does continue do? It calls nextStep
                    />

                    <RaisedButton
                        label="Back"
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

export default UserInfo
