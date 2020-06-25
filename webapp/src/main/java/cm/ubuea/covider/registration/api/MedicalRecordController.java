package cm.ubuea.covider.registration.api;

<<<<<<< HEAD
import cm.ubuea.covider.registration.domain.MedicalRecord;
import cm.ubuea.covider.registration.repository.MedicalRecordRepository;
import cm.ubuea.covider.registration.repository.UserRepository;
=======
>>>>>>> added functionality to add user's visited locations and medical status
import cm.ubuea.covider.registration.service.MedicalRecordService;
import cm.ubuea.covider.registration.service.dto.MedicalRecordDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
<<<<<<< HEAD
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;
=======
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
>>>>>>> added functionality to add user's visited locations and medical status

@RestController
@RequestMapping("/api/medical")
public class MedicalRecordController {
    final
    MedicalRecordService medicalRecordService;
<<<<<<< HEAD
    final
    MedicalRecordRepository medicalRecordRepository;

    final
    UserRepository userRepository;

    public MedicalRecordController(MedicalRecordService medicalRecordService, MedicalRecordRepository medicalRecordRepository, UserRepository userRepository) {
        this.medicalRecordService = medicalRecordService;
        this.medicalRecordRepository = medicalRecordRepository;
        this.userRepository = userRepository;
=======

    public MedicalRecordController(MedicalRecordService medicalRecordService) {
        this.medicalRecordService = medicalRecordService;
>>>>>>> added functionality to add user's visited locations and medical status
    }

    @PostMapping("/")
    public ResponseEntity<?> addMedicalRecord(@Valid @RequestBody MedicalRecordDTO medicalRecordDTO ) {
        medicalRecordService.addMedicalRecord(medicalRecordDTO);
        return new ResponseEntity("Medical Record successfully added",HttpStatus.CREATED);
    }
<<<<<<< HEAD

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





=======
>>>>>>> added functionality to add user's visited locations and medical status
}
