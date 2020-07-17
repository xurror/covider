import React from 'react'
import { Timeline } from 'react-twitter-widgets'
import InstagramEmbed from 'react-instagram-embed';
import Classes from './../styles/post.module.css'
import Header from './header';
import PageWrapper from './page-wrapper';

export default function Post() {
    return (
        <PageWrapper>
            <div className={Classes.header}>
                <Header pageName="Post"/>
            </div>

            <div className={Classes.post}>
                
                
            </div>
        </PageWrapper>
    )
}
