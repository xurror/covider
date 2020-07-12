import React, { Component } from 'react';
import FormUserDetails from './FormUserDetails';    
import displayInfo from './displayInfo';
import Success from './Success'


export class displayInfo extends Component {

    //This was SignIn
//methods here
        state = {
            step:1,
            Username:'',
            idcardnumber:'',
            Email:'', 
          Symptoms:'',
          Present_Location:'',
          Previous_Location:''        
         }


         //Proceed to next step

        nextStep = () => {
            const {step} = this.state;
            this.setState({ 
                step: step + 1
            });
        }

        //Go back to previous step
        
        prevStep = () => {
            const {step} = this.state;
            this.setState({ 
                step: step - 1
            });
        }

         //Handle fields change 
         handleChange = input => e =>{
            this.setState({[input]: e.target.value}); 
        }

            

//end of the methods now we go to the render

    render() {

        const {step} = this.state;
        const {Username,idcardnumber,Email,Symptoms,Present_Location,Previous_Location} = this.state;
        const values = {Username,idcardnumber,Email,Present_Location,Previous_Location};

        switch (step) {
            case 1:
                return (
                    <FormUserDetails
                    nextStep = {this.nextStep}
                    handleChange= {this.handleChange}
                    values={values}
                    />
                )
                
                case 2: 
                    return(
                        <displayInfo
                        nextStep = {this.nextStep}
                        prevStep = {this.prevStep}     
                        values={values}
                        />
                    )
                case 3  :
                    return <Success />
        }

    }
}

export default displayInfo
