package cm.ubuea.covider.registration.repository;

import cm.ubuea.covider.registration.domain.MedicalRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MedicalRecordRepository extends JpaRepository<MedicalRecord,Long> {
    Optional<MedicalRecord> findByUser_idNumber(String userIdNumber);
}
