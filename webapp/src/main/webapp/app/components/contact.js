import React from 'react'
import Header from './header'

export default class Contact extends React.Component {
    constructor(props) {
        super(props)

        this.state = {
            pageName : 'Contact'
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
