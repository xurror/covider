<<<<<<< HEAD
<<<<<<< HEAD
import React from "react";
import Widget from "components/Widget/index";

const Photos = ({photoList}) => {

  return (
    <Widget title="Photos" styleName="jr-card-profile-sm">
      <div className="pt-2">
        <ul className="jr-gallery-list">
          {photoList.map((photo, index) =>
            <li key={index}>
              <img alt="..." src={photo.image}/>
            </li>
          )}
        </ul>
        <span className="text-primary jr-fs-md pointer jr-d-block">Go to gallery <i
          className={`zmdi zmdi-long-arrow-right jr-fs-xxl ml-2 d-inline-flex align-middle`}/></span>
      </div>
    </Widget>
  )
}
export default Photos
=======
=======
>>>>>>> 4d2bbb99f7304fe93e114a6909260496de0e6fc0
import React from "react";
import Widget from "components/Widget/index";

const Photos = ({photoList}) => {

  return (
    <Widget title="Photos" styleName="jr-card-profile-sm">
      <div className="pt-2">
        <ul className="jr-gallery-list">
          {photoList.map((photo, index) =>
            <li key={index}>
              <img alt="..." src={photo.image}/>
            </li>
          )}
        </ul>
        <span className="text-primary jr-fs-md pointer jr-d-block">Go to gallery <i
          className={`zmdi zmdi-long-arrow-right jr-fs-xxl ml-2 d-inline-flex align-middle`}/></span>
      </div>
    </Widget>
  )
}
export default Photos
<<<<<<< HEAD
>>>>>>> 4d2bbb9... backbone for the dashboard
=======
>>>>>>> 4d2bbb99f7304fe93e114a6909260496de0e6fc0
