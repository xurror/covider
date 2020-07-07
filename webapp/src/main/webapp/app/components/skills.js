import React from 'react'
import Header from './header'

export default class Skills extends React.Component {
    constructor(props) {
        super(props)

        this.state = {
            pageName: 'Skills'
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
