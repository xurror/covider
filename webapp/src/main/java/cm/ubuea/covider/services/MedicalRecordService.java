package ub.covid.fet.services;

import org.springframework.stereotype.Service;
import ub.covid.fet.payload.MedicalRecordDTO;

@Service
public interface MedicalRecordService {
    public void addMedicalRecord(MedicalRecordDTO medicalRecordDTO);
}
