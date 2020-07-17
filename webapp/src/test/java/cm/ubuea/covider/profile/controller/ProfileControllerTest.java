package cm.ubuea.covider.profile.controller;

import cm.ubuea.covider.profile_module.controllers.ProfileController;
import cm.ubuea.covider.profile_module.repositories.UserRepos;
import cm.ubuea.covider.profile_module.services.UserServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class ProfileControllerTest {
    @Mock
    private UserServiceImpl service;
    private ProfileController profileController;

    @BeforeEach
    void setUp() {
        profileController= new ProfileController(service);
    }

    @Test
    void test_can_get_user_detail() {
        profileController.getOne(1L);
        verify(service).retrieveOne(1L);
    }

}
