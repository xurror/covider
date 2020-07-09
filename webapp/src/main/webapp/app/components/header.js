import React from 'react'
import Classes from './../styles/header.module.css'

export default function Header(props) {
    return (
        <div className={Classes.header}>
            <h1>My <span>{props.pageName}</span></h1>
        </div>
    )
}
