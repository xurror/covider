import React, {useEffect, useState} from "react";
import {Circle, GoogleMap, InfoWindow, withGoogleMap} from "react-google-maps";
import canUseDOM from "can-use-dom";
import raf from "raf";

const geolocation = (
  canUseDOM && navigator.geolocation ?
    navigator.geolocation :
    ({
      getCurrentPosition(success, failure) {
        failure(`Your browser doesn't support geolocation.`);
      },
    })
);

const GeolocationExampleGoogleMap = withGoogleMap(props => (
  <GoogleMap
    defaultZoom={10}
    center={props.center}
  >
    {props.center && (
      <InfoWindow position={props.center}>
        <div>{props.content}</div>
      </InfoWindow>
    )}
    {props.center && (
      <Circle
        center={props.center}
        radius={props.radius}
        options={{
          fillColor: 'red',
          fillOpacity: 0.20,
          strokeColor: 'red',
          strokeOpacity: 1,
          strokeWeight: 1,
        }}
      />
    )}
  </GoogleMap>
));

/*
 * https://developers.google.com/maps/documentation/javascript/examples/map-geolocation
 *
 * Add <script src="https://maps.googleapis.com/maps/api/js"></script> to your HTML to provide google.maps reference
 */
const GeolocationExample = () => {

  const [center, setCenter] = useState(null);
  const [content, setContent] = useState(null);
  const [radius, setRadius] = useState(6000);

  let isUnmounted = false;

  useEffect(() => {
    const tick = () => {
      if (isUnmounted) {
        return;
      }
      setRadius(Math.max(radius - 20, 0));

      if (radius > 200) {
        raf(tick);
      }
    };
    geolocation.getCurrentPosition((position) => {
      if (isUnmounted) {
        return;
      }
      setCenter({
        lat: position.coords.latitude,
        lng: position.coords.longitude,
      });
      setContent(`Location found using HTML5.`);
      raf(tick);
    }, (reason) => {
      if (isUnmounted) {
        return;
      }

      setCenter({
        lat: 60,
        lng: 105,
      });
      setContent(`Error: The Geolocation service failed (${reason}).`);
    });

    return () => {
      isUnmounted = true;
    }
  }, []);

  return (
    <GeolocationExampleGoogleMap
      containerElement={
        <div className="embed-responsive embed-responsive-21by9"/>
      }
      mapElement={<div className="embed-responsive-item"/>}
      center={center}
      content={content}
      radius={radius}
    />
  );
};

export default GeolocationExample;