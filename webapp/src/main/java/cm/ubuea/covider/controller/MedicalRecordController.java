package ub.covid.fet.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ub.covid.fet.payload.MedicalRecordDTO;
import ub.covid.fet.services.MedicalRecordService;

import javax.validation.Valid;

@RestController
@RequestMapping("/api")
public class MedicalRecordController {
    @Autowired
    MedicalRecordService medicalRecordService;

    @PostMapping("/medical/add")
    public ResponseEntity<?> authenticateUser(@Valid @RequestBody MedicalRecordDTO medicalRecordDTO ) {
        medicalRecordService.addMedicalRecord(medicalRecordDTO);
        return new ResponseEntity(HttpStatus.CREATED);
    }
}
