import React,{useState} from 'react';
import IconButton from '@material-ui/core/IconButton';
import {Area, AreaChart, Bar, BarChart, ResponsiveContainer, Tooltip, XAxis} from 'recharts';
import {VectorMap} from "react-jvectormap";


import MonthlyRevenue from 'components/dashboard/default/MonthlyRevenue';
import {chartDataWithoutAxis} from 'app/routes/dashboard/routes/ECommerce/data'
import {cardData, cardData1, cardData2, connections, data1, expanseData, ordersData, todoData} from '../data'
import {projects, signUpData, totalRevenueData} from './data'
import InfoCard from 'components/InfoCard';
import InFoWithBgImage from 'components/InFoWithBgImage';
import UserDetailCard from 'components/UserDetailCard';
import SimpleToDo from 'components/ToDoCard/index';
import ChartCard from 'components/dashboard/Common/ChartCard';
import SiteVisitor from 'components/dashboard/Common/SiteVisitor';
import CardBox from 'components/CardBox';
import UserDetailTable from 'components/dashboard/Common/UserDetailTable';
import UserProfileCard from 'components/dashboard/Common/userProfileCard/UserProfileCard';
import MarketingTable from 'components/dashboard/Common/MarketingTable';
import PhotoCollage from 'components/dashboard/Common/PhotoCollage/index';
import LatestNotifications from 'components/dashboard/Common/LatestNotifications';
import RecentActivities from 'components/dashboard/Common/RecentActivities/index';
import {dailyFeedData, recentList} from '../Intranet/data';

import ProjectsList from 'components/dashboard/Common/ProjectsList';
import YourDailyFeed from 'components/dashboard/Common/DailyFeed/index';
import TimerView from 'components/dashboard/Common/TimerView/index';
import ContactCard from 'components/Cards/Contact';
import SimpleCard from 'components/Cards/Sample/index';
import PopularProduct from 'components/dashboard/Common/PopularProduct';
import LatestPosts from 'components/dashboard/Common/LatestPosts/index';
import {
  announcementsNotification,
  appNotification,
  latestPostList,
  marketingData,
  products
} from 'app/routes/dashboard/routes/Misc/data';
import Button from '@material-ui/core/Button';
import CafeCard from 'components/Cards/Cafe/index';
import Statistics from 'components/dashboard/default/Statistics';
import ContainerHeader from 'components/ContainerHeader/index';
import CardMenu from 'components/dashboard/Common/CardMenu';
import CardHeader from 'components/dashboard/Common/CardHeader/index';
import IntlMessages from 'util/IntlMessages';
import {CircularProgressbar} from "react-circular-progressbar";
import 'react-circular-progressbar/dist/styles.css';
import './test.css'
import GradientSVG from "app/routes/dashboard/routes/Misc/GradientSVG";
import {Progress} from "reactstrap";
import MapWithASearchBox from "app/routes/map/routes/MapWithSearchBox/Components/MapWithASearchBox";
import HorizontalItemCard from "components/dashboard/Common/HorizontalItemCard";

const percentage = 70;

const Misc =(props)=> {

  const [anchorEl,setanchorEl]=useState();
  const [menuState,setMenuState]=useState();

  const  onOptionMenuSelect = event => {
    setanchorEl(event.currentTarget)
  };
  const  handleRequestClose = () => {
    setMenuState(false)
  };

    return (
      <div className="dashboard animated slideInUpTiny animation-duration-3">
        <ContainerHeader match={props.match} title={<IntlMessages id="sidebar.dashboard"/>}/>

        <div className="row">
          <div className="col-xl-5 col-12">
            <div className="jr-card p-0">
              <div className="jr-card-header pt-4 px-4 mb-1">
                <h3 className="mb-0"><IntlMessages id="dashboard.userStatstics"/></h3>
              </div>
              <div className="card-img-bottom overflow-hidden">
                <MonthlyRevenue chartData={expanseData}/>
              </div>
            </div>
          </div>

          <div className="col-xl-7 col-12">
            <div className="row">
              <div className="col-xl-7 col-lg-6 col-sm-7 col-12">
                <div className="row">
                  <div className="col-6">
                    <InfoCard data={cardData}/>
                  </div>
                  <div className="col-6">
                    <InfoCard data={cardData1}/>
                  </div>
                </div>
              </div>

              <div className="col-xl-5 col-lg-6 col-sm-5 col-12">
                <ChartCard styleName="jr-chart-or" chartHeaderStyle="pl-3 pr-2 pt-3 mb-2">
                  <div className="chart-title d-flex">
                    <h3 className="mb-0 mr-auto">
                      <IntlMessages id="dashboard.orders"/>
                      <small className="font-weight-normal">(293)</small>
                    </h3>

                    <IconButton className="icon-btn-sm p-1 jr-fs-lg"><i className="zmdi zmdi-more-vert"/></IconButton>
                  </div>

                  <ResponsiveContainer className="card-img-bottom overflow-hidden" width="100%" height={52}>
                    <AreaChart data={ordersData} margin={{top: 0, right: 0, left: 0, bottom: 0}}>
                      <Tooltip/>
                      <defs>
                        <linearGradient id="orders" x1="0" y1="0" x2="1" y2="0">
                          <stop offset="5%" stopColor="#3f51b5" stopOpacity={1}/>
                          <stop offset="95%" stopColor="#ff4081" stopOpacity={1}/>
                        </linearGradient>
                      </defs>
                      <Area type="monotone" dataKey="lastWeek" strokeWidth={0} stroke="#C24590" fillOpacity={1}
                            fill="url(#orders)"/>
                    </AreaChart>
                  </ResponsiveContainer>
                </ChartCard>
              </div>
              <div className="col-xl-7 col-lg-6 col-sm-7 col-12">
                <InFoWithBgImage data={cardData2}/>
              </div>
              <div className="col-xl-5 col-lg-6 col-sm-5 col-12">
                <UserDetailCard/>
              </div>
            </div>
          </div>
        </div>

        <div className="row">
          <div className="col-lg-3 col-sm-6 col-12">
            <UserProfileCard styleName="pb-4" headerStyle="bg-gradient-primary"/>
          </div>

          <div className="col-lg-4 col-sm-6 col-12">
            <div className="jr-card jr-full-card">

              <CardHeader heading="New Connections"
                          subHeading="3 This week"/>

              <UserDetailTable data={connections} tableStyle="full-table-last-sm"/>
            </div>
          </div>

          <div className="col-lg-5 col-sm-6 col-12">
            <div className="jr-card">
              <CardHeader heading={<IntlMessages id="dashboard.recentActivities"/>}
                          subHeading={<IntlMessages id="dashboard.lastActivity"/>}/>

              {recentList.map((recentList, index) => <RecentActivities key={index}
                                                                       recentData={recentList}/>)}
            </div>
          </div>

          <div className="col-lg-4 col-sm-6 col-12">
            <div className="jr-card pb-4">
              <div className="jr-card-header mb-3 d-flex align-items-center">
                <h3 className="mb-0 mr-auto"><IntlMessages id="dashboard.currentProjects"/></h3>
                <span className="badge badge-secondary"><IntlMessages id="table.thisWeek"/></span>
              </div>
              <ProjectsList data={projects}/>
            </div>
          </div>

          <div className="col-lg-4 col-sm-6 col-12">
            <div className="jr-card pb-4">
              <div className="jr-card-header d-flex align-items-center">
                <div className="mr-auto">
                  <h3 className="card-heading d-inline-block mb-0"><IntlMessages
                    id="dashboard.toDoItems"/></h3>
                </div>
                <span className="badge badge-secondary"><IntlMessages id="dashboard.today"/></span>
              </div>
              <SimpleToDo data={todoData}/>
            </div>
          </div>

          <div className="col-lg-4 col-sm-6 col-12">
            <div className="jr-card jr-full-card">
              <div className="jr-card-header d-flex align-items-center pb-3">
                <h3 className="card-heading mb-0"><i
                  className="zmdi zmdi-chart-donut zmdi-hc-fw mr-2"/>
                  <IntlMessages id="dashboard.marketingCampaign"/>
                </h3>
                <span className="badge badge-secondary ml-auto"><IntlMessages
                  id="table.thisWeek"/></span>
              </div>
              <MarketingTable data={marketingData}/>
            </div>
          </div>
        </div>

        <div className="row">
          <div className="col-lg-4 col-md-6 col-12">
            <LatestNotifications appNotification={appNotification}
                                 announcementsNotification={announcementsNotification}/>
          </div>

          <div className="col-lg-3 col-sm-6 col-12 order-lg-3">
            <TimerView headerColor="gradient-primary"/>
          </div>

          <div className="col-lg-5 col-md-12 col-sm-6 col-12">
            <div className="jr-card jr-full-card">
              <div className="jr-card-header d-flex align-items-center">
                <div className="mr-auto">
                  <h3 className="card-heading d-inline-block mb-0"><IntlMessages
                    id="dashboard.yourDailyFeed"/></h3>
                </div>
                <span className="badge badge-secondary"><IntlMessages id="dashboard.newFeed"/></span>
              </div>
              <YourDailyFeed data={dailyFeedData}/>
              <div className="daily-feed-footer">
                <span className="jr-link card-link"><IntlMessages id="dashboard.viewAll"/></span>
              </div>
            </div>
          </div>
        </div>

        <div className="row">
          <div className="col-lg-5 col-12">
            <HorizontalItemCard
              styleTitle="mb-4"
              styleName="p-4"
              title="This Year Sale Report"
              price="$685K+"
              detail="Post 9 month data"
              chartPosition="align-self-end"
            >
              <ResponsiveContainer width="100%" height={100}>
                <BarChart data={chartDataWithoutAxis}>
                  <Bar dataKey='amt' fill='#3f51b5' maxBarSize={10}/>
                  <XAxis stroke="#3f51b5" dataKey="name"/>
                </BarChart>
              </ResponsiveContainer>
            </HorizontalItemCard>
          </div>
          <div className="col-lg-5 col-sm-8 col-12 order-lg-3 ">
            <div className="jr-card py-3">
              <div className="row">
                <div className="col-sm-4 col-12">
                  <GradientSVG/>
                  <div className="d-flex flex-column align-items-center">
                    <div className="max-width-100">
                      <CircularProgressbar
                        percentage={percentage}
                        text={`${percentage}%`}
                        styles={{
                          path: {stroke: `url(#cpGradient)`, height: '100%'},
                          text: {fill: '#3D3D3D', fontSize: '16px'}
                        }}
                      />
                    </div>
                  </div>
                </div>
                <div className="col-sm-8 col-12 text-sm-left text-center align-self-center">
                  <div className="jr-card-header mb-2">
                    <h3 className="card-heading"><IntlMessages id="dashboard.googleInsight"/></h3>
                    <p className="sub-heading"><IntlMessages id="dashboard.lastCalculated"/></p>
                  </div>
                  <Button variant="contained" className="text-uppercase jr-btn-sm"
                          color="primary">
                    <i className="zmdi zmdi-refresh-sync zmdi-hc-fw "/>
                    <span><IntlMessages id="dashboard.refresh"/></span>
                  </Button>
                </div>
              </div>
            </div>
          </div>

          <div className="col-lg-2 col-sm-4 col-12">
            <div className="jr-card bg-gradient-primary text-white text-center">
              <div className="mb-3 mt-xl-1">
                <img src={require("assets/images/dashboard/download.png")} alt="download1"/>
              </div>
              <h5 className="text-uppercase mb-xl-1"><IntlMessages id="dashboard.upgradeToday"/></h5>
            </div>
          </div>
        </div>

        <div className="row">
          <div className="col-lg-3 col-sm-6 col-12">
            <ChartCard styleName="bg-gradient-primary text-white">
              <div className="chart-title">
                <h2 className="mb-1">2,397</h2>
                <p><IntlMessages id="dashboard.onlineSignups"/></p>
              </div>

              <ResponsiveContainer width="100%" height={110}>
     
              </ResponsiveContainer>
            </ChartCard>
          </div>
          <div className="col-lg-3 col-sm-6 col-12">
            <ChartCard styleName="bg-cyan text-white">
              <div className="chart-title">
                <h2 className="mb-1">$7,890</h2>
                <p><IntlMessages id="dashboard.lastMonthSale"/></p>
              </div>

              <ResponsiveContainer width="100%" height={110}>
                <AreaChart data={data1} margin={{top: 0, right: 0, bottom: 0, left: 0}}>
                  <Tooltip/>
                  <Area type="monotone" dataKey="pv" stroke="rgba(255,255,255,0.5)" activeDot={{r: 8}}
                        fillOpacity={.5}
                        fill="rgba(255,255,255,0.8)"/>
                </AreaChart>
              </ResponsiveContainer>
            </ChartCard>
          </div>
          <div className="col-lg-3 col-sm-6 col-12">
            <ChartCard styleName="bg-secondary text-white">
              <div className="chart-title">
                <h2 className="mb-1">$87,356</h2>
                <p><IntlMessages id="dashboard.totalRevenue"/></p>
              </div>

              <ResponsiveContainer width="100%" height={110}>
                
              </ResponsiveContainer>

            </ChartCard>
          </div>
          <div className="col-lg-3 col-sm-6 col-12">
            <ChartCard styleName="bg-warning text-white">
              <div className="chart-title">
                <h2 className="mb-1">185</h2>
                <p><IntlMessages id="dashboard.totalEmail"/></p>
              </div>
              <div className="p-3">
                <div className="d-flex flex-row p-0">
                  <p className="text-white m-0">Opened</p>
                  <p className="text-white ml-auto m-0">72 %</p>
                </div>
                <Progress className="shadow-lg mb-2 my-1" style={{height: 6}} color="white" value="72"/>
                <div className="d-flex flex-row">
                  <p className="text-white m-0">Bounced</p>
                  <p className="text-white ml-auto m-0">28%</p>
                </div>
                <Progress className="shadow-lg my-1" style={{height: 6}} color="white" value="28"/>
              </div>
            </ChartCard>
          </div>
        </div>

        <div className="row">
          
          <div className="col-lg-5 col-sm-6 col-12">
            <div className="jr-card">
              <div className="jr-card-header d-flex align-items-center">
                <div className="mr-auto">
                  <h3 className="card-heading"><IntlMessages id="dashboard.latestPosts"/></h3>
                  <p className="sub-heading"><IntlMessages id="dashboard.loremIpsum"/></p>
                </div>

                <IconButton className="icon-btn ml-auto" onClick={onOptionMenuSelect}>
                  <i className="zmdi zmdi-more-vert"/>
                </IconButton>
              </div>

              <ul className="list-unstyled">
                {latestPostList.map((latestPostList, index) =>
                  <LatestPosts key={index} recentData={latestPostList}/>
                )}
              </ul>

              <div>
                <span className="jr-link card-link jr-fs-13 text-uppercase">
                  <IntlMessages id="dashboard.viewAllPosts"/> </span>
              </div>
            </div>
          </div>

          <div className="col-lg-3 col-sm-12 col-12">
            <div className="row">
              <div className="col-lg-12 col-sm-6 col-12">
                <div className="jr-card pb-2">
                  <div className="jr-card-thumb">
                    <img className="card-img-top img-fluid"
                         src={"https://via.placeholder.com/268x164"} alt="toa-heftiba"/>
                  </div>
                  <div className="jr-card-social">
                    <ul className="social-link d-flex">
                      <li className="active">
                        <span className="jr-link">
                         <i className="zmdi zmdi-volume-up"/>
                        </span>
                      </li>
                      <li>
                        <span className="jr-link">
                          <i className="zmdi zmdi-bookmark zmdi-hc-lg"/>
                        </span>
                      </li>
                      <li>
                        <span className="jr-link">
                          <i className="zmdi zmdi-share zmdi-hc-lg"/>
                        </span>
                      </li>
                    </ul>
                  </div>
                </div>
              </div>

              <div className="col-lg-12 col-sm-6 col-12">
                <SimpleCard headerStyle="bg-gradient-primary"/>
              </div>
            </div>
          </div>
        </div>

        <div className="row">
          <div className="col-lg-8 col-12">
            <div className="jr-card">
              <div className="jr-card-header d-flex align-items-center">
                <div className="mr-auto">
                  <h3 className="card-heading"><IntlMessages id="dashboard.popularProducts"/></h3>
                  <p className="sub-heading"><IntlMessages id="dashboard.popularProductsTxt"/></p>
                </div>

                <IconButton className="icon-btn" onClick={onOptionMenuSelect}>
                  <i className="zmdi zmdi-chevron-down"/>
                </IconButton>
              </div>
              <div className="row">
                {products.map((product, index) => <PopularProduct key={index} product={product}/>)}
              </div>
              <span className="card-link text-uppercase">
                <IntlMessages id="dashboard.allProducts"/> </span>
            </div>
          </div>

          <div className="col-lg-4 col-sm-6 col-12">
            <ContactCard/>
          </div>

          <div className="col-lg-4 col-sm-6 col-12">
            <PhotoCollage/>
          </div>

          <CardBox styleName="col-lg-8 col-12" heading="Site Visitors Statistics">
            <div>
              Lorem ipsum is dummy content Cenas in erat accumsan, hendrerit
              lorem vel, pulvinar odio. Quisque
              eu conva. hendrerit lorem vel, pulvinar odio. Quisque eu conva.
            </div>
            <SiteVisitor
              children={<VectorMap map={'world_mill'}
                                   backgroundColor="#FFF"
                                   containerStyle={{
                                     width: '100%',
                                     height: '100%'
                                   }}
                                   regionStyle={{
                                     initial: {
                                       fill: "#DEE4E8"
                                     }
                                   }}
                                   markerStyle={{
                                     initial: {
                                       fill: "#3258EF",
                                       stroke: 'rgba(50, 88, 239, 0.2)',
                                     }
                                   }}
                                   zoomButtons={false}
                                   zoomOnScroll={false}
                                   containerClassName="map"
                                   markers={[{latLng: [28.02, 73.31], name: 'INDIA(45)'}]}
              />}/>
          </CardBox>
        </div>

        <div className="row">
          <div className="col-md-4 col-12">
            <Statistics/>
          </div>

          <div className="col-md-4 col-sm-6 col-12">
            <CafeCard/>
          </div>

          <div className="col-md-4 col-sm-6 col-12">
            
          </div>

          <div className="col-12">
            <div className="jr-card mb-0 p-2">
              <MapWithASearchBox styleName="embed-responsive-31by9"/>
            </div>
          </div>
        </div>

        <CardMenu menuState={menuState} anchorEl={anchorEl}
                  handleRequestClose={handleRequestClose}/>

      </div>

    );
  }

export default Misc;
