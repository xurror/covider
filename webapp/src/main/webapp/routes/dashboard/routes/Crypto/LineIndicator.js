import React from "react";
import PropTypes from "prop-types";

import Aux from "util/Auxiliary";

const LineIndicator = ({title, title2, width, value, color}) => {

  return (
    <Aux>
      <div className="d-flex flex-row">
        <p className="mr-1">{title}</p>
        <p className="text-grey">| {title2}</p>
      </div>
      <div className="jr-line-indi-info">
        <div className={`jr-line-indi bg-${color}`} style={{
          width: Number.parseInt(width) * 3
        }}/>
        <span className="jr-line-indi-count ml-2">{value}</span>
      </div>
    </Aux>
  );
};

export default LineIndicator;

LineIndicator.propTypes = {
  title: PropTypes.string.isRequired,
  width: PropTypes.string.isRequired,
  value: PropTypes.string.isRequired,
  color: PropTypes.string.isRequired,
};
