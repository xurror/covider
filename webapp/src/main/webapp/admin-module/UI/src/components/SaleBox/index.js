<<<<<<< HEAD
<<<<<<< HEAD
import React from 'react';
import {ResponsiveContainer} from 'recharts';

const SaleBox = ({styleName, heading, title, detail, children, subHeadingColor}) => {
  if (!styleName)
    styleName = "";
  if (!subHeadingColor)
    subHeadingColor = "";
  return (
    <div className={`jr-card ${styleName}`}>
      {heading && <div className="jr-card-header">
        <h3 className="mb-0">{heading}</h3>
      </div>}
      <div className="row align-items-center">
        <div className="col-5">
          <h1 className="chart-f30 font-weight-light mb-1">{title}</h1>
          <span className={`sub-heading ${subHeadingColor}`}>{detail}</span>
        </div>
        <div className="col-7">
          <ResponsiveContainer height={95}>
            {children}
          </ResponsiveContainer>
        </div>
      </div>
    </div>
  );
};

=======
=======
>>>>>>> 4d2bbb99f7304fe93e114a6909260496de0e6fc0
import React from 'react';
import {ResponsiveContainer} from 'recharts';

const SaleBox = ({styleName, heading, title, detail, children, subHeadingColor}) => {
  if (!styleName)
    styleName = "";
  if (!subHeadingColor)
    subHeadingColor = "";
  return (
    <div className={`jr-card ${styleName}`}>
      {heading && <div className="jr-card-header">
        <h3 className="mb-0">{heading}</h3>
      </div>}
      <div className="row align-items-center">
        <div className="col-5">
          <h1 className="chart-f30 font-weight-light mb-1">{title}</h1>
          <span className={`sub-heading ${subHeadingColor}`}>{detail}</span>
        </div>
        <div className="col-7">
          <ResponsiveContainer height={95}>
            {children}
          </ResponsiveContainer>
        </div>
      </div>
    </div>
  );
};

<<<<<<< HEAD
>>>>>>> 4d2bbb9... backbone for the dashboard
=======
>>>>>>> 4d2bbb99f7304fe93e114a6909260496de0e6fc0
export default SaleBox;