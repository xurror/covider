package cm.ubuea.covider.registration.api;

import cm.ubuea.covider.registration.domain.MedicalRecord;
import cm.ubuea.covider.registration.repository.MedicalRecordRepository;
import cm.ubuea.covider.registration.repository.UserRepository;
import cm.ubuea.covider.registration.service.MedicalRecordService;
import cm.ubuea.covider.registration.service.dto.MedicalRecordDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/medical")
public class MedicalRecordController {
    final
    MedicalRecordService medicalRecordService;
    final
    MedicalRecordRepository medicalRecordRepository;

    final
    UserRepository userRepository;

    public MedicalRecordController(MedicalRecordService medicalRecordService, MedicalRecordRepository medicalRecordRepository, UserRepository userRepository) {
        this.medicalRecordService = medicalRecordService;
        this.medicalRecordRepository = medicalRecordRepository;
        this.userRepository = userRepository;
    }

    @PostMapping("/add")
    public ResponseEntity<?> addMedicalRecord(@Valid @RequestBody MedicalRecordDTO medicalRecordDTO ) {
        medicalRecordService.addMedicalRecord(medicalRecordDTO);
        return new ResponseEntity("Medical Record successfully added",HttpStatus.CREATED);
    }

    @DeleteMapping("/delete/{id}")
    void deleteMedicalREcord(@PathVariable("id") Long id) {
        medicalRecordRepository.deleteById(id);
    }

    @GetMapping("/record/{uidcard}")
    public List<MedicalRecord> getUserMedicalRecord(@PathVariable("uidcard") String uidcard) {

        List<MedicalRecord> medic=medicalRecordRepository.findAll().
            stream().
            filter(e->e.getUser().getIdNumber().equals(uidcard)).
            collect(Collectors.toList());

        return medic;
    }

    @PutMapping("/update/{id}")
    MedicalRecord updateMedicalRecord(@RequestBody MedicalRecordDTO medicalRecordDTO, @PathVariable("id") long id) {

        return medicalRecordRepository.findById(id)
            .map(m -> {
                m.setCurrent_status(medicalRecordDTO.isCurrent_status());
                m.setCurrent_symptoms(medicalRecordDTO.getCurrent_symptoms());
                m.setUser(userRepository.findOneByIdNumber(medicalRecordDTO.getUserIdCard()).get());
                return medicalRecordRepository.save(m);
            })
            .orElseGet(() -> {
               return null;

            });
    }





}
