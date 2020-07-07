import React from 'react';

export const data = [
  {name: 'Let A', uv: 0, pv: 0, amt: 20},
  {name: 'Let B', uv: 30, pv: 13, amt: 21},
  {name: 'Let C', uv: 20, pv: 98, amt: 29},
  {name: 'Let D', uv: 27, pv: 39, amt: 20},
  {name: 'Let E', uv: 18, pv: 48, amt: 28},
  {name: 'Let F', uv: 23, pv: 38, amt: 20},
  {name: 'Let G', uv: 0, pv: 0, amt: 20},
];
export const chartData = [
  {name: 'J', amt: 600},
  {name: 'F', amt: 900},
  {name: 'M', amt: 1200},
  {name: 'A', amt: 800},
  {name: 'M', amt: 1100},
  {name: 'J', amt: 800},
  {name: 'J', amt: 1000},
  {name: 'A', amt: 1400},
];
export const lineChartData = [
  {name: 'J', amt: 1400},
  {name: 'F', amt: 210},
  {name: 'M', amt: 1200},
  {name: 'A', amt: 590},
  {name: 'M', amt: 1500},
];
export const pieChartData = [
  {name: 'J', amt: 24},
  {name: 'F', amt: 18},
  {name: 'M', amt: 22},
  {name: 'A', amt: 17},
  {name: 'M', amt: 25},
  {name: 'J', amt: 12},
  {name: 'J', amt: 21},
];

export const authors = [
  {
    id: 1,
    image: "https://via.placeholder.com/150x150",
    name: "John Smith",
    about: "500K+ readers",
    detail: "45 ARTICLES",
    color: "info"
  },
  {
    id: 2,
    image: "https://via.placeholder.com/150x150",
    name: "Alex Dolgove",
    about: "800K+ readers",
    detail: "73 ARTICLES",
    color: "pink"
  },
  {
    id: 3,
    image: "https://via.placeholder.com/150x150",
    name: "Domnic Brown",
    about: "50K+ readers",
    detail: "13 ARTICLES",
    color: "orange"
  }

];

export const article = [
  {
    image: "https://via.placeholder.com/500x350",
    title: "There are many variations of passages of",
    description: "25th Aug 2017"
  },
  {
    image: "https://via.placeholder.com/500x350",
    title: "Contrary to popular belief, Lorem Ipsum",
    description: "29th Aug 2017"
  },
  {
    image: "https://via.placeholder.com/500x350",
    title: "Various versions have evolved over the years",
    description: "5th Sept 2017"
  },
  {
    image: "https://via.placeholder.com/500x350",
    title: "All the Lorem Ipsum generators on the ",
    description: "25th sept 2017"
  },
];

export const appNotification = [

  {
    id: 1,
    title: "NEW ORDER",
    desc: [<span key={1}>Stella</span>, " has placed an order for 3 items of $234.0"],
    image: "https://via.placeholder.com/150x150"
  },
  {
    id: 2,
    title: "Support ticket",
    desc: [<span className="jr-link" key={2}>Jeson Born</span>, " raised a support ticket"],
    image: "https://via.placeholder.com/150x150"
  },
  {
    id: 3,
    title: "new enquiry",
    desc: [<span className="jr-link" key={3}>Guptil</span>, " has placed an order for 5 items of $425.0"],
    image: "https://via.placeholder.com/150x150"
  },
];

export const announcementsNotification = [
  {
    id: 4,
    title: "NEW ORDER",
    desc: [<span className="jr-link" key={4}>Alex Dolgove</span>, " raised a support ticket"],
    image: "https://via.placeholder.com/150x150"
  },
  {
    id: 5,
    title: "Support ticket",
    desc: [<span className="jr-link" key={5}>Jeson Born</span>, " raised a support ticket"],
    image: "https://via.placeholder.com/150x150"
  },
  {
    id: 6,
    title: "NEW ORDER",
    desc: [<span className="jr-link" key={6}>Stella</span>, " has placed an order for 3 items of $234.0"],
    image: "https://via.placeholder.com/150x150"
  },
];

export const marketingData = [
  {
    id: 1,
    name: 'Facebook Ads',
    desc: '63 Likes, 387 Shares',
    icon: 'facebook',
    color: 'bg-indigo lighten-1',
    budget: 570,
    growth: 20
  },
  {
    id: 2,
    name: 'Twitter Ads',
    desc: '43 Likes, 545 Shares',
    icon: 'twitter',
    color: 'bg-light-blue accent-2',
    budget: 811,
    growth: -5
  },
  {
    id: 3,
    name: 'Instagram',
    desc: '83 Follows, 210 Likes',
    icon: 'instagram',
    color: 'bg-brown lighten-1',
    budget: 685,
    growth: 20
  },
  {
    id: 4,
    name: 'LinkedIn',
    desc: '23 Shares, 764 Likes',
    icon: 'linkedin',
    color: 'bg-light-blue darken-3',
    budget: 868,
    growth: 25
  },
  {
    id: 5,
    name: 'Youtube',
    desc: '2k subscribe, 1M Likes',
    icon: 'youtube',
    color: 'bg-red accent-4',
    budget: 780,
    growth: 45
  },
];

export const newArticlesData = {
  chartData: [25, 35, 34, 40, 20, 35, 25, 30, 50],
  labels: ['9', '10', '11', '12', '13', '14', '15'],
}
