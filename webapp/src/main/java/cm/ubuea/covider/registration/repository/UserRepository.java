package cm.ubuea.covider.registration.repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
<<<<<<< HEAD
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
=======
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
>>>>>>> from upstream updates
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

<<<<<<< HEAD
    @Cacheable(cacheNames = USERS_BY_ID_NUMBER_CACHE)
    @Query("SELECT user FROM User user WHERE user.idNumber = :idNumber")
    Optional<User> findOneWithRolesByIdNumber(@Param("idNumber") String idNumber);

    @Cacheable(cacheNames = USERS_BY_EMAIL_CACHE)
    @Query("SELECT user FROM User user WHERE user.email = :email")
    Optional<User> findOneWithRolesByEmailIgnoreCase(@Param("email") String email);
=======
    
    @EntityGraph(attributePaths = "authorities")
    @Cacheable(cacheNames = USERS_BY_ID_NUMBER_CACHE)
    Optional<User> findOneWithAuthoritiesByIdNumber(String idNumber);

    @EntityGraph(attributePaths = "authorities")
    @Cacheable(cacheNames = USERS_BY_EMAIL_CACHE)
    Optional<User> findOneWithAuthoritiesByEmailIgnoreCase(String email);
>>>>>>> from upstream updates

    Page<User> findAllByIdNumberNot(Pageable pageable, String idNumber);
}
