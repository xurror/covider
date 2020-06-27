import React, { useState }  from 'react';
import './Geolocation.css';
import GoogleMapReact  from 'google-map-react';
import Marker from './Marker';


const Geolocation = (props: any) => {
  const getMapOptions = (maps: any) => {
    return {
      disableDefaultUI: true,
      mapTypeControl: true,
      streetViewControl: true,
      styles: [{ featureType: 'poi', elementType: 'labels', stylers: [{ visibility: 'on' }] }],
    };
  };

    const [center] = useState({lat: 4.16015815019341, lng: 9.228515625000002 });
    const [zoom] = useState(15);


    return (
      <div className="App">
        <header className="App-header">
            <h1 className="App-title"> Users Geolocation </h1>
            <h3>tracking Nkoa Christophe</h3>  {/* put user name */}
        </header>

        <div className="Map">
          <div style={{ height: '60vh', width: '100%' }}>
            <GoogleMapReact
              bootstrapURLKeys={{ key:"AIzaSyByphHfH2P3HIK9w0vU46GWUKUSg0BHTGQ" }}
              defaultCenter={center}
              defaultZoom={zoom}
              options={getMapOptions}
            >

            <Marker
                        lat={4.16015815019341}
                        lng={9.228515625000002}
                        name="User location"
                        color="blue"
                      />

            </GoogleMapReact>
          </div>
        </div>

    </div>
    );
  }

export default Geolocation;