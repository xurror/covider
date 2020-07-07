import React, {useState} from 'react';
import {Calendar, momentLocalizer} from 'react-big-calendar'
import moment from 'moment'
import events from "../events";

const localizer = momentLocalizer(moment);


const Cultures =()=> {
  const [culture,setCulture]=useState('fr');

    let cultures = ['en', 'en-GB', 'es', 'fr', 'ar-AE'];
    let rtl = culture === 'ar-AE';

    return (
      <div className="app-calendar app-cul-calendar animated slideInUpTiny animation-duration-3">
        <h3 className="callout">
          <label>Select a Culture</label>
          {' '}
          <select
            className='form-control'
            style={{width: 200, display: 'inline-block'}}
            defaultValue={'fr'}
            onChange={e => setCulture(e.target.value)}
          >
            {
              cultures.map((c, idx) =>
                <option key={idx} value={c}>{c}</option>
              )
            }
          </select>
        </h3>
        <Calendar
          localizer={localizer}
          rtl={rtl}
          events={events}
          // culture={this.state.culture}
          defaultDate={new Date(2015, 3, 1)}
        />
      </div>
    )
  }

export default Cultures;
