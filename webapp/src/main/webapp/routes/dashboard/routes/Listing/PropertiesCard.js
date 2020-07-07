import React, {useState} from "react";
import {Nav, NavItem, NavLink, TabContent, TabPane} from 'reactstrap';
import classNames from 'classnames';

import Widget from "components/Widget/index";
import {albama, allProperties, colorado, newJercy} from "./data"
import PropertiesItemCard from "./PropertiesItemCard";

const PropertiesCard =()=> {

  const [activeTab,setActiveTab]=useState(1);

    return (
      <Widget>
        <div className="d-flex flex-row justify-content-between mb-2">
          <h4 className="mr-2">Properties</h4>

          <span className="ml-2 pointer"><i className="zmdi zmdi-search text-primary jr-fs-xl"/></span>
        </div>
        <div className="jr-news-action jr-tabs-classic jr-tabs-classic-no-border">
          <div className="jr-tabs-up jr-tabs-up-no-border">
            <Nav className="jr-tabs-pills-ctr" pills>
              <NavItem>
                <NavLink
                  className={classNames({active:activeTab === 1})}
                  onClick={() => {
                    setActiveTab(1);
                  }}
                >
                  All
                </NavLink>
              </NavItem>
              <NavItem>
                <NavLink
                  className={classNames({active:activeTab === 2})}
                  onClick={() => {
                    setActiveTab(2);
                  }}
                >
                  New Jercy
                </NavLink>
              </NavItem>
              <NavItem>
                <NavLink
                  className={classNames({active: activeTab === 3})}
                  onClick={() => {
                    setActiveTab(3);
                  }}>
                  colorado
                </NavLink>
              </NavItem>
              <NavItem>
                <NavLink
                  className={classNames({active:activeTab === 4})}
                  onClick={() => {
                    setActiveTab(4);
                  }}>
                  Albama
                </NavLink>
              </NavItem>
            </Nav>
          </div>

          <TabContent className="jr-tabs-content" activeTab={activeTab}>
            <TabPane tabId={1}>
              {allProperties.map((data, index) =>
                <PropertiesItemCard key={index} data={data}/>
              )}
            </TabPane>

            <TabPane tabId={2}>
              {newJercy.map((data, index) =>
                <PropertiesItemCard key={index} data={data}/>
              )}
            </TabPane>
            <TabPane tabId={3}>
              {colorado.map((data, index) =>
                <PropertiesItemCard key={index} data={data}/>
              )}
            </TabPane>
            <TabPane tabId={4}>
              {albama.map((data, index) =>
                <PropertiesItemCard key={index} data={data}/>
              )}
            </TabPane>
          </TabContent>
        </div>
      </Widget>
    );
  }

export default PropertiesCard;
