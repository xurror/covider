import React from "react";

import Widget from "components/Widget/index";

const ChartCard = ({prize, title, children, styleName, desc, icon}) => {
  return (
    <Widget styleName="jr-card-full">

      <div className="jr-actchart px-3 pt-3">
        <div className="d-flex">
          <h2 className="mr-2 mb-0 jr-fs-xxl jr-font-weight-medium">{prize}</h2>
          <h5 className={`mb-0 pt-2 jr-chart-${styleName}`}>{title}% <i className="zmdi zmdi-caret-up"/>
          </h5>
          <i className={`zmdi zmdi-${icon} zmdi-hc-fw zmdi-hc-2x`}/>
        </div>
        <p className="mb-0 jr-fs-11 text-grey">{desc}</p>
      </div>
      {children}
    </Widget>
  );
};

export default ChartCard;
