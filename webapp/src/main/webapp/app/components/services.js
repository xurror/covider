import React from 'react'
import Header from './header'

export default class Services extends React.Component {
    constructor(props) {
        super(props)

        this.state = {
            pageName : 'Services'
        }
    }
    render() {
        return (
            <div>
                <Header pageName={this.state.pageName}/>
            </div>
        )
    }
}
