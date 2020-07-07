import React from "react";

import LineIndicator from "./LineIndicator";

const SiteAudience = () => {

  return (
    <div className="pt-xl-2">
      <h6 className="text-uppercase mb-2 mb-sm-4">Site audience</h6>
      <ul className="jr-line-indicator jr-fs-sm">
        <li>
          <LineIndicator width="78%" title="Male" title2="8.74" color="primary" value="56%"/>
        </li>
        <li>
          <LineIndicator width="18%" title="Female" title2="1.23" color="pink" value="42%"/>
        </li>
        <li>
          <LineIndicator width="4%" title="Others" title2="0.71" color="orange" value="2%"/>
        </li>
      </ul>
    </div>
  )
};
export default SiteAudience;
