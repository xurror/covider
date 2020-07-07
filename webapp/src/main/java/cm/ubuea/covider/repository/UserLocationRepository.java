package ub.covid.fet.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ub.covid.fet.model.UserLocation;

@Repository
public interface UserLocationRepository extends JpaRepository<UserLocation,Integer> {
}
