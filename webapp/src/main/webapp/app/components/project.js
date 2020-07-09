import React from 'react'
import Header from './header'

export default class Project extends React.Component {
    constructor(props) {
        super(props)

        this.state = {
            pageName : 'Project'
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
