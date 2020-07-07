import React, {useEffect, useState} from "react";
import {DirectionsRenderer, GoogleMap, withGoogleMap} from "react-google-maps";

const google = window.google;

const DirectionsExampleGoogleMap = withGoogleMap(props => (
  <GoogleMap
    defaultZoom={7}
    defaultCenter={props.center}
  >
    {props.directions && <DirectionsRenderer directions={props.directions}/>}
  </GoogleMap>
));

/*
 * Add <script src="https://maps.googleapis.com/maps/api/js"></script> to your HTML to provide google.maps reference
 */
const MapDirections = () => {

  const origin = new google.maps.LatLng(41.8507300, -87.6512600);
  const destination = new google.maps.LatLng(41.8525800, -87.6514100);
  const [directions, setDirections] = useState(null);

  useEffect(() => {
    const DirectionsService = new google.maps.DirectionsService();

    DirectionsService.route({
      origin: origin,
      destination: destination,
      travelMode: google.maps.TravelMode.DRIVING,
    }, (result, status) => {
      if (status === google.maps.DirectionsStatus.OK) {
        setDirections(result);
      } else {
        console.error(`error fetching directions ${result}`);
      }
    });
  }, [destination, origin]);

  return (
    <DirectionsExampleGoogleMap
      containerElement={
        <div className="embed-responsive embed-responsive-21by9"/>
      }
      mapElement={<div className="embed-responsive-item"/>}
      center={origin}
      directions={directions}
    />
  );
};

export default MapDirections;