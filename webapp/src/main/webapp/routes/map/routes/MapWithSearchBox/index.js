import React from 'react';
import MapWithSearchBox from './Components/MapWithASearchBox';
import CardBox from 'components/CardBox';
import ContainerHeader from 'components/ContainerHeader';
import IntlMessages from 'util/IntlMessages';

const SearchBox = ({match}) => {
  return (
    <div className="animated slideInUpTiny animation-duration-3">
      <ContainerHeader title={<IntlMessages id="sidebar.map.trafficLayer"/>} match={match}/>

      <div className="row">
        <CardBox styleName="col-lg-12">
          <MapWithSearchBox/>
        </CardBox>
      </div>
    </div>
  );
};

export default SearchBox;
