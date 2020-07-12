package cm.ubuea.covider.userprofile;


import cm.ubuea.covider.registration.api.MedicalRecordController;
import cm.ubuea.covider.registration.service.MedicalRecordService;
import cm.ubuea.covider.registration.service.UserLocationService;
import cm.ubuea.covider.registration.service.UserService;
import cm.ubuea.covider.registration.service.dto.LocationDTO;
import cm.ubuea.covider.registration.service.dto.MedicalRecordDTO;
import cm.ubuea.covider.registration.service.dto.UserDetailsDTO;
import cm.ubuea.covider.registration.service.serviceImpl.MedicalRecordServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class UserProfileController {
    private final UserProfileService userProfileService;

    public UserProfileController(UserProfileService userProfileService) {
        this.userProfileService = userProfileService;
    }

    @GetMapping("/users")
    public ResponseEntity<List<UserDetailsDTO>> getAllUsersRecords() {
        return new ResponseEntity<>(userProfileService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/user/{id_card}")
    public ResponseEntity<UserDetailsDTO> getUserRecords(@PathVariable("id_card") String id){
        return new ResponseEntity<>(userProfileService.getOne(id), HttpStatus.OK);
    }

    @GetMapping("/user/profile/{id_card}/medical")
    public ResponseEntity<MedicalRecordDTO> getUserMedicalRecords(@PathVariable("id_card") String id) {
        return new ResponseEntity<>(userProfileService.getUserMedicalRecords(id), HttpStatus.OK);
    }

    @GetMapping("/user/profile/{id_card}/location")
    public ResponseEntity<LocationDTO> getUserLocation(@PathVariable("id_card") String id) {

        return new ResponseEntity<>(userProfileService.getUserLocation(id), HttpStatus.OK);
    }

    @PatchMapping("/user/profile/location/{loc_id}")
    public ResponseEntity<?> updateUserCurrentLocation(@RequestBody String newLocation,
                                                @PathVariable("loc_id") Long locID) {
        userProfileService.updateCurrentLocation(newLocation, locID);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    
    @PatchMapping("/user/profile/email")
    public ResponseEntity<?> updateUserEmail(@RequestBody String newEmail,
    										@PathVariable("email") String currentEmail){
    	userProfileService.updateMail(currentEmail, newEmail);
    	return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
