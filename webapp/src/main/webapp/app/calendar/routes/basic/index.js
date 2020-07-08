import React from 'react';
import {Calendar, momentLocalizer} from 'react-big-calendar'
import moment from 'moment'
import events from "../events";

const localizer = momentLocalizer(moment);

const Basic = (props) => {
  return (
    <div className="app-calendar animated slideInUpTiny animation-duration-3">
      <Calendar
        localizer={localizer}
        {...props}
        events={events}
        step={60}
        defaultDate={new Date(2015, 3, 1)}/>
    </div>
  )
};

export default Basic;
