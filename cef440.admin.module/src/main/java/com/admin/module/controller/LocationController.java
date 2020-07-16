
  package com.admin.module.controller;
  
  import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping; 
import org.springframework.web.bind.annotation.RestController;

import com.admin.module.dto.LocationDTO;
//import com.admin.module.model.Location;
import com.admin.module.service.LocationService;
  
  @RestController
  
  @CrossOrigin
  
  @RequestMapping("/api") public class LocationController {
  
  private LocationService locationService;

public LocationController(LocationService locationService) {
	super();
	this.locationService = locationService;
}
  
@GetMapping("/locations")
public ResponseEntity<List<LocationDTO>> getLocations(){
	return ResponseEntity.ok(locationService.retrieveLocations());
}


@PostMapping("/location")
public ResponseEntity<LocationDTO> addlocation(@RequestBody LocationDTO newLocationDTO) {
	LocationDTO locationDTO = locationService.createLocation(newLocationDTO);

	return new ResponseEntity<> (locationDTO,HttpStatus.CREATED);
	
}

@GetMapping("/location/{location_id}")
public ResponseEntity<LocationDTO> getLocation(@PathVariable("location_id") int locationId){
	return ResponseEntity.ok().body(locationService.retrieveLocation(locationId));
}


@DeleteMapping("/location/{locationId}")
public ResponseEntity<Object> deleteLocation(@PathVariable int locationId) {
	locationService.deleteLocation(locationId);
	return new ResponseEntity<>(HttpStatus.NO_CONTENT);
}

@PutMapping("/location/{locationId})")
public ResponseEntity<Object> editLocation(@PathVariable("locationId") int locationId,  @RequestBody LocationDTO newlocationDTO) {
	locationService.editLocation(locationId, newlocationDTO);
	return new ResponseEntity<>(HttpStatus.NO_CONTENT);
}

  
  }
 