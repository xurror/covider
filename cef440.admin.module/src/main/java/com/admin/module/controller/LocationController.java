
  package com.admin.module.controller;
  
  import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
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
public ResponseEntity<LocationDTO> addUser(@RequestBody LocationDTO newLocationDTO) {
	LocationDTO locationDTO = locationService.createLocation(newLocationDTO);

	return new ResponseEntity<> (locationDTO,HttpStatus.CREATED);
	
}

@GetMapping("/location/{location_id}")
public ResponseEntity<LocationDTO> getLocation(@PathVariable("location_id") int locationId){
	return ResponseEntity.ok().body(locationService.retrieveLocation(locationId));
}


/*	
 /locations
/location/{location_id}
/location
/location/{location_id}
/location/{location_id}
 * 
 * 
 * 
*/	
	/*
	 * @GetMapping("/location/{location_id}") public ResponseEntity<List<UserDTO>>
	 * getAllNMUsers(){ return
	 * ResponseEntity.ok().body(userService.retrieveNMUsers()); }
	 * 
	 * @GetMapping("/users/agentuser") public ResponseEntity<List<UserDTO>>
	 * getAllAgentUsers(){ return
	 * ResponseEntity.ok(userService.retrieveAgentUsers()); }
	 * 
	 * @GetMapping("/users/adminuser") public ResponseEntity<List<UserDTO>>
	 * getAllAdminUsers(){ return
	 * ResponseEntity.ok(userService.retrieveAdminUsers()); }
	 */


  
  }
 