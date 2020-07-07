package ub.covid.fet.services.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ub.covid.fet.model.MedicalRecord;
import ub.covid.fet.payload.MedicalRecordDTO;
import ub.covid.fet.repository.MedicalRecordRepository;
import ub.covid.fet.repository.UserLocationRepository;
import ub.covid.fet.repository.UserRepository;
import ub.covid.fet.services.MedicalRecordService;

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
