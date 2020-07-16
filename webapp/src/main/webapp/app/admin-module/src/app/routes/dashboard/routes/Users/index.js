import React from "react";
import UserList from "./UserList";
import SiteVisit from "./SiteVisit";
import RecentActivity from "./RecentActivity";
import WelComeCard from "./WelComeCard";
import Overview from "./Overview";
import SiteAudience from "./SiteAudience";
import TotalRevenueCard from "./TotalRevenueCard";
import NewCustomers from "./NewCustomers";
import GrowthCard from "./GrowthCard";
import IconWithTextCard from "./IconWithTextCard";
import Widget from "components/Widget";
import {detailCards, recentActivity} from "./data";
import CurrencyCalculator from "../Crypto/CurrencyCalculator";
import ContainerHeader from "components/ContainerHeader";
import IntlMessages from "util/IntlMessages";

const Users = ({match}) => {
  return (

    <div className="dashboard animated slideInUpTiny animation-duration-3">

      <ContainerHeader match={match} title={<IntlMessages id="sidebar.dashboard.users"/>}/>
      <div className="row">
        <div className="col-xl-12 col-lg-12 col-md-12 col-12">
          <Widget styleName="p-4">
            <div className="row">
              <div className="col-xl-3 col-lg-3 col-md-6 col-sm-6 col-12">
                <WelComeCard/>
              </div>

              <div className="jr-audi-col col-xl-3 col-lg-3 col-md-6 col-sm-6 col-12">
                <SiteAudience/>
              </div>

              <div className="jr-visit-col col-xl-6 col-lg-6 col-md-12 col-sm-12 col-12">
                <SiteVisit/>
              </div>
            </div>
          </Widget>
        </div>
        <div className="col-xl-4 col-lg-4 col-md-6 col-12">
          <TotalRevenueCard/>
        </div>
        <div className="col-xl-4 col-lg-4 col-md-6 col-12">
          <NewCustomers/>
        </div>
        <div className="col-xl-4 col-lg-4 col-md-12 col-12">
          <GrowthCard/>
        </div>
        <div className="col-xl-4 col-lg-4 col-md-12 col-12 order-sm-2">
          <Widget>
            <RecentActivity recentList={recentActivity} shape="rounded"/>
          </Widget>
        </div>

        <div className="col-xl-8 col-lg-8 col-md-12 col-12 order-sm-1">
          <div className="row">

            <div className="col-xl-12 col-lg-12 col-md-12 col-12">
              <UserList/>
            </div>

            <div className="col-xl-12 col-lg-12 col-md-12 col-12">
              <Overview/>
            </div>
          </div>
        </div>
      </div>

    </div>
  );
};

export default Users;
