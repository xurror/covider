<<<<<<< HEAD
<<<<<<< HEAD
import React from "react";
import Auxiliary from "util/Auxiliary";


const AboutItem = ({data}) => {
  const {title, icon, desc, userList} = data;
  return (
    <Auxiliary>
      <div className="media flex-nowrap mt-3 mt-lg-4 mb-2">
        <div className="mr-3">
          <i className={`zmdi zmdi-${icon} jr-fs-xlxl text-orange`}/>
        </div>
        <div className="media-body">
          <h6 className="mb-1 text-grey">{title}</h6>
          {userList === '' ? null : userList}
          {desc === '' ? null : <p className="mb-0">{desc}</p>}
        </div>
      </div>
    </Auxiliary>
  );
};

export default AboutItem;
=======
=======
>>>>>>> 4d2bbb99f7304fe93e114a6909260496de0e6fc0
import React from "react";
import Auxiliary from "util/Auxiliary";


const AboutItem = ({data}) => {
  const {title, icon, desc, userList} = data;
  return (
    <Auxiliary>
      <div className="media flex-nowrap mt-3 mt-lg-4 mb-2">
        <div className="mr-3">
          <i className={`zmdi zmdi-${icon} jr-fs-xlxl text-orange`}/>
        </div>
        <div className="media-body">
          <h6 className="mb-1 text-grey">{title}</h6>
          {userList === '' ? null : userList}
          {desc === '' ? null : <p className="mb-0">{desc}</p>}
        </div>
      </div>
    </Auxiliary>
  );
};

export default AboutItem;
<<<<<<< HEAD
>>>>>>> 4d2bbb9... backbone for the dashboard
=======
>>>>>>> 4d2bbb99f7304fe93e114a6909260496de0e6fc0
