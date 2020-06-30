package cm.ubuea.covider.registration.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import cm.ubuea.covider.registration.domain.Role;

/**
 * Spring Data JPA repository for the {@link Authority} entity.
 */
@Repository
public interface RoleRepository extends JpaRepository<Role, String> {
}
