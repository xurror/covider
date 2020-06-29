package cm.ubuea.covider.userprofile;

import cm.ubuea.covider.registration.domain.MedicalRecord;
import cm.ubuea.covider.registration.domain.User;
import cm.ubuea.covider.registration.domain.UserLocation;
import cm.ubuea.covider.registration.repository.MedicalRecordRepository;
import cm.ubuea.covider.registration.repository.UserLocationRepository;
import cm.ubuea.covider.registration.repository.UserRepository;
import cm.ubuea.covider.registration.service.dto.LocationDTO;
import cm.ubuea.covider.registration.service.dto.MedicalRecordDTO;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserProfileService {
    private final UserRepository userRepository;
    private final MedicalRecordRepository medicalRecordRepository;
    private final UserLocationRepository userLocationRepository;

    public UserProfileService (UserRepository userRepository, MedicalRecordRepository medicalRecordRepository,
                               UserLocationRepository userLocationRepository) {
        this.userRepository = userRepository;
        this.medicalRecordRepository = medicalRecordRepository;
        this.userLocationRepository = userLocationRepository;
    }

    public MedicalRecordDTO getUserMedicalRecords(String userIDNumber) {

        //ensure that user exists
        //existsby

        Optional<MedicalRecord> medicalRecord = medicalRecordRepository.findByUser_idNumber(userIDNumber);

        //if(medicalRecord.isPresent()) {
            MedicalRecord record = medicalRecord.get();

            MedicalRecordDTO userMedicalRecord = new MedicalRecordDTO();
            userMedicalRecord.setCurrent_symptoms(record.getCurrent_symptoms());
            userMedicalRecord.setCurrent_status(record.isCurrent_status());
        //}
        return userMedicalRecord;
    }

    public LocationDTO getUserLocation(String id) {
        //verify existence of user

        Optional<UserLocation> userLocation = userLocationRepository.findByUser_IdNumber(id);

//        if(userLocation.isPresent()) {
            LocationDTO userLocationDTO = new LocationDTO();
            UserLocation userLocationInf = userLocation.get();

            userLocationDTO.setCurrent_loctaion(userLocationInf.getCurrent_loctaion());
            userLocationDTO.setPrevious_location(userLocationInf.getPrevious_location());
        //}
            return userLocationDTO;
    }

    public void updateCurrentLocation(String newLocation, Long locID) {

        Optional<UserLocation> userLocation = userLocationRepository.findById(locID);

        if(userLocation.isPresent()) {
            UserLocation userLocationInfo = userLocation.get();

            List<String> userLocations = userLocationInfo.getPrevious_location();
            userLocations.add(newLocation);

            userLocationInfo.setPrevious_location(userLocations);
            userLocationRepository.save(userLocationInfo);
        }
    }
}
