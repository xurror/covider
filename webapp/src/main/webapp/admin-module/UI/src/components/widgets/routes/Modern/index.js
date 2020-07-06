<<<<<<< HEAD
import React from "react";
import Productivity from "./Productivity";
import Newseletter from "./Newsletter";
import SocialMedia from "./SocialMedia";
import ProjectWidget from "./ProjectWidget";
import RoadMap from "./RoadMap";
import FlyingBird from "./FlyingBird";
import DryFruit from "./DryFruit";
import AayurvedaCard from "./AayurvedaCard";
import ToolTheDay from "./ToolTheDay";
import SmartHomeCard from "./SmartHomeCard";
import PhotosCard from "./PhotosCard";
import UnreadMessagesCard from "./UnreadMessagesCard";
import IconCard from "./IconCard";
import WorkStatusCard from "./WorkStatusCard";
import UserCard from "./UserCard";
import IncreamentCard from "./IncreamentCard";
import CampaignCard from "./CampaignCard";
import BuildingCard from "./BuildingCard";
import GreenStepCard from "./GreenStepCard";
import FriendshipCard from "./FriendshipCard";
import NewPhotos from "./NewPhotos";


const ModernWidgets = () => {
  return (
    <div className="animated slideInUpTiny animation-duration-3">
      <div className="row">
        <div className="col-xl-3 col-sm-6 order-xl-1">
          <UserCard/>
        </div>
        <div className="col-xl-3 col-sm-6 order-xl-4">
          <BuildingCard/>
        </div>
        <div className="col-xl-3 col-sm-6 order-xl-2">
          <IncreamentCard/>
        </div>
        <div className="col-xl-3 col-sm-6 order-xl-3">
          <CampaignCard/>
        </div>
      </div>

      <div className="row">
        <div className="col-xl-4 col-sm-6">
          <Newseletter/>
        </div>
        <div className="col-xl-4 col-sm-6">
          <NewPhotos/>
        </div>
        <div className="col-xl-4 col-sm-6">
          <FlyingBird/>
        </div>

        <div className="col-xl-2 col-md-3 col-sm-6">
          <DryFruit/>
        </div>

        <div className="col-xl-2 col-md-3 col-sm-6">
          <AayurvedaCard/>
        </div>

        <div className="col-xl-2 col-md-3 col-sm-6">
          <ToolTheDay/>
        </div>

        <div className="col-xl-2 col-md-3 col-sm-4">
          <div className="row">
            <div className="col-sm-6 col-4">
              <IconCard image={"https://via.placeholder.com/37x40"}/>
            </div>
            <div className="col-sm-6 col-4">
              <IconCard image={"https://via.placeholder.com/37x40"}/>
            </div>
            <div className="col-sm-6 col-4 d-sm-none">
              <IconCard color="bg-secondary" image={"https://via.placeholder.com/37x40"}/>
            </div>
            <div className="col-12">
              <SmartHomeCard/>
            </div>
          </div>
        </div>

        <div className="col-xl-2 col-md-3 col-sm-4">
          <div className="row">
            <div className="col-6 col-sm-12">
              <PhotosCard/>
            </div>

            <div className="col-6 col-sm-12">
              <UnreadMessagesCard/>
            </div>
          </div>
        </div>

        <div className="col-xl-2 col-md-3 col-sm-4">
          <div className="row">
            <div className="col-12">
              <WorkStatusCard/>
            </div>
            <div className="col-6 d-none d-sm-block">
              <IconCard color="bg-secondary" image={require('assets/images/widget/glass.png')}/>
            </div>
            <div className="col-6 d-none d-sm-block">
              <IconCard color="bg-primary" image={require('assets/images/widget/bread.png')}/>
            </div>
          </div>
        </div>

        <div className="col-xl-3 col-lg-3 col-md-6 col-sm-6 col-12">
          <ProjectWidget/>
        </div>
        <div className="col-xl-3 col-lg-3 col-md-6 col-sm-6 col-12">
          <Productivity/>
        </div>
        <div className="col-xl-3 col-lg-3 col-md-6 col-sm-6 col-12">
          <SocialMedia/>
        </div>
        <div className="col-xl-3 col-lg-3 col-md-6 col-sm-6 col-12">
          <RoadMap/>
        </div>
        <div className="col-xl-6 col-lg-6 col-md-12 col-sm-12 col-12">
          <GreenStepCard/>
        </div>
        <div className="col-xl-6 col-lg-6 col-md-12 col-sm-12 col-12">
          <FriendshipCard/>
        </div>
      </div>
    </div>
  );
};

export default ModernWidgets;
=======
import React from "react";
import Productivity from "./Productivity";
import Newseletter from "./Newsletter";
import SocialMedia from "./SocialMedia";
import ProjectWidget from "./ProjectWidget";
import RoadMap from "./RoadMap";
import FlyingBird from "./FlyingBird";
import DryFruit from "./DryFruit";
import AayurvedaCard from "./AayurvedaCard";
import ToolTheDay from "./ToolTheDay";
import SmartHomeCard from "./SmartHomeCard";
import PhotosCard from "./PhotosCard";
import UnreadMessagesCard from "./UnreadMessagesCard";
import IconCard from "./IconCard";
import WorkStatusCard from "./WorkStatusCard";
import UserCard from "./UserCard";
import IncreamentCard from "./IncreamentCard";
import CampaignCard from "./CampaignCard";
import BuildingCard from "./BuildingCard";
import GreenStepCard from "./GreenStepCard";
import FriendshipCard from "./FriendshipCard";
import NewPhotos from "./NewPhotos";


const ModernWidgets = () => {
  return (
    <div className="animated slideInUpTiny animation-duration-3">
      <div className="row">
        <div className="col-xl-3 col-sm-6 order-xl-1">
          <UserCard/>
        </div>
        <div className="col-xl-3 col-sm-6 order-xl-4">
          <BuildingCard/>
        </div>
        <div className="col-xl-3 col-sm-6 order-xl-2">
          <IncreamentCard/>
        </div>
        <div className="col-xl-3 col-sm-6 order-xl-3">
          <CampaignCard/>
        </div>
      </div>

      <div className="row">
        <div className="col-xl-4 col-sm-6">
          <Newseletter/>
        </div>
        <div className="col-xl-4 col-sm-6">
          <NewPhotos/>
        </div>
        <div className="col-xl-4 col-sm-6">
          <FlyingBird/>
        </div>

        <div className="col-xl-2 col-md-3 col-sm-6">
          <DryFruit/>
        </div>

        <div className="col-xl-2 col-md-3 col-sm-6">
          <AayurvedaCard/>
        </div>

        <div className="col-xl-2 col-md-3 col-sm-6">
          <ToolTheDay/>
        </div>

        <div className="col-xl-2 col-md-3 col-sm-4">
          <div className="row">
            <div className="col-sm-6 col-4">
              <IconCard image={"https://via.placeholder.com/37x40"}/>
            </div>
            <div className="col-sm-6 col-4">
              <IconCard image={"https://via.placeholder.com/37x40"}/>
            </div>
            <div className="col-sm-6 col-4 d-sm-none">
              <IconCard color="bg-secondary" image={"https://via.placeholder.com/37x40"}/>
            </div>
            <div className="col-12">
              <SmartHomeCard/>
            </div>
          </div>
        </div>

        <div className="col-xl-2 col-md-3 col-sm-4">
          <div className="row">
            <div className="col-6 col-sm-12">
              <PhotosCard/>
            </div>

            <div className="col-6 col-sm-12">
              <UnreadMessagesCard/>
            </div>
          </div>
        </div>

        <div className="col-xl-2 col-md-3 col-sm-4">
          <div className="row">
            <div className="col-12">
              <WorkStatusCard/>
            </div>
            <div className="col-6 d-none d-sm-block">
              <IconCard color="bg-secondary" image={require('assets/images/widget/glass.png')}/>
            </div>
            <div className="col-6 d-none d-sm-block">
              <IconCard color="bg-primary" image={require('assets/images/widget/bread.png')}/>
            </div>
          </div>
        </div>

        <div className="col-xl-3 col-lg-3 col-md-6 col-sm-6 col-12">
          <ProjectWidget/>
        </div>
        <div className="col-xl-3 col-lg-3 col-md-6 col-sm-6 col-12">
          <Productivity/>
        </div>
        <div className="col-xl-3 col-lg-3 col-md-6 col-sm-6 col-12">
          <SocialMedia/>
        </div>
        <div className="col-xl-3 col-lg-3 col-md-6 col-sm-6 col-12">
          <RoadMap/>
        </div>
        <div className="col-xl-6 col-lg-6 col-md-12 col-sm-12 col-12">
          <GreenStepCard/>
        </div>
        <div className="col-xl-6 col-lg-6 col-md-12 col-sm-12 col-12">
          <FriendshipCard/>
        </div>
      </div>
    </div>
  );
};

export default ModernWidgets;
>>>>>>> 4d2bbb9... backbone for the dashboard
