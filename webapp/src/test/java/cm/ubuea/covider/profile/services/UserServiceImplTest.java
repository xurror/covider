package cm.ubuea.covider.profile.services;

import cm.ubuea.covider.profile_module.dto.ProfileDTO;
import cm.ubuea.covider.profile_module.models.User;
import cm.ubuea.covider.profile_module.repositories.UserRepos;
import cm.ubuea.covider.profile_module.services.UserServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class UserServiceImplTest {

    private UserServiceImpl service;
    @Mock
    private UserRepos repos;

    @BeforeEach
    void initializeUserService() {
        this.service=new UserServiceImpl(this.repos);
    }

    @Test
    void test_can_get_a_user() {
        User user = new User();
        user.setId(1L);
        user.setEmail("email");
        user.setIdNumber("1L");

        when(repos.findById(1L)).thenReturn(Optional.of(user));

        ProfileDTO profileDTO = service.retrieveOne(1L);
        assertThat(profileDTO.getIdNumber()).isEqualTo("1L");

    }
}