package cm.ubuea.covider.registration.service;

import cm.ubuea.covider.registration.domain.UserLocation;
import cm.ubuea.covider.registration.repository.UserLocationRepository;
import cm.ubuea.covider.registration.repository.UserRepository;
import cm.ubuea.covider.registration.service.UserLocationService;
import cm.ubuea.covider.registration.service.dto.UserLocationDTO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UserLocationService {

    final UserLocationRepository userLocationRepository;

    final UserRepository userRepository;

    @Autowired
    public UserLocationService(final UserLocationRepository userLocationRepositor, final UserRepository userRepository) {
        this.userLocationRepository = userLocationRepositor;
        this.userRepository = userRepository;
    }

    public void addUserLocation(UserLocationDTO userLocationDTO) {
        UserLocation userLocation = new UserLocation();
        userLocation.setCurrentLocation(userLocationDTO.getCurrentLocation());
        userLocation.setPreviousLocation(userLocationDTO.getPreviousLocation());
        userLocation.setUser(userRepository.findOneByIdNumber(
            userLocationDTO.getIdNumber()).orElseThrow(() ->
                new AccountResourceException("User account not found")));
        userLocationRepository.save(userLocation);
    }

    private static class AccountResourceException extends RuntimeException {
        private static final long serialVersionUID = 1L;

        private AccountResourceException(String message) {
            super(message);
        }
    }
}
