package cm.ubuea.covider.registration.api;

import cm.ubuea.covider.registration.service.MedicalRecordService;
import cm.ubuea.covider.registration.service.dto.MedicalRecordDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/medical")
public class MedicalRecordController {
    final
    MedicalRecordService medicalRecordService;

    public MedicalRecordController(MedicalRecordService medicalRecordService) {
        this.medicalRecordService = medicalRecordService;
    }

    @PostMapping("/add")
    public ResponseEntity<?> addMedicalRecord(@Valid @RequestBody MedicalRecordDTO medicalRecordDTO ) {
        medicalRecordService.addMedicalRecord(medicalRecordDTO);
        return new ResponseEntity("Medical Record successfully added",HttpStatus.CREATED);
    }
}
