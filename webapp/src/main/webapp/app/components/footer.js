import React, { Component } from 'react'
import Classes from './../styles/footer.module.css'

export default class Footer extends Component {
    render() {
        return (
            <div className={Classes.footer}>
                <p>copyright © 2019. All Rights Reserved to covider team</p>
            </div>
        )
    }
}
