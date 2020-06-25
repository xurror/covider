package cm.ubuea.covider.registration.repository;

import cm.ubuea.covider.registration.domain.UserLocation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface UserLocationRepository extends JpaRepository<UserLocation, Long> {
}
