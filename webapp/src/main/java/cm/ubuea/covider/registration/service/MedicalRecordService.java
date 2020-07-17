package cm.ubuea.covider.registration.service;

import cm.ubuea.covider.registration.service.dto.MedicalRecordDTO;
import org.springframework.stereotype.Service;

@Service
public interface MedicalRecordService {
    public void addMedicalRecord(MedicalRecordDTO medicalRecordDTO);
}
