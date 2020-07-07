import React from "react";
import {Area, AreaChart, ResponsiveContainer, XAxis} from "recharts";
import Widget from "components/Widget/index";

const data = [
  {name: '', pv: 200},
  {name: 'JAN', pv: 400},
  {name: 'FEB', pv: 150},
  {name: 'MAR', pv: 400},
  {name: 'APR', pv: 1000},
  {name: 'MAY', pv: 400},
  {name: 'JUNE', pv: 1200},
  {name: 'JULY', pv: 1000},
  {name: 'AUG', pv: 800},
  {name: 'SEP', pv: 750},
  {name: 'OCT', pv: 1500},
  {name: 'NOV', pv: 1000},
  {name: 'DEC', pv: 1500},
  {name: '', pv: 500},
  {name: '', pv: 1600},
];


const BalanceHistory = () => {

  return (
    <Widget styleName="jr-card-full">

      <div className="d-flex flex-row px-4 pt-3">
        <h4 className="mb-3">Balance History</h4>
      </div>

      <ResponsiveContainer width="100%" height={190}>
        <AreaChart data={data}
                   margin={{top: 0, right: 0, left: 0, bottom: 0}}>

          <XAxis dataKey="name"/>
          <defs>
            <linearGradient id="color15" x1="0" y1="0" x2="0" y2="1">
              <stop offset="5%" stopColor="#ffdfaf" stopOpacity={0.8}/>
              <stop offset="95%" stopColor="#ffffff" stopOpacity={0.8}/>
            </linearGradient>
          </defs>
          <Area dataKey='pv' strokeWidth={2} stackId="2" stroke='#ff9e10' fill="url(#color15)"
                fillOpacity={1}/>
        </AreaChart>
      </ResponsiveContainer>
    </Widget>
  );
};

export default BalanceHistory;
