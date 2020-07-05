package com.admin.module.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.admin.module.model.Location;

@Repository
public interface LocationRepository extends JpaRepository<Location, Integer>{

}
