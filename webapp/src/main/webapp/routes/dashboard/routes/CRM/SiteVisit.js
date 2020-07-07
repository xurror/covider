import React from "react";
import {Area, AreaChart, ResponsiveContainer, Tooltip} from "recharts";
import {siteVisit} from "./data";

const SiteVisit = () => (
  <div className="pr-xl-5 pt-xl-2">
    <h6 className="text-uppercase mb-2 mb-lg-4">Site Visits</h6>
    <ResponsiveContainer width="100%" height={140}>
      <AreaChart data={siteVisit}
                 margin={{top: 10, right: 0, left: -20, bottom: 0}}>
        <Tooltip/>
        <Area type='monotone' dataKey='uv' fillOpacity={1} stroke='#5061bc' fill='#5061bc'/>
        <Area type='monotone' dataKey='pv' stroke='#e3458a' fill='#e3458a'/>
      </AreaChart>
    </ResponsiveContainer>
  </div>
);

export default SiteVisit;

