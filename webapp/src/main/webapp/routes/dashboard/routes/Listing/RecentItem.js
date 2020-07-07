import React from "react";

const RecentItem = ({data}) => {

  const {id, title, avatar, description, status} = data;
  return (
    <div className="jr-media jr-flex-nowrap">
      <img className="jr-mr-3 jr-size-60 rounded-xl" src={avatar}/>
      <div className="jr-media-body">
        <div className="">
          <h4 className="jr-text-truncate jr-task-item-title">{title}</h4>
          <p className="jr-text-grey jr-fs-sm jr-mb-0">{description}</p>
        </div>
      </div>
    </div>

  );
};

export default RecentItem;
