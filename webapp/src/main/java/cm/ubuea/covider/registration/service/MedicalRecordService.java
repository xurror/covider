package cm.ubuea.covider.registration.service;

import cm.ubuea.covider.registration.domain.MedicalRecord;
import cm.ubuea.covider.registration.repository.MedicalRecordRepository;
import cm.ubuea.covider.registration.repository.UserRepository;
import cm.ubuea.covider.registration.service.dto.MedicalRecordDTO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class MedicalRecordService {

    private MedicalRecordRepository medicalRecordRepository;

    private UserRepository userRepository;

    @Autowired
    public MedicalRecordService(MedicalRecordRepository medicalRecordRepository, UserRepository userRepository) {
        this.medicalRecordRepository = medicalRecordRepository;
        this.userRepository = userRepository;
    }

    public void addMedicalRecord(MedicalRecordDTO medicalRecordDTO) {
        MedicalRecord medicalRecord = new MedicalRecord();
        medicalRecord.setCurrentStatus(medicalRecordDTO.getCurrentStatus());
        medicalRecord.setCurrentSymptoms(medicalRecordDTO.getCurrentSymptoms());
        medicalRecord.setUser(userRepository.findOneByIdNumber(
            medicalRecordDTO.getIdNumber()).orElseThrow(() ->
                new AccountResourceException("User account not found")));
        medicalRecordRepository.save(medicalRecord);
    }

    private static class AccountResourceException extends RuntimeException {
        private static final long serialVersionUID = 1L;

        private AccountResourceException(String message) {
            super(message);
        }
    }
}
