package ub.covid.fet.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ub.covid.fet.payload.LocationDTO;
import ub.covid.fet.payload.request.LoginRequest;
import ub.covid.fet.services.UserLocationService;

import javax.validation.Valid;

@RestController
@RequestMapping("/api")
public class LocationController {

    @Autowired
    UserLocationService userLocationService;

    @PostMapping("/location/add")
    public ResponseEntity<?> authenticateUser(@Valid @RequestBody LocationDTO locationDTO) {
        userLocationService.addUserLocation(locationDTO);
        return new ResponseEntity(HttpStatus.CREATED);
    }
}
