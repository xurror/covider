package ub.covid.fet.services.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import ub.covid.fet.model.User;
import ub.covid.fet.model.UserLocation;
import ub.covid.fet.payload.LocationDTO;
import ub.covid.fet.repository.UserLocationRepository;
import ub.covid.fet.repository.UserRepository;
import ub.covid.fet.services.UserLocationService;

@Service
public class UserLocationServiceImpl implements UserLocationService {
@Autowired
UserLocationRepository userLocationRepository;
@Autowired
UserRepository userRepository;

    @Override
    public void addUserLocation(LocationDTO locationDTO) {
        UserLocation userLocation = new UserLocation();
        userLocation.setCurrent_loctaion(locationDTO.getCurrent_loctaion());
        userLocation.setPrevious_location(locationDTO.getPrevious_location());
        userLocation.setUser(userRepository.findById(locationDTO.getUserid()).get());
        userLocationRepository.save(userLocation);
    }
    }
