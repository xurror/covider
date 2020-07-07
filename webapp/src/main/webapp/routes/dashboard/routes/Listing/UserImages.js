import React from "react";

import Aux from "util/Auxiliary.js"

const userImageList = [
  {
    id: 1,
    image: "https://via.placeholder.com/150x150",
    name: 'Chelsea Johns',
    rating: '5.0',
    deals: '27 Deals'
  },
  {
    id: 2,
    image: "https://via.placeholder.com/150x150",
    name: 'Ken Ramirez',
    rating: '4.5',
    deals: '21 Deals'
  },
  {
    id: 3,
    image: "https://via.placeholder.com/150x150",
    name: 'Ken Ramirez',
    rating: '5.0',
    deals: '27 Deals'
  },
  {
    id: 4,
    image: "https://via.placeholder.com/150x150",
    name: 'Chelsea Johns',
    rating: '5.0',
    deals: '27 Deals'
  },
  {
    id: 5,
    image: "https://via.placeholder.com/150x150",
    name: 'Chelsea Johns',
    rating: '5.0',
    deals: '27 Deals'
  },
]


const UserImages = () => {
  return (
    <Aux>
      <h2 className="jr-entry-title d-flex flex-row">Popular Agents
        <span className="text-primary jr-font-weight-medium jr-fs-md pointer ml-auto d-none d-sm-block">Go to agents list <i
          className="zmdi zmdi-long-arrow-right jr-fs-xxl ml-2 d-inline-block align-middle"/></span></h2>

      <ul className="jr-agents-list">
        {userImageList.map((user, index) =>
          <li key={index}>
            <div className="jr-profileon">
              <div className="jr-profileon-thumb"><img alt="..." src={user.image}/></div>
              <div className="jr-profileon-content">
                <h5 className="mb-0 text-truncate">{user.name}</h5>
                <p className="mb-0 jr-fs-sm text-truncate"><i className={`zmdi zmdi-star text-orange`}/> {user.rating}
                  <span>|</span> {user.deals}
                </p>
              </div>
            </div>
          </li>
        )
        }
      </ul>
      <span className="text-primary jr-font-weight-medium jr-fs-md pointer mb-3 d-block d-sm-none">Go to agents list <i
        className="icon icon-long-arrow-right jr-fs-xxl ml-2 d-inline-block align-middle"/></span>

    </Aux>
  );
};

export default UserImages;
