<<<<<<< HEAD
<<<<<<< HEAD
import React from "react";
import AppLayouts from "./AppLayouts";
import Routes from "../../app/routes";
import {useSelector} from "react-redux";

const AppLayout = () => {

  const horizontalNavPosition = useSelector(({settings}) => settings.horizontalNavPosition);
  const navigationStyle = useSelector(({settings}) => settings.navigationStyle);
  const onGetLayout = (layout) => {
    switch (layout) {
      case "inside_the_header":
        return "InsideHeaderNav";

      case "above_the_header":
        return "AboveHeaderNav";

      case "below_the_header":
        return "BelowHeaderNav";
      default:
        return "Vertical";
    }
  };

  const Layout = AppLayouts[navigationStyle === "vertical_navigation" ? "Vertical" : onGetLayout(horizontalNavPosition)];
    return (
      <Layout>
        <Routes/>
      </Layout>
    );
};

export default AppLayout;
=======
=======
>>>>>>> 4d2bbb99f7304fe93e114a6909260496de0e6fc0
import React from "react";
import AppLayouts from "./AppLayouts";
import Routes from "../../app/routes";
import {useSelector} from "react-redux";

const AppLayout = () => {

  const horizontalNavPosition = useSelector(({settings}) => settings.horizontalNavPosition);
  const navigationStyle = useSelector(({settings}) => settings.navigationStyle);
  const onGetLayout = (layout) => {
    switch (layout) {
      case "inside_the_header":
        return "InsideHeaderNav";

      case "above_the_header":
        return "AboveHeaderNav";

      case "below_the_header":
        return "BelowHeaderNav";
      default:
        return "Vertical";
    }
  };

  const Layout = AppLayouts[navigationStyle === "vertical_navigation" ? "Vertical" : onGetLayout(horizontalNavPosition)];
    return (
      <Layout>
        <Routes/>
      </Layout>
    );
};

export default AppLayout;
<<<<<<< HEAD
>>>>>>> 4d2bbb9... backbone for the dashboard
=======
>>>>>>> 4d2bbb99f7304fe93e114a6909260496de0e6fc0
