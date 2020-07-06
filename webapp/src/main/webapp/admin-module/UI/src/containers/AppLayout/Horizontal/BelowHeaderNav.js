import React from "react";
import ColorOption from "containers/Customizer/ColorOption";
import { isIOS, isMobile } from "react-device-detect";
import BelowNavHeader from "./Header/BelowNavHeader";
import TopNav from "./Header/TopNav";

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
            <BelowNavHeader/>
            <TopNav/>
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
