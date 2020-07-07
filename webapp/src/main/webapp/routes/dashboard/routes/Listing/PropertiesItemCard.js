import React from "react";


function PropertiesItemCard({data}) {
  const {image, title, subTitle, name, date, isFeatured, prize, sqft, bedrooms, baths, area, more} = data;

  return (
    <div className="media jr-featured-item">
      {isFeatured === true ? <span color="orange"><span className="text-uppercase">featured</span></span> : null}
      <div className="jr-featured-thumb">
        <img className="rounded-lg" src={image} alt="..."/>
        <span className="jr-tag">Featured</span>
      </div>
      <div className="media-body jr-featured-content">
        <div className="jr-featured-content-left">

          <span className="jr-tag text-uppercase bg-info d-inline-block" color="#06BB8A">For Sale</span>
          <h3 className="mb-1">{title}</h3>

          <p className="text-grey mb-1">{subTitle}</p>

          <div className="d-flex flex-wrap mb-2">
            <p className="mr-3 mb-1"><span className="text-grey">Bedrooms:</span> {bedrooms}</p>
            <p className="mr-3 mb-1"><span className="text-grey">Baths:</span> {baths}</p>
            <p className="mr-3 mb-1"><span className="text-grey">Area:</span> {area}</p>
            <a className="text-grey text-underline" href="#/"> + {more} more</a>
          </div>
          <div className="d-flex flex-row">
            <p className="text-grey mb-1">
              <i className={`zmdi zmdi-account jr-fs-lg mr-2 d-inline-block align-middle`}/>{name}
            </p>
            <p className="text-grey ml-4 mb-1">
              <i className={`zmdi zmdi-calendar-alt jr-fs-lg mr-2 d-inline-block align-middle`}/>{date}
            </p>
          </div>
        </div>
        <div className="jr-featured-content-right">
          <div>
            <h2 className="mb-0 jr-font-weight-medium">{prize}</h2>
            <p className="text-grey jr-fs-sm">{sqft}</p>
          </div>
          <p className="text-primary mt-auto mb-0 pointer"><span>Check in detail</span> <i
            className={`zmdi zmdi-long-arrow-right jr-fs-xxl ml-2 d-inline-block align-middle`}/></p>
        </div>

      </div>
    </div>
  );
}

export default PropertiesItemCard;
