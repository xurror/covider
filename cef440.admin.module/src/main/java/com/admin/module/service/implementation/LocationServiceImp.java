package com.admin.module.service.implementation;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import com.admin.module.dto.LocationDTO;
import com.admin.module.model.Location;
import com.admin.module.repository.LocationRepository;
import com.admin.module.service.LocationService;


@Service
public class LocationServiceImp implements LocationService{

	private LocationRepository locationRepository;
	
	
	@Autowired
	public LocationServiceImp(LocationRepository locationRepository) {
		super();
		this.locationRepository = locationRepository;
	}

	@Override
	public List<LocationDTO> retrieveLocations() {
		// TODO Auto-generated method stub
Iterable<Location> locations = locationRepository.findAll();
        
        return loadLocationDTOS(locations);
		
	}

	@Override
	public LocationDTO retrieveLocation(int locationId) {
		// TODO Auto-generated method stub
		
		Optional<Location> locationOptional = locationRepository.findById(locationId);
		if(locationOptional.isPresent()) {
            Location location = locationOptional.get();
            LocationDTO locationDTO = copyLocationtoLocationDTO(location);
            return  locationDTO;
        } else {
            throw new ResourceNotFoundException("Location with Location_Id = "+ locationId + " does not exist");
        }
		
	}

	@Override
	public LocationDTO createLocation(LocationDTO newLocationDTO) {
		// TODO Auto-generated method stub
		Location location = new Location();
		location = copyLocationDTOtoLocation(newLocationDTO);

		location = locationRepository.save(location);
		
		return copyLocationtoLocationDTO(location);
	}

	
	
	public List<LocationDTO> loadLocationDTOS(Iterable<Location> locations) {
		
		List<LocationDTO> locationDTOS = new ArrayList<>();
		for(Location location : locations){
            
            locationDTOS.add(copyLocationtoLocationDTO(location));
            
        }
		return locationDTOS;
	}
	
	
	public LocationDTO copyLocationtoLocationDTO(Location location) {
		LocationDTO locationDTO = new LocationDTO();
        
        locationDTO.setLocationId(location.getLocationId());  
        locationDTO.setRegion(location.getRegion());
        locationDTO.setDivision(location.getDivision());
        locationDTO.setTown(location.getTown());
        
       
        return locationDTO;
    }
	

	public Location copyLocationDTOtoLocation(LocationDTO newLocationDTO) {

		Location location = new Location();
		
		location.setRegion(newLocationDTO.getRegion());
		location.setDivision(newLocationDTO.getDivision());
		location.setTown(newLocationDTO.getTown());       
        return location;
    }
	
}
