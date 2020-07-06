<<<<<<< HEAD
import React from "react";
import Auxiliary from "util/Auxiliary";


const GreenStepItem = ({data}) => {
  const {title, subTitle, desc} = data;
  return (

    <Auxiliary>
      <h3>{title}</h3>
      <p className="text-grey">{subTitle}</p>
      <p>{desc}</p>
    </Auxiliary>
  );
};

export default GreenStepItem;
=======
import React from "react";
import Auxiliary from "util/Auxiliary";


const GreenStepItem = ({data}) => {
  const {title, subTitle, desc} = data;
  return (

    <Auxiliary>
      <h3>{title}</h3>
      <p className="text-grey">{subTitle}</p>
      <p>{desc}</p>
    </Auxiliary>
  );
};

export default GreenStepItem;
>>>>>>> 4d2bbb9... backbone for the dashboard
