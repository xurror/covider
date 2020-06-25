package cm.ubuea.covider.registration.repository;

import cm.ubuea.covider.registration.domain.UserLocation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

<<<<<<< HEAD
import java.util.Optional;


@Repository
public interface UserLocationRepository extends JpaRepository<UserLocation, Long> {
    Optional<UserLocation> findByUser_IdNumber(String id);
=======

@Repository
public interface UserLocationRepository extends JpaRepository<UserLocation, Long> {
>>>>>>> ed505e9... added functionality to add user's visited locations and medical status
}
