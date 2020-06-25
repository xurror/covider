package cm.ubuea.covider.registration.repository;

import cm.ubuea.covider.registration.domain.MedicalRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

<<<<<<< HEAD
import java.util.Optional;

@Repository
public interface MedicalRecordRepository extends JpaRepository<MedicalRecord,Long> {
    Optional<MedicalRecord> findByUser_idNumber(String userIdNumber);
=======
@Repository
public interface MedicalRecordRepository extends JpaRepository<MedicalRecord,Long> {
>>>>>>> ed505e9... added functionality to add user's visited locations and medical status
}
