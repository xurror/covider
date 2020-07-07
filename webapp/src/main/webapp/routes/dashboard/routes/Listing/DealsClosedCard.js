import React from "react";
import {Bar, BarChart, ResponsiveContainer, XAxis} from "recharts";
import Widget from "components/Widget/index";

const data = [
  {name: 'JAN', uv: 200, pv: 600,},
  {name: 'FEB', uv: 500, pv: 900,},
  {name: 'MAR', uv: 700, pv: 1200,},
  {name: 'APR', uv: 800, pv: 1300,},
  {name: 'MAY', uv: 700, pv: 1200,},
  {name: 'JUN', uv: 500, pv: 900,},
  {name: 'JUL', uv: 600, pv: 200,},
  {name: 'AUG', uv: 200, pv: 800,},
  {name: 'SEP', uv: 400, pv: 400,},
  {name: 'OCT', uv: 400, pv: 500,},
  {name: 'NOV', uv: 400, pv: 1200,},
  {name: 'DEC', uv: 200, pv: 800,},
];

const DealsClosedCard = () => {

  return (
    <Widget>
      <div className="jr-dealclose-header">
        <div>
          <h4 className="mb-0">927 Deals Closed</h4>
          <p className="text-grey mb-1">This year</p>
        </div>
        <div className="jr-dealclose-header-right">
          <p className="mb-2"><span className="size-8 bg-secondary rounded-circle d-inline-block mr-1"/> Queries</p>
          <p className="ml-2 mb-2"><span className="size-8 bg-primary rounded-circle d-inline-block mr-1"/> Closed Deals
          </p>
        </div>
      </div>
      <ResponsiveContainer width="100%" height={120}>
        <BarChart data={data}
                  margin={{top: 0, right: 0, left: 0, bottom: 0}}>
          <XAxis dataKey="name"/>
          <Bar dataKey="uv" stackId="a" fill="#3f51b5" barSize={8}/>
          <Bar dataKey="pv" stackId="a" fill="#ff4081" barSize={8}/>
        </BarChart>
      </ResponsiveContainer>
    </Widget>
  );
};

export default DealsClosedCard;
