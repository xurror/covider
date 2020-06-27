package cm.ubuea.covider.profile_module.services;

import cm.ubuea.covider.profile_module.dto.ProfileDTO;
import cm.ubuea.covider.profile_module.models.User;
import cm.ubuea.covider.profile_module.repositories.UserRepos;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl {
    private static final Logger lg = LoggerFactory.getLogger(UserServiceImpl.class);

    private UserRepos userRepository;

    public UserServiceImpl(UserRepos userRepository) {
        this.userRepository = userRepository;
    }


    public ProfileDTO retrieveOne(Long i) {
        User user = userRepository.findById(i).get();
        ProfileDTO dto = new ProfileDTO();
        dto.setEmail(user.getEmail());
        dto.setIdNumber(user.getIdNumber());
        return dto;
    }
}
