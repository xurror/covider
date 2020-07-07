import React from "react";

export const growthData = [
  {name: 'Page A', pv: 1200},
  {name: 'Page B', pv: 600},
  {name: 'Page C', pv: 1200},
  {name: 'Page D', pv: 600},
  {name: 'Page D', pv: 900}

];

export const trafficData = [
  {name: 'Page A', pv: 200},
  {name: 'Page B', pv: 900},
  {name: 'Page C', pv: 600},
  {name: 'Page D', pv: 1600},
  {name: 'Page D', pv: 900}
];

export const revenueData = [
  {name: 'Page A', pv: 850},
  {name: 'Page B', pv: 300},
  {name: 'Page C', pv: 1100},
  {name: 'Page D', pv: 600},
];

export const increamentData = [
  {name: 'Page A', pv: 200},
  {name: 'Page B', pv: 1200},
  {name: 'Page C', pv: 600},
  {name: 'Page D', pv: 1600},
  {name: 'Page D', pv: 1000},
  {name: 'Page H', pv: 2260},
  {name: 'Page K', pv: 800},
];

export const lineData = [
  {name: 'Page A', pv: 200},
  {name: 'Page B', pv: 1100},
  {name: 'Page C', pv: 800},
  {name: 'Page D', pv: 1700},
  {name: 'Page D', pv: 600},
  {name: 'Page D', pv: 1800},
  {name: 'Page D', pv: 600},
];
export const recentActivity = [
  {
    id: 1,
    day: 'Today',
    tasks: [
      {
        id: 1,
        name: 'Mila Alba',
        title: [<span className="jr-link">Mila Alba</span>, ' left a 5 star review on ',
          <span className="jr-link">Albama’s House</span>],
        avatar: "https://via.placeholder.com/150x150",
        imageList: [],
      },
      {
        id: 2,
        name: 'Bob Builder',
        title: ['Callback request from ', <span className="jr-link">Bob Builder</span>, ' for the property ',
          <span className="jr-link">Dimitri House</span>],
        avatar: "https://via.placeholder.com/150x150",
        imageList: [],
      },
      {
        id: 3,
        name: 'Tom Moody',
        title: ['Congratulations to ', <span className="jr-link">Tom Moody</span>,
          ' for joining 10+ club '],
        avatar: "https://via.placeholder.com/150x150",
        imageList: [],
      },
      {
        id: 4,
        name: 'Norman Dolphi',
        title: ['Norman Dolphi is looking for a house in New Jersy, USA'],
        avatar: '',
        imageList: [],
      }
    ]
  },
  {
    id: 2,
    day: 'Yesterday',
    tasks: [
      {
        id: 5,
        name: 'Kily Johns',
        title: ['Agent ',
          <span className="jr-link">Kily Johns</span>, ' has added 7 new photos to the property ',
          <span className="jr-link">Albama’s House</span>],
        avatar: '',
        imageList: ["https://via.placeholder.com/150x150", "https://via.placeholder.com/150x150", "https://via.placeholder.com/150x150"],
      },
      {
        id: 6,
        name: 'Tom Moody',
        title: ['Welcome to a new agent ', <span className="jr-link">Tom Moody in the Company</span>],
        avatar: "https://via.placeholder.com/150x150",
        imageList: [],
      },
      {
        id: 7,
        name: 'Oliver Shorter',
        title: [<span className="jr-link">Oliver Shorter</span>, ' is looking for an office space in ',
          <span className="jr-link">Colorado, USA</span>],
        avatar: "https://via.placeholder.com/150x150",
        imageList: [],
      }
    ]
  }];
