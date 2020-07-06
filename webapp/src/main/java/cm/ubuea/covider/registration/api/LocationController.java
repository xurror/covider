package cm.ubuea.covider.registration.api;


import cm.ubuea.covider.registration.domain.UserLocation;
import cm.ubuea.covider.registration.repository.UserLocationRepository;
import cm.ubuea.covider.registration.repository.UserRepository;
import cm.ubuea.covider.registration.service.UserLocationService;
import cm.ubuea.covider.registration.service.dto.LocationDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/user-locations")
public class LocationController {

    final
    UserLocationService userLocationService;

    private final UserLocationRepository userLocationRepository;

    private final UserRepository userRepository;


    public LocationController(UserLocationService userLocationService, UserLocationRepository userLocationRepository, UserRepository userRepository) {
        this.userLocationService = userLocationService;
        this.userLocationRepository = userLocationRepository;
        this.userRepository = userRepository;
    }

    @PostMapping("/add")
    public ResponseEntity<?> addLocation(@Valid @RequestBody LocationDTO locationDTO) {
        userLocationService.addUserLocation(locationDTO);
        return new ResponseEntity("User location successfully added",HttpStatus.CREATED);
    }

    @DeleteMapping("/delete/{id}")
    void deleteLocationRecord(@PathVariable("id") Long id) {
        userLocationRepository.deleteById(id);
    }

    @GetMapping("/record/{uidcard}")
    public List<UserLocation> getUserLocation(@PathVariable("uidcard") String uidcard) {

        List<UserLocation> location=userLocationRepository.findAll().
            stream().
            filter(e->e.getUser().getIdNumber().equals(uidcard)).
            collect(Collectors.toList());

        return location;
    }

    @PutMapping("/update/{id}")
    UserLocation updateLocationRecord(@RequestBody LocationDTO locationDTO, @PathVariable("id") long id) {

        return userLocationRepository.findById(id)
            .map(l-> {
                l.setCurrent_loctaion(locationDTO.getCurrent_loctaion());
                l.setPrevious_location(locationDTO.getPrevious_location());
                l.setUser(userRepository.findOneByIdNumber(locationDTO.getUserIdCard()).get());
                return userLocationRepository.save(l);
            })
            .orElseGet(() -> {
                return null;

            });
    }


}
