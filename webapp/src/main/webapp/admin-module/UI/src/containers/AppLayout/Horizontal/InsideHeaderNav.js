<<<<<<< HEAD
<<<<<<< HEAD
import React from "react";
import { withRouter } from "react-router-dom";
import ColorOption from "containers/Customizer/ColorOption";
import { isIOS, isMobile } from "react-device-detect";
import InsideNavHeader from "./Header/InsideNavHeader";

const Horizontal =(props)=> {

    if (isIOS && isMobile) {
      document.body.classList.add("ios-mobile-view-height");
    } else if (document.body.classList.contains("ios-mobile-view-height")) {
      document.body.classList.remove("ios-mobile-view-height");
    }

    return (
      <div className={`app-container `}>
        <div className="app-main-container">
          <div className="app-header app-header-horizontal">
            <InsideNavHeader/>
          </div>

          <main className="app-main-content-wrapper">
            <div className="app-main-content">
              {props.children}
            </div>
          </main>
        </div>
        <ColorOption/>
      </div>
    );
  };

export default withRouter(Horizontal);
=======
=======
>>>>>>> 4d2bbb99f7304fe93e114a6909260496de0e6fc0
import React from "react";
import { withRouter } from "react-router-dom";
import ColorOption from "containers/Customizer/ColorOption";
import { isIOS, isMobile } from "react-device-detect";
import InsideNavHeader from "./Header/InsideNavHeader";

const Horizontal =(props)=> {

    if (isIOS && isMobile) {
      document.body.classList.add("ios-mobile-view-height");
    } else if (document.body.classList.contains("ios-mobile-view-height")) {
      document.body.classList.remove("ios-mobile-view-height");
    }

    return (
      <div className={`app-container `}>
        <div className="app-main-container">
          <div className="app-header app-header-horizontal">
            <InsideNavHeader/>
          </div>

          <main className="app-main-content-wrapper">
            <div className="app-main-content">
              {props.children}
            </div>
          </main>
        </div>
        <ColorOption/>
      </div>
    );
  };

export default withRouter(Horizontal);
<<<<<<< HEAD
>>>>>>> 4d2bbb9... backbone for the dashboard
=======
>>>>>>> 4d2bbb99f7304fe93e114a6909260496de0e6fc0
