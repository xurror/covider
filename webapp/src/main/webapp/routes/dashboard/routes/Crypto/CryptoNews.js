import React, {useState} from "react";
import {Nav, NavItem, NavLink, TabContent, TabPane} from 'reactstrap';
import classNames from 'classnames';

import Widget from "components/Widget/index";
import {allNews, bitCoinNews, lightCoinNews, rippleNews} from "./data"
import CryptoNewsItem from "./CryptoNewsItem";

const CryptoNews =()=> {

  const [tabIndex,setTabIndex]=useState(1);

    return (
      <Widget>
        <div className="d-flex flex-row justify-content-between mb-2">
          <h4 className="mr-2">Crypto News</h4>

          <span className="ml-2 pointer"><i className="zmdi zmdi-search text-primary jr-fs-xl"/></span>
        </div>
        <div className="jr-news-action jr-tabs-classic jr-tabs-classic-no-border">
          <div className="jr-tabs-up jr-tabs-up-no-border">
            <Nav className="jr-tabs-pills-ctr" pills>
              <NavItem>
                <NavLink
                  className={classNames({active: tabIndex === 1})}
                  onClick={() => {
                    setTabIndex(1);
                  }}>
                  All
                </NavLink>
              </NavItem>
              <NavItem>
                <NavLink
                  className={classNames({active: tabIndex === 2})}
                  onClick={() => {
                    setTabIndex(2);
                  }}
                >
                  Bitcoin
                </NavLink>
              </NavItem>
              <NavItem>
                <NavLink
                  className={classNames({active: tabIndex === 3})}
                  onClick={() => {
                    setTabIndex(3);
                  }}>
                  Ripple
                </NavLink>
              </NavItem>
              <NavItem>
                <NavLink
                  className={classNames({active:tabIndex === 4})}
                  onClick={() => {
                    setTabIndex(4);
                  }}>
                  Litecoin
                </NavLink>
              </NavItem>
            </Nav>
          </div>

          <TabContent className="jr-tabs-content" activeTab={tabIndex}>
            <TabPane tabId={1}>
              {allNews.map((data, index) =>
                <CryptoNewsItem key={index} data={data}/>
              )}
            </TabPane>

            <TabPane tabId={2}>
              {bitCoinNews.map((data, index) =>
                <CryptoNewsItem key={index} data={data}/>
              )}
            </TabPane>
            <TabPane tabId={3}>
              {rippleNews.map((data, index) =>
                <CryptoNewsItem key={index} data={data}/>
              )}
            </TabPane>
            <TabPane tabId={4}>
              {lightCoinNews.map((data, index) =>
                <CryptoNewsItem key={index} data={data}/>
              )}
            </TabPane>
          </TabContent>
        </div>
      </Widget>
    );
  };

export default CryptoNews;
