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
        medicalRecord.setCurrent_status(medicalRecordDTO.isCurrent_status());
        medicalRecord.setCurrent_symptoms(medicalRecordDTO.getCurrent_symptoms());
        medicalRecord.setUser(userRepository.findById(medicalRecordDTO.getUserid()).get());
        medicalRecordRepository.save(medicalRecord);
    }
}
