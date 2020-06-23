package cm.ubuea.covider.registration.repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import cm.ubuea.covider.registration.domain.User;

/**
 * Spring Data JPA repository for the {@link User} entity.
 */
@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    String USERS_BY_ID_NUMBER_CACHE = "usersByIdNumber";

    String USERS_BY_EMAIL_CACHE = "usersByEmail";

    Optional<User> findOneByActivationKey(String activationKey);

    List<User> findAllByActivatedIsFalseAndActivationKeyIsNotNullAndCreatedDateBefore(LocalDateTime dateTime);

    Optional<User> findOneByResetKey(String resetKey);

    Optional<User> findOneByEmailIgnoreCase(String email);

    Optional<User> findOneByIdNumber(String idNumber);

    
    @EntityGraph(attributePaths = "authorities")
    @Cacheable(cacheNames = USERS_BY_ID_NUMBER_CACHE)
    Optional<User> findOneWithAuthoritiesByIdNumber(String idNumber);

    @EntityGraph(attributePaths = "authorities")
    @Cacheable(cacheNames = USERS_BY_EMAIL_CACHE)
    Optional<User> findOneWithAuthoritiesByEmailIgnoreCase(String email);

    Page<User> findAllByIdNumberNot(Pageable pageable, String idNumber);
}
