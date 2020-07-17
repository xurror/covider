import React, { useState }  from 'react';
import './Geolocation.css';
import GoogleMapReact  from 'google-map-react';
import Marker from './Marker';

// You should use a valid API key as indicated down here to access google map 

const Geolocation = (props: any) => {
  const getMapOptions = (maps: any) => {
    return {
      disableDefaultUI: true,
      mapTypeControl: true,
      streetViewControl: true,
      styles: [{ featureType: 'poi', elementType: 'labels', stylers: [{ visibility: 'on' }] }],
    };
  };

    // insert user longitude and latitude just after lat and lng
    const [center] = useState({lat: 4.16015815019341, lng: 9.228515625000002 });
    const [zoom] = useState(15);


    return (
      <div className="App">
        <div className="Map">
          <div style={{ height: '80vh', width: '100%' }}>
            <GoogleMapReact
              // insert a valid API key down just after key
              bootstrapURLKeys={{ key: 'API' }}
              defaultCenter={center}
              defaultZoom={zoom}
              options={getMapOptions}
            >

            <Marker
                        // insert user longitude and latitude just after lat and lng
                        lat={4.16015815019341}
                        lng={9.228515625000002}
                        name="user location"
                        color="blue"
                      />

            </GoogleMapReact>
          </div>
        </div>

    </div>
    );
  }

export default Geolocation;