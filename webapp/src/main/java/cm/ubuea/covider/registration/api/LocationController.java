package cm.ubuea.covider.registration.api;

import cm.ubuea.covider.registration.service.UserLocationService;
import cm.ubuea.covider.registration.service.dto.LocationDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/user-locations")
public class LocationController {

    final
    UserLocationService userLocationService;

    public LocationController(final UserLocationService userLocationService) {
        this.userLocationService = userLocationService;
    }

    @PostMapping("/")
    public ResponseEntity<?> addLocation(@Valid @RequestBody final LocationDTO locationDTO) {
        userLocationService.addUserLocation(locationDTO);
        return new ResponseEntity("User location successfully added", HttpStatus.CREATED);
    }
}
