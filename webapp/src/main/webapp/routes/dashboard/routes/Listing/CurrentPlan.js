import React from "react";
import Widget from "components/Widget/index";
import Button from '@material-ui/core/Button';

const CurrentPlan = () => {

  return (
    <Widget>
      <h4>Your Current Plan</h4>
      <div className="jr-currentplan-row">
        <div className="jr-currentplan-col pb-xl-2">
          <h2 className="text-primary jr-fs-xlxl jr-font-weight-medium mb-2">$19<sub
            className="jr-fs-md">/month</sub></h2>
          <p className="mb-1"><span className="size-8 bg-dark rounded d-inline-block mr-1"/> Max
            listing items 2K</p>
          <p><span className="size-8 bg-dark rounded d-inline-block mr-1"/> Max agents - 10</p>
        </div>
        <div className="jr-currentplan-col jr-currentplan-right">
          <div className="jr-currentplan-right-content">
            <p className="text-red">Expires in 80 days</p>
            <Button variant="contained" className="jr-btn jr-btn-sm bg-success text-white">
              RENEW PLAN
            </Button>
            <span className="text-primary jr-font-weight-medium jr-fs-md pointer jr-oth-plans-down">Other plans <i
              className="zmdi zmdi-long-arrow-right jr-fs-lg ml-2 d-inline-block align-middle"/></span>
          </div>
        </div>
      </div>
    </Widget>
  );
};

export default CurrentPlan;
