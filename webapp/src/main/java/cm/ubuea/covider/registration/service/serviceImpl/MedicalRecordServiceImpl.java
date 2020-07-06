package cm.ubuea.covider.registration.service.serviceImpl;

import cm.ubuea.covider.registration.domain.MedicalRecord;
import cm.ubuea.covider.registration.repository.MedicalRecordRepository;
import cm.ubuea.covider.registration.repository.UserRepository;
import cm.ubuea.covider.registration.service.MedicalRecordService;
import cm.ubuea.covider.registration.service.dto.MedicalRecordDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MedicalRecordServiceImpl implements MedicalRecordService {

    @Autowired
    MedicalRecordRepository medicalRecordRepository;
    @Autowired
    UserRepository userRepository;

    @Override
    public void addMedicalRecord(MedicalRecordDTO medicalRecordDTO) {
        MedicalRecord medicalRecord = new MedicalRecord();
        medicalRecord.setCurrentStatus(medicalRecordDTO.getCurrentStatus());
        medicalRecord.setCurrentSymptoms(medicalRecordDTO.getCurrentSymptoms());
        medicalRecord.setUser(userRepository.findOneByIdNumber(medicalRecordDTO.getUserIdNumber()).orElse(null));
        medicalRecordRepository.save(medicalRecord);
    }
}
