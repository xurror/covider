import React, {Component} from 'react'
import Classes from './../styles/about.module.css'
import { Link } from 'react-router-dom'
import FontAwesome from 'react-fontawesome'
import PageWrapper from './page-wrapper'

export default class About extends Component  {
    constructor(props) {
        super(props)

        this.state = {
            about1: ' I describe myself .',
            about2: ' That helps me.',
            about3: '.',
            contact: 'Contact Me',
            services: 'Services',
            title: 'romeo',
            age: '21 Years',
            jobTitle: 'poor man',
            social: [
                {
                    name: 'facebook',
                    url: 'https://www.facebook.com/im.skrao',
                    target: '_blank'
                },
                {
                    name: 'twitter',
                    url: 'https://twitter.com/im_skrao',
                    target: '_blank'
                },
                {
                    name: 'instagram',
                    url: 'https://www.instagram.com/im_skrao/?hl=en',
                    target: '_blank'
                },
                {
                    name: 'linkedin',
                    url: 'https://www.linkedin.com/in/im-skrao/',
                    target: '_blank'
                },
                {
                    name: 'github',
                    url: 'https://github.com/imskrao',
                    target: '_blank'
                },
                {
                    name: 'medium',
                    url: 'https://medium.com/@imskrao',
                    target: '_blank'
                },
            ]
        }
    }

    createSocial = () => {
        return this.state.social.map((item, i) =>{
            return (
                <div key={i} className={Classes.socialIcon}>
                    <a href={item.url} target={item.target}><FontAwesome name={item.name}/></a>
                </div>
            )
        })
    }

    render() {
        return (
            <PageWrapper>
                <div className={Classes.about}>
                    <div className={Classes.title}>
                        <h1>About <span>{this.state.title}</span></h1>
                    </div>
                    <div className={Classes.aboutBox}>
                        <div className={Classes.info}>
                            <h1 className={Classes.infoTitle}>{this.state.title}</h1>
                            <p>Age: <span>{this.state.age}</span></p>
                            <p>Job: <span>{this.state.jobTitle}</span></p>
                            <div className={Classes.socilIcons}>
                                {this.createSocial()}
                            </div>
                        </div>
                        <div className={Classes.aboutDics}>
                            <strong>Hello!</strong>
                            <div className={Classes.aboutSummary}>
                                <p>{this.state.about1}</p>
                                <p>{this.state.about2}</p>
                                <p>{this.state.about3}</p>
                            </div>
                            <div>
                                <Link to="/contact" className={Classes.aboutButton}>{this.state.contact}</Link>
                            </div>

                        </div>
                    </div>
                </div>
            </PageWrapper>
        )
    }
}
