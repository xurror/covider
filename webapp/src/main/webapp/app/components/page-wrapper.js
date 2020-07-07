import React from 'react'
import Classes from './../styles/page-wrapper.module.css';

export default function PageWrapper(props) {
    return (
        <div className={Classes.PageWrapper}>
            {props.children}
        </div>
    )
}
