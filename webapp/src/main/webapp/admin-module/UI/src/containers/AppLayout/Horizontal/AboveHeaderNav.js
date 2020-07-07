<<<<<<< HEAD
<<<<<<< HEAD
import React from "react";
import ColorOption from "containers/Customizer/ColorOption";
import { isIOS, isMobile } from "react-device-detect";
import TopNav from "./Header/TopNav";
import AboveNavHeader from "./Header/AboveNavHeader";

const AboveHeaderNav =(props)=> {

    if (isIOS && isMobile) {
      document.body.classList.add("ios-mobile-view-height");
    } else if (document.body.classList.contains("ios-mobile-view-height")) {
      document.body.classList.remove("ios-mobile-view-height");
    }

    return (
      <div className="app-container">
        <div className="app-main-container">
          <div className="app-header app-header-horizontal">
            <TopNav styleName="app-top-header"/>
            <AboveNavHeader/>
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

export default AboveHeaderNav;
=======
=======
>>>>>>> 4d2bbb99f7304fe93e114a6909260496de0e6fc0
import React from "react";
import ColorOption from "containers/Customizer/ColorOption";
import { isIOS, isMobile } from "react-device-detect";
import TopNav from "./Header/TopNav";
import AboveNavHeader from "./Header/AboveNavHeader";

const AboveHeaderNav =(props)=> {

    if (isIOS && isMobile) {
      document.body.classList.add("ios-mobile-view-height");
    } else if (document.body.classList.contains("ios-mobile-view-height")) {
      document.body.classList.remove("ios-mobile-view-height");
    }

    return (
      <div className="app-container">
        <div className="app-main-container">
          <div className="app-header app-header-horizontal">
            <TopNav styleName="app-top-header"/>
            <AboveNavHeader/>
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

export default AboveHeaderNav;
<<<<<<< HEAD
>>>>>>> 4d2bbb9... backbone for the dashboard
=======
>>>>>>> 4d2bbb99f7304fe93e114a6909260496de0e6fc0
