package cm.ubuea.covider.registration.service;

import cm.ubuea.covider.registration.service.dto.LocationDTO;
import org.springframework.stereotype.Service;
@Service
public interface UserLocationService {
public void addUserLocation(LocationDTO locationDTO);
}
