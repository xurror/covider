package com.admin.module.service;

import java.util.List;

import com.admin.module.dto.LocationDTO;

public interface LocationService {

	List<LocationDTO> retrieveLocations();
	LocationDTO retrieveLocation(int locationId);
	LocationDTO createLocation(LocationDTO locationDTO);
	

}
