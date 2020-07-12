import React from 'react';
import {Bar, BarChart, ResponsiveContainer} from 'recharts';

import {
  announcementsNotification,
  appNotification,
  article,
  authors,
  chartData,
  marketingData,
  newArticlesData
} from './data';
import PopularArticles from 'components/dashboard/news/PopularArticals';
import MarketingTable from 'components/dashboard/Common/MarketingTable';
import StoryOfTheDay from 'components/dashboard/news/StoryOfTheDay';
import Comments from 'components/dashboard/news/CommentsTable';
import LatestNotifications from 'components/dashboard/Common/LatestNotifications';
import ReportBox from 'components/ReportBox/index';
import ContainerHeader from 'components/ContainerHeader/index';
import SiteTraffic from 'components/dashboard/news/SiteTraffic';
import YourDailyFeed from 'components/dashboard/news/YourDailyFeed';
import CardHeader from 'components/dashboard/Common/CardHeader/index';
import UserDetailTable from 'components/dashboard/Common/UserDetailTable';
import IntlMessages from 'util/IntlMessages';

const News =(props)=> {

    return (
      <div className="dashboard animated slideInUpTiny animation-duration-3">
        <ContainerHeader match={props.match} title={<IntlMessages id="sidebar.dashboard.news"/>}/>

        <div className="row">
          <div className="col-lg-7 col-12">
            <div className="jr-card jr-full-card overflow-hiden">
              <CardHeader heading={<IntlMessages id="dashboard.comments"/>}
                          styleName="pb-2"/>
              <Comments/>
            </div>
          </div>

          <div className="col-lg-5 col-12">
            <div className="jr-card jr-full-card">
              <CardHeader heading={<IntlMessages id="dashboard.yourDailyFeed"/>} styleName="pb-2"/>
              <YourDailyFeed/>
            </div>
          </div>
        </div>
        <SiteTraffic/>
      </div>

    );
  }

export default News;
