package cm.ubuea.covider.registration.repository;

import cm.ubuea.covider.registration.domain.PersistentAuditEvent;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
<<<<<<< HEAD
import org.springframework.stereotype.Repository;
=======
>>>>>>> from upstream updates

import java.time.Instant;
import java.util.List;

/**
 * Spring Data JPA repository for the {@link PersistentAuditEvent} entity.
 */
<<<<<<< HEAD
@Repository
=======
>>>>>>> from upstream updates
public interface PersistenceAuditEventRepository extends JpaRepository<PersistentAuditEvent, Long> {

    List<PersistentAuditEvent> findByPrincipal(String principal);

    List<PersistentAuditEvent> findByPrincipalAndAuditEventDateAfterAndAuditEventType(String principal, Instant after, String type);

    Page<PersistentAuditEvent> findAllByAuditEventDateBetween(Instant fromDate, Instant toDate, Pageable pageable);

    List<PersistentAuditEvent> findByAuditEventDateBefore(Instant before);
}
