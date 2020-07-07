import React, { Component } from 'react'
import Classes from './../styles/home.module.css'
import Particles from 'react-particles-js';
import { Link } from 'react-router-dom'

export default class Home extends Component {
    constructor(props) {
        super(props)

        this.state = {
            fullName: 'name',
            jobTitle: 'job',
            disc: 'I\'m a poor man',
            particlesOpt: {
                particles: {
                    number: {
                        value: 300,
                        density: {
                            enable: true,
                            value_area: 1200
                        }
                    }
                }
            },
            btnValue: 'More Aboure Me'
        }
    }
    render() {
        return (
            <div className={Classes.home}>
                <Particles
                    params={this.state.particlesOpt}
                />
                <div className={Classes.bannerText}>
                    <h3 className={Classes.jobTitle}>{this.state.jobTitle}</h3>
                    <h1 className={Classes.fullName}>{this.state.fullName}</h1>
                    <p className={Classes.disc}>{this.state.disc}</p>
                    <Link to="/about-me" className={Classes.bannerButton}>{this.state.btnValue}</Link>
                </div>
            </div>
        )
    }
}
