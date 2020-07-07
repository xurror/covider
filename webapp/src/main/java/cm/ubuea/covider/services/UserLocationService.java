package ub.covid.fet.services;

import org.springframework.stereotype.Service;
import ub.covid.fet.payload.LocationDTO;

@Service
public interface UserLocationService {
public void addUserLocation(LocationDTO locationDTO);
}
