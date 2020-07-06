<<<<<<< HEAD
<<<<<<< HEAD
import React from 'react';
import MailListItem from './MailListItem';
import CustomScrollbars from 'util/CustomScrollbars';

const MailList = ({mails, onMailSelect, onMailChecked, onStartSelect, width}) => {
  return (
    <div className="module-list mail-list">
      <CustomScrollbars className="module-list-scroll scrollbar"
                        style={{height: width >= 1200 ? 'calc(100vh - 259px)' : 'calc(100vh - 238px)'}}>
        {mails.map((mail, index) =>
          <MailListItem key={index} mail={mail} onMailSelect={onMailSelect} onMailChecked={onMailChecked}
                        onStartSelect={onStartSelect}/>
        )}
      </CustomScrollbars>
    </div>
  )
};

=======
=======
>>>>>>> 4d2bbb99f7304fe93e114a6909260496de0e6fc0
import React from 'react';
import MailListItem from './MailListItem';
import CustomScrollbars from 'util/CustomScrollbars';

const MailList = ({mails, onMailSelect, onMailChecked, onStartSelect, width}) => {
  return (
    <div className="module-list mail-list">
      <CustomScrollbars className="module-list-scroll scrollbar"
                        style={{height: width >= 1200 ? 'calc(100vh - 259px)' : 'calc(100vh - 238px)'}}>
        {mails.map((mail, index) =>
          <MailListItem key={index} mail={mail} onMailSelect={onMailSelect} onMailChecked={onMailChecked}
                        onStartSelect={onStartSelect}/>
        )}
      </CustomScrollbars>
    </div>
  )
};

<<<<<<< HEAD
>>>>>>> 4d2bbb9... backbone for the dashboard
=======
>>>>>>> 4d2bbb99f7304fe93e114a6909260496de0e6fc0
export default MailList;