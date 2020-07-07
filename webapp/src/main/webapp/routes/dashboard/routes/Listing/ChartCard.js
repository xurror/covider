import React,{useState} from "react";

const ChartCard =(props)=> {

  const {chartProperties, children} = props;
  const [isHide,setIsHide]=useState(false);



const  handleToggle =()=> {
  setIsHide(!isHide)
  };

    const {prize, title, styleName, desc, bgColor, percent} = chartProperties;
    return (
      <div className="jr-card jr-card-full">
        <div
          className={isHide === true ? `jr-fillchart bg-${bgColor} jr-fillchart-nocontent` : `jr-fillchart bg-${bgColor} jr-overlay-fillchart`}>
          <div className="card-title mb-3">{title}</div>
          {children}
          <div className="jr-fillchart-content">
            <div className="card-title mb-4">{title}</div>
            <h2 className="mb-2 jr-fs-xl jr-font-weight-medium">{prize}</h2>
            {percent > 0}
            <p className="mb-0 jr-fs-sm"><span
              className={`jr-font-weight-medium jr-fs-md jr-chart-${styleName}`}>{percent}
              {percent > 0 ? <i className="zmdi zmdi-caret-down jr-fs-sm"/> : null}</span>{desc}</p>
          </div>
          <div className="jr-fillchart-btn-close" onClick={handleToggle}><i
            className="zmdi zmdi-close"/></div>
          <div className="jr-fillchart-btn" onClick={handleToggle}><i
            className={`zmdi zmdi-equalizer jr-fs-lg`}/>
          </div>
        </div>
      </div>
    );
};

export default ChartCard;
