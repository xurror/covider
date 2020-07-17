import React from 'react'
import Header from './header'
import PageWrapper from './page-wrapper'

export default class Education extends React.Component {
    constructor(props) {
        super(props)

        this.state = {
            pageName : 'Education'
        }
    }
    render() {
        return (
            <div>
                <PageWrapper>
                    <Header pageName={this.state.pageName}/>
                </PageWrapper>
            </div>
        )
    }
}
