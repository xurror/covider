<<<<<<< HEAD
<<<<<<< HEAD
import React from 'react';

const WithIconTimeLineItem = ({styleName, color, timeLine, children}) => {
  const {time, title, description} = timeLine;
  return (
    <div className={`timeline-item timeline-time-item ${styleName}`}>
      <div className="timeline-time">{time}</div>
      <div className={`timeline-badge bg-${color}`}>{children}</div>
      <div className="timeline-panel">
        <h4 className={`timeline-tile text-${color}`}>{title}</h4>
        <p>{description}</p>
      </div>
    </div>
  )
};
=======
=======
>>>>>>> 4d2bbb99f7304fe93e114a6909260496de0e6fc0
import React from 'react';

const WithIconTimeLineItem = ({styleName, color, timeLine, children}) => {
  const {time, title, description} = timeLine;
  return (
    <div className={`timeline-item timeline-time-item ${styleName}`}>
      <div className="timeline-time">{time}</div>
      <div className={`timeline-badge bg-${color}`}>{children}</div>
      <div className="timeline-panel">
        <h4 className={`timeline-tile text-${color}`}>{title}</h4>
        <p>{description}</p>
      </div>
    </div>
  )
};
<<<<<<< HEAD
>>>>>>> 4d2bbb9... backbone for the dashboard
=======
>>>>>>> 4d2bbb99f7304fe93e114a6909260496de0e6fc0
export default WithIconTimeLineItem;