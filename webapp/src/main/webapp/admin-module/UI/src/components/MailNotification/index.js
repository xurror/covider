<<<<<<< HEAD
<<<<<<< HEAD
import React from 'react';

import NotificationItem from './NotificationItem';
import {notifications} from './data';
import CustomScrollbars from 'util/CustomScrollbars';

const MailNotification = () => {

  return (
    <CustomScrollbars className="messages-list scrollbar" style={{height: 280}}>
      <ul className="list-unstyled">
        {notifications.map((notification, index) => <NotificationItem key={index}
                                                                      notification={notification}/>)}
      </ul>
    </CustomScrollbars>
  )
};

export default MailNotification;

=======
=======
>>>>>>> 4d2bbb99f7304fe93e114a6909260496de0e6fc0
import React from 'react';

import NotificationItem from './NotificationItem';
import {notifications} from './data';
import CustomScrollbars from 'util/CustomScrollbars';

const MailNotification = () => {

  return (
    <CustomScrollbars className="messages-list scrollbar" style={{height: 280}}>
      <ul className="list-unstyled">
        {notifications.map((notification, index) => <NotificationItem key={index}
                                                                      notification={notification}/>)}
      </ul>
    </CustomScrollbars>
  )
};

export default MailNotification;

<<<<<<< HEAD
>>>>>>> 4d2bbb9... backbone for the dashboard
=======
>>>>>>> 4d2bbb99f7304fe93e114a6909260496de0e6fc0
