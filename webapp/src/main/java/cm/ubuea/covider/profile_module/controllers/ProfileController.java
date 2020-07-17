package cm.ubuea.covider.profile_module.controllers;

import cm.ubuea.covider.profile_module.dto.ProfileDTO;
import cm.ubuea.covider.profile_module.services.UserServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/api")
public class ProfileController {

    private UserServiceImpl service;

    public ProfileController(UserServiceImpl service) {
        this.service=service;
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<ProfileDTO> getOne(@RequestParam long userId) {
        return ResponseEntity.ok(service.retrieveOne(userId));
    }
}
