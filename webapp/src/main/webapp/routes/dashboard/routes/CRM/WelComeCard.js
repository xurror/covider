import React from "react";

const WelComeCard = () => {

  return (
    <div className="jr-wel-ema pt-xl-2">
      <h1 className="mb-3">Welcome Ema!</h1>
      <p className="jr-fs-sm text-uppercase">You Have</p>
      <ul className="list-unstyled">
        <li className="mb-1">
          <i className="zmdi zmdi-comment-text zmdi-hc-fw zmdi-hc-lg mr-2"/>
          <span>5 Unread messages</span>
        </li>
        <li className="mb-1">
          <i className="zmdi zmdi-email zmdi-hc-fw zmdi-hc-lg mr-2"/>
          <span>2 Pending invitations</span>
        </li>
        <li className="mb-1">
          <i className="zmdi zmdi-file-plus zmdi-hc-fw zmdi-hc-lg mr-2"/>
          <span>7 Due tasks</span>
        </li>
        <li className="mb-1">
          <i className="zmdi zmdi-notifications-none zmdi-hc-fw zmdi-hc-lg mr-2"/>
          <span>3 Other notifications</span>
        </li>
      </ul>
    </div>
  );
};

export default WelComeCard;
