<<<<<<< HEAD
import React, {useState} from "react";

import Slider from "react-slick";
import "slick-carousel/slick/slick.css";
import "slick-carousel/slick/slick-theme.css";

import {greenStepList} from "./data"
import GreenStepItem from "./GreenStepItem";
import Widget from "components/Widget/index";

const GreenStepCard = () => {

  const [image, setImage] = useState(greenStepList[1].image);
  const [loading, setLoading] = useState();

  const settings = {
    arrows: false,
    dots: true,
    infinite: true,
    speed: 500,
    marginLeft: 10,
    marginRight: 10,
    slidesToShow: 1,
    slidesToScroll: 1
  };

  return (
    <Widget styleName="jr-card-full">
      <div className="row">
        <div className="col-xl-6 col-lg-6 col-md-6 col-sm-6 col-12">
          <div className="jr-slick-slider-lt-thumb"><img
            className={loading ? 'fadeout img-fluid' : 'fadein img-fluid'} src={image}
            alt="..."/></div>
        </div>
        <div className="col-xl-6 col-lg-6 col-md-6 col-sm-6 col-12">
          <Slider className="jr-slick-slider jr-slick-slider-dot-top" {...settings}
                  afterChange={(index) => {
                    setImage(greenStepList[index].image);
                    setLoading(false);
                  }}
                  beforeChange={(oldIndex, newIndex) => {
                    setLoading(true);
                  }}>
            {greenStepList.map((data, index) =>
              <GreenStepItem key={index} data={data}/>)
            }
          </Slider>
        </div>
      </div>
    </Widget>
  );
};

export default GreenStepCard;
=======
import React, {useState} from "react";

import Slider from "react-slick";
import "slick-carousel/slick/slick.css";
import "slick-carousel/slick/slick-theme.css";

import {greenStepList} from "./data"
import GreenStepItem from "./GreenStepItem";
import Widget from "components/Widget/index";

const GreenStepCard = () => {

  const [image, setImage] = useState(greenStepList[1].image);
  const [loading, setLoading] = useState();

  const settings = {
    arrows: false,
    dots: true,
    infinite: true,
    speed: 500,
    marginLeft: 10,
    marginRight: 10,
    slidesToShow: 1,
    slidesToScroll: 1
  };

  return (
    <Widget styleName="jr-card-full">
      <div className="row">
        <div className="col-xl-6 col-lg-6 col-md-6 col-sm-6 col-12">
          <div className="jr-slick-slider-lt-thumb"><img
            className={loading ? 'fadeout img-fluid' : 'fadein img-fluid'} src={image}
            alt="..."/></div>
        </div>
        <div className="col-xl-6 col-lg-6 col-md-6 col-sm-6 col-12">
          <Slider className="jr-slick-slider jr-slick-slider-dot-top" {...settings}
                  afterChange={(index) => {
                    setImage(greenStepList[index].image);
                    setLoading(false);
                  }}
                  beforeChange={(oldIndex, newIndex) => {
                    setLoading(true);
                  }}>
            {greenStepList.map((data, index) =>
              <GreenStepItem key={index} data={data}/>)
            }
          </Slider>
        </div>
      </div>
    </Widget>
  );
};

export default GreenStepCard;
>>>>>>> 4d2bbb9... backbone for the dashboard
