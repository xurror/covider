package cm.ubuea.covider.registration.repository;

import cm.ubuea.covider.registration.domain.UserLocation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface UserLocationRepository extends JpaRepository<UserLocation, Long> {
    Optional<UserLocation> findByUser_IdNumber(String id);
}
