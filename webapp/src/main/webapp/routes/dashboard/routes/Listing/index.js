import React from "react";
import {Area, AreaChart, ResponsiveContainer} from "recharts";
import ChartCard from "./ChartCard";
import UserImages from "./UserImages";
import RecentActivity from "../CRM/RecentActivity";
import CurrentPlan from "./CurrentPlan";
import DealsClosedCard from "./DealsClosedCard";
import PropertiesCard from "./PropertiesCard";
import Widget from "components/Widget/index";
import ContainerHeader from "components/ContainerHeader/index";
import IntlMessages from "util/IntlMessages";

import {increamentData} from "./mdata";
import {recentActivity} from "../CRM/data";


const Listing = ({match}) => {
  return (

    <div className="dashboard animated slideInUpTiny animation-duration-3">

      <ContainerHeader match={match} title={<IntlMessages id="sidebar.dashboard.listing"/>}/>
      <div className="row">
        <div className="col-xl-3 col-lg-3 col-md-6 col-sm-6 col-12">
          <ChartCard chartProperties={{
            title: 'PROPERTIES',
            prize: '26,873',
            icon: 'stats',
            bgColor: 'indigo',
            styleName: 'up',
            desc: 'This week',
            percent: '03%',
          }}
                     children={<ResponsiveContainer width="100%" height={75}>
                       <AreaChart data={increamentData}
                                  margin={{top: 0, right: 0, left: 0, bottom: 0}}>
                         <Area dataKey='pv' strokeWidth={0} stackId="2" stroke='#273894' fill="#273894"
                               fillOpacity={1}/>
                       </AreaChart>
                     </ResponsiveContainer>}
          />

        </div>
        <div className="col-xl-3 col-lg-3 col-md-6 col-sm-6 col-12">
          <ChartCard
            chartProperties={{
              title: 'CITIES',
              prize: '384',
              icon: 'stats',
              bgColor: 'pink accent-2',
              styleName: 'up',
              desc: '7 New cities this week',
              percent: '',
            }}
            children={<ResponsiveContainer width="100%" height={75}>
              <AreaChart data={increamentData}
                         margin={{top: 0, right: 0, left: 0, bottom: 0}}>
                <Area dataKey='pv' type='monotone' strokeWidth={0} stackId="2" stroke='#da2361'
                      fill='#da2361'
                      fillOpacity={1}/>
              </AreaChart>
            </ResponsiveContainer>}
          />
        </div>
        <div className="col-xl-3 col-lg-3 col-md-6 col-sm-6 col-12">
          <ChartCard
            chartProperties={{
              title: 'ONLINE VISITS',
              prize: '284,729',
              icon: 'stats',
              bgColor: 'info',
              styleName: 'down',
              desc: 'Avg. 327 visits daily',
              percent: '',
            }}
            children={<ResponsiveContainer width="100%" height={75}>
              <AreaChart data={increamentData}
                         margin={{top: 0, right: 0, left: 0, bottom: 0}}>
                <Area dataKey='pv' strokeWidth={0} stackId="2" stroke='#0c8e9f' fill='#0c8e9f'
                      fillOpacity={1}/>
              </AreaChart>
            </ResponsiveContainer>}
          />
        </div>
        <div className="col-xl-3 col-lg-3 col-md-6 col-sm-6 col-12">
          <ChartCard
            chartProperties={{
              title: 'ONLINE QUERIES',
              prize: '87,239',
              icon: 'stats',
              bgColor: 'success',
              styleName: 'down',
              desc: 'from past month',
              percent: '39%',
            }}
            children={<ResponsiveContainer width="100%" height={75}>
              <AreaChart data={increamentData}
                         margin={{top: 0, right: 0, left: 0, bottom: 0}}>
                <Area dataKey='pv' strokeWidth={0} stackId="2" stroke='#3a983e' fill='#3a983e'
                      fillOpacity={1}/>
              </AreaChart>
            </ResponsiveContainer>}
          />
        </div>

        <div className="col-xl-4 col-lg-4 col-md-12 col-12 order-sm-2">
          <Widget>
            <RecentActivity shape="rounded" recentList={recentActivity}/>
          </Widget>
        </div>

        <div className="col-xl-8 col-lg-8 col-md-12 col-12 order-sm-1">
          <UserImages/>
          <div className="row">
            <div className="col-xl-6 col-lg-6 col-md-6 col-12">
              <CurrentPlan/>
            </div>
            <div className="col-xl-6 col-lg-6 col-md-6 col-12">
              <DealsClosedCard/>
            </div>
          </div>
          <PropertiesCard/>
        </div>
      </div>
    </div>
  );
};

export default Listing;
