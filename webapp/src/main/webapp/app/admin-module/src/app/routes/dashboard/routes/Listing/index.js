import React from "react";
import {Area, AreaChart, ResponsiveContainer} from "recharts";
import ChartCard from "./ChartCard";
import UserImages from "./UserImages";
import RecentActivity from "../Users/RecentActivity";
import CurrentPlan from "./CurrentPlan";
import DealsClosedCard from "./DealsClosedCard";
import PropertiesCard from "./PropertiesCard";
import Widget from "components/Widget/index";
import ContainerHeader from "components/ContainerHeader/index";
import IntlMessages from "util/IntlMessages";

import {increamentData} from "./mdata";
import {recentActivity} from "../Users/data";


const users =[
    {
        "id": 1,
        "first_name": "Customer_1",
        "last_name": "Customer_11",
        "email": "customer1@mail.com",
        "phone": "00000000000",
        "address": "Customer_1 Address",
        "description": "Customer_1 description"
    },
    {
        "id": 2,
        "first_name": "Customer_2",
        "last_name": "Customer_2",
        "email": "customer2@mail.com",
        "phone": "00000000000",
        "address": "Customer_2 Adress",
        "description": "Customer_2 Description"
    },
    {
        "id": 3,
        "first_name": "Customer_3",
        "last_name": "Customer_3",
        "email": "customer3@mail.com",
        "phone": "00000000000",
        "address": "Customer_3 Adress",
        "description": "Customer_3 Description"
    }
]

const Listing = ({match}) => {
  return (

    <div className="dashboard animated slideInUpTiny animation-duration-3">

      <ContainerHeader match={match} title={<IntlMessages id="sidebar.dashboard.listing"/>}/>
      <div className="row">
        <div className="col-xl-3 col-lg-3 col-md-6 col-sm-6 col-12">
          <ChartCard chartProperties={{
            title: 'New Resources',
            prize: '26,873 Items',
            icon: 'stats',
            bgColor: 'indigo',
            styleName: 'up',
            desc: 'This week',
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
              title: 'Cities/Areas to visit',
              prize: '94',
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
              title: 'Current affected People',
              prize: '84,729',
              icon: 'stats',
              bgColor: 'info',
              styleName: 'down',
              desc: '327 new ',
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
              title: 'Resources Distributed',
              prize: '7,239 Items',
              icon: 'stats',
              bgColor: 'success',
              styleName: 'down',
              desc: 'from past month',
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
        <div className="d-flex flex-row">
          <h4 className="mb-0">Agent List</h4>
          <span className="text-primary font-weight-medium pointer ml-auto"><i
            className="zmdi zmdi-search jr-fs-xxl ml-2 d-inline-block align-middle"/> </span>
        </div>
        <div>
                {users.length === 0 && (
                    <div className="text-center">
                        <h2>No customer found at the moment</h2>
                    </div>
                )}
                <div className="container">
                    <div className="row">
                        <table className="table table-bordered">
                            <thead className="thead-light">
                                <tr>
                                    <th scope="col">Firstname</th>
                                    <th scope="col">Lastname</th>
                                    <th scope="col">Email</th>
                                    <th scope="col">Phone</th>
                                    <th scope="col">Address</th>
                                    <th scope="col">Actions</th>
                                </tr>
                            </thead>
                            <tbody>
                                {users && users.map(customer =>
                                    <tr key={customer.id}>
                                        <td>{customer.first_name}</td>
                                        <td>{customer.last_name}</td>
                                        <td>{customer.email}</td>
                                        <td>{customer.phone}</td>
                                        <td>{customer.address}</td>
                                        <td>
                                            <div className="d-flex justify-content-between align-items-center">
                                                <div className="btn-group" style={{ marginBottom: "20px" }}>
                                                    <button className="btn btn-sm btn-outline-secondary" onClick={() => this.deleteCustomer(customer.id)}>Delete Customer</button>
                                                </div>
                                            </div>
                                        </td>
                                    </tr>
                                )}
                            </tbody>
                        </table>
                    </div>
                </div>
            </div>
        </div>
      </div>
    </div>
  );
};

export default Listing;
