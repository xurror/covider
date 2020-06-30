package cm.ubuea.covider.registration.api;

import org.apache.commons.lang3.RandomStringUtils;
import org.junit.jupiter.api.BeforeEach;
// import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cache.CacheManager;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.transaction.annotation.Transactional;
import cm.ubuea.covider.ServerApplication;
import cm.ubuea.covider.registration.api.vm.ManagedUserVM;
import cm.ubuea.covider.registration.domain.Role;
import cm.ubuea.covider.registration.domain.User;
import cm.ubuea.covider.registration.repository.UserRepository;
import cm.ubuea.covider.registration.service.dto.UserDTO;
import cm.ubuea.covider.registration.service.mapper.UserMapper;
import cm.ubuea.covider.security.RolesConstants;
import javax.persistence.EntityManager;
import java.time.LocalDateTime;
import java.util.*;
import java.util.function.Consumer;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.hasItem;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

/**
 * Integration tests for the {@link UserResource} REST controller.
 */
@AutoConfigureMockMvc
@WithMockUser(roles = "ADMIN")
@SpringBootTest(classes = ServerApplication.class)
public class UserResourceIT {

    private static final String DEFAULT_ID_NUMBER = "johndoeID" + RandomStringUtils.randomAlphabetic(5).toLowerCase();
    private static final String UPDATED_ID_NUMBER = "coviderID" + RandomStringUtils.randomAlphabetic(5).toLowerCase();

    private static final Long DEFAULT_ID = 1L;

    private static final String DEFAULT_PASSWORD = "passjohndoe";
    private static final String UPDATED_PASSWORD = "passcovider";

    private static final String DEFAULT_EMAIL = RandomStringUtils.randomAlphabetic(5).toLowerCase() + "johndoe@localhost";
    private static final String UPDATED_EMAIL = RandomStringUtils.randomAlphabetic(5).toLowerCase() + "covider@localhost";

    private static final String DEFAULT_NAME = "john doe";
    private static final String UPDATED_NAME = "CoviderName";

    private static final String DEFAULT_LANGKEY = "en";
    private static final String UPDATED_LANGKEY = "fr";

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private EntityManager em;

    @Autowired
    private CacheManager cacheManager;

    @Autowired
    private MockMvc restUserMockMvc;

    private User user;

    @BeforeEach
    public void setup() {
        cacheManager.getCache(UserRepository.USERS_BY_ID_NUMBER_CACHE).clear();
        cacheManager.getCache(UserRepository.USERS_BY_EMAIL_CACHE).clear();
    }

    /**
     * Create a User.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which has a required relationship to the User entity.
     */
    public static User createEntity(final EntityManager em) {
        final User user = new User();
        user.setIdNumber(DEFAULT_ID_NUMBER + RandomStringUtils.randomAlphabetic(5));
        user.setPassword(RandomStringUtils.random(60));
        user.setActivated(true);
        user.setEmail(RandomStringUtils.randomAlphabetic(5) + DEFAULT_EMAIL);
        user.setName(DEFAULT_NAME);
        user.setLangKey(DEFAULT_LANGKEY);
        return user;
    }

    @BeforeEach
    public void initTest() {
        user = createEntity(em);
        user.setIdNumber(DEFAULT_ID_NUMBER);
        user.setEmail(DEFAULT_EMAIL);
    }

    @Test
    @Transactional
    public void testCreateUser() throws Exception {
        final int databaseSizeBeforeCreate = userRepository.findAll().size();

        // Create the User
        final ManagedUserVM managedUserVM = new ManagedUserVM();
        managedUserVM.setIdNumber(DEFAULT_ID_NUMBER);
        managedUserVM.setPassword(DEFAULT_PASSWORD);
        managedUserVM.setName(DEFAULT_NAME);
        managedUserVM.setEmail(DEFAULT_EMAIL);
        managedUserVM.setActivated(true);
        managedUserVM.setLangKey(DEFAULT_LANGKEY);
        managedUserVM.setRoles(Collections.singleton(RolesConstants.USER));

        restUserMockMvc.perform(post("/api/users").contentType(MediaType.APPLICATION_JSON)
                .content(TestUtil.convertObjectToJsonBytes(managedUserVM))).andExpect(status().isCreated());

        // Validate the User in the database
        assertPersistedUsers(users -> {
            assertThat(users).hasSize(databaseSizeBeforeCreate + 1);
            final User testUser = users.get(users.size() - 1);
            assertThat(testUser.getIdNumber()).isEqualTo(DEFAULT_ID_NUMBER);
            assertThat(testUser.getName()).isEqualTo(DEFAULT_NAME);
            assertThat(testUser.getEmail()).isEqualTo(DEFAULT_EMAIL);
            assertThat(testUser.getLangKey()).isEqualTo(DEFAULT_LANGKEY);
        });
    }

    @Test
    @Transactional
    public void testCreateUserWithExistingId() throws Exception {
        final int databaseSizeBeforeCreate = userRepository.findAll().size();

        final ManagedUserVM managedUserVM = new ManagedUserVM();
        managedUserVM.setId(1L);
        managedUserVM.setIdNumber(DEFAULT_ID_NUMBER);
        managedUserVM.setPassword(DEFAULT_PASSWORD);
        managedUserVM.setName(DEFAULT_NAME);
        managedUserVM.setEmail(DEFAULT_EMAIL);
        managedUserVM.setActivated(true);
        managedUserVM.setLangKey(DEFAULT_LANGKEY);
        managedUserVM.setRoles(Collections.singleton(RolesConstants.USER));

        // An entity with an existing ID cannot be created, so this API call must fail
        restUserMockMvc.perform(post("/api/users").contentType(MediaType.APPLICATION_JSON)
                .content(TestUtil.convertObjectToJsonBytes(managedUserVM))).andExpect(status().isBadRequest());

        // Validate the User in the database
        assertPersistedUsers(users -> assertThat(users).hasSize(databaseSizeBeforeCreate));
    }

    @Test
    @Transactional
    public void testCreateUserWithExistingIdNumber() throws Exception {
        // Initialize the database
        userRepository.saveAndFlush(user);
        final int databaseSizeBeforeCreate = userRepository.findAll().size();

        final ManagedUserVM managedUserVM = new ManagedUserVM();
        managedUserVM.setIdNumber(DEFAULT_ID_NUMBER);// this idNumber should already be used
        managedUserVM.setPassword(DEFAULT_PASSWORD);
        managedUserVM.setName(DEFAULT_NAME);
        managedUserVM.setEmail("anothermail@localhost");
        managedUserVM.setActivated(true);
        managedUserVM.setLangKey(DEFAULT_LANGKEY);
        managedUserVM.setRoles(Collections.singleton(RolesConstants.USER));

        // Create the User
        restUserMockMvc.perform(post("/api/users").contentType(MediaType.APPLICATION_JSON)
                .content(TestUtil.convertObjectToJsonBytes(managedUserVM))).andExpect(status().isBadRequest());

        // Validate the User in the database
        assertPersistedUsers(users -> assertThat(users).hasSize(databaseSizeBeforeCreate));
    }

    @Test
    @Transactional
    public void testCreateUserWithExistingEmail() throws Exception {
        // Initialize the database
        userRepository.saveAndFlush(user);
        final int databaseSizeBeforeCreate = userRepository.findAll().size();

        final ManagedUserVM managedUserVM = new ManagedUserVM();
        managedUserVM.setIdNumber("anotherIdNumber");
        managedUserVM.setPassword(DEFAULT_PASSWORD);
        managedUserVM.setName(DEFAULT_NAME);
        managedUserVM.setEmail(DEFAULT_EMAIL);// this email should already be used
        managedUserVM.setActivated(true);
        managedUserVM.setLangKey(DEFAULT_LANGKEY);
        managedUserVM.setRoles(Collections.singleton(RolesConstants.USER));

        // Create the User
        restUserMockMvc.perform(post("/api/users").contentType(MediaType.APPLICATION_JSON)
                .content(TestUtil.convertObjectToJsonBytes(managedUserVM))).andExpect(status().isBadRequest());

        // Validate the User in the database
        assertPersistedUsers(users -> assertThat(users).hasSize(databaseSizeBeforeCreate));
    }

    @Test
    @Transactional
    public void testGetAllUsers() throws Exception {
        // Initialize the database
        userRepository.saveAndFlush(user);

        // Get all the users
        restUserMockMvc.perform(get("/api/users?sort=id,desc").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk()).andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(jsonPath("$.[*].idNumber").value(hasItem(DEFAULT_ID_NUMBER)))
                .andExpect(jsonPath("$.[*].name").value(hasItem(DEFAULT_NAME)))
                .andExpect(jsonPath("$.[*].email").value(hasItem(DEFAULT_EMAIL)))
                .andExpect(jsonPath("$.[*].langKey").value(hasItem(DEFAULT_LANGKEY)));
    }

    @Test
    @Transactional
    public void testGetUser() throws Exception {
        // Initialize the database
        userRepository.saveAndFlush(user);

        assertThat(cacheManager.getCache(UserRepository.USERS_BY_ID_NUMBER_CACHE).get(user.getIdNumber())).isNull();

        // Get the user
        restUserMockMvc.perform(get("/api/users/{idNumber}", user.getIdNumber())).andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(jsonPath("$.idNumber").value(user.getIdNumber()))
                .andExpect(jsonPath("$.name").value(DEFAULT_NAME))
                .andExpect(jsonPath("$.email").value(DEFAULT_EMAIL))
                .andExpect(jsonPath("$.langKey").value(DEFAULT_LANGKEY));

        assertThat(cacheManager.getCache(UserRepository.USERS_BY_ID_NUMBER_CACHE).get(user.getIdNumber())).isNotNull();
    }

    @Test
    @Transactional
    public void testUpdateUser() throws Exception {
        // Initialize the database
        userRepository.saveAndFlush(user);
        final int databaseSizeBeforeUpdate = userRepository.findAll().size();

        // Update the user
        final User updatedUser = userRepository.findById(user.getId()).get();

        final ManagedUserVM managedUserVM = new ManagedUserVM();
        managedUserVM.setId(updatedUser.getId());
        managedUserVM.setIdNumber(updatedUser.getIdNumber());
        managedUserVM.setPassword(UPDATED_PASSWORD);
        managedUserVM.setName(UPDATED_NAME);
        managedUserVM.setEmail(UPDATED_EMAIL);
        managedUserVM.setActivated(updatedUser.getActivated());
        managedUserVM.setLangKey(UPDATED_LANGKEY);
        managedUserVM.setCreatedBy(updatedUser.getCreatedBy());
        managedUserVM.setCreatedDate(updatedUser.getCreatedDate());
        managedUserVM.setLastModifiedBy(updatedUser.getLastModifiedBy());
        managedUserVM.setLastModifiedDate(updatedUser.getLastModifiedDate());
        managedUserVM.setRoles(Collections.singleton(RolesConstants.USER));

        restUserMockMvc.perform(put("/api/users").contentType(MediaType.APPLICATION_JSON)
                .content(TestUtil.convertObjectToJsonBytes(managedUserVM))).andExpect(status().isOk());

        // Validate the User in the database
        assertPersistedUsers(users -> {
            assertThat(users).hasSize(databaseSizeBeforeUpdate);
            final User testUser = users.get(users.size() - 1);
            assertThat(testUser.getName()).isEqualTo(UPDATED_NAME);
            assertThat(testUser.getEmail()).isEqualTo(UPDATED_EMAIL);
            assertThat(testUser.getLangKey()).isEqualTo(UPDATED_LANGKEY);
        });
    }

    @Test
    @Transactional
    public void testUpdateUserIdNumber() throws Exception {
        // Initialize the database
        userRepository.saveAndFlush(user);
        final int databaseSizeBeforeUpdate = userRepository.findAll().size();

        // Update the user
        final User updatedUser = userRepository.findById(user.getId()).get();

        final ManagedUserVM managedUserVM = new ManagedUserVM();
        managedUserVM.setId(updatedUser.getId());
        managedUserVM.setIdNumber(UPDATED_ID_NUMBER);
        managedUserVM.setPassword(UPDATED_PASSWORD);
        managedUserVM.setName(UPDATED_NAME);
        managedUserVM.setEmail(UPDATED_EMAIL);
        managedUserVM.setActivated(updatedUser.getActivated());
        managedUserVM.setLangKey(UPDATED_LANGKEY);
        managedUserVM.setCreatedBy(updatedUser.getCreatedBy());
        managedUserVM.setCreatedDate(updatedUser.getCreatedDate());
        managedUserVM.setLastModifiedBy(updatedUser.getLastModifiedBy());
        managedUserVM.setLastModifiedDate(updatedUser.getLastModifiedDate());
        managedUserVM.setRoles(Collections.singleton(RolesConstants.USER));

        restUserMockMvc.perform(put("/api/users").contentType(MediaType.APPLICATION_JSON)
                .content(TestUtil.convertObjectToJsonBytes(managedUserVM))).andExpect(status().isOk());

        // Validate the User in the database
        assertPersistedUsers(users -> {
            assertThat(users).hasSize(databaseSizeBeforeUpdate);
            final User testUser = users.get(users.size() - 1);
            assertThat(testUser.getIdNumber()).isEqualTo(UPDATED_ID_NUMBER);
            assertThat(testUser.getName()).isEqualTo(UPDATED_NAME);
            assertThat(testUser.getEmail()).isEqualTo(UPDATED_EMAIL);
            assertThat(testUser.getLangKey()).isEqualTo(UPDATED_LANGKEY);
        });
    }

    @Test
    @Transactional
    public void testUpdateUserExistingEmail() throws Exception {
        // Initialize the database with 2 users
        userRepository.saveAndFlush(user);

        final User anotherUser = new User();
        anotherUser.setIdNumber("covider");
        anotherUser.setPassword(RandomStringUtils.random(60));
        anotherUser.setActivated(true);
        anotherUser.setEmail("covider@localhost");
        anotherUser.setName("hipster");
        anotherUser.setLangKey("en");
        userRepository.saveAndFlush(anotherUser);

        // Update the user
        final User updatedUser = userRepository.findById(user.getId()).get();

        final ManagedUserVM managedUserVM = new ManagedUserVM();
        managedUserVM.setId(updatedUser.getId());
        managedUserVM.setIdNumber(updatedUser.getIdNumber());
        managedUserVM.setPassword(updatedUser.getPassword());
        managedUserVM.setName(updatedUser.getName());
        managedUserVM.setEmail("covider@localhost");// this email should already be used by anotherUser
        managedUserVM.setActivated(updatedUser.getActivated());
        managedUserVM.setLangKey(updatedUser.getLangKey());
        managedUserVM.setCreatedBy(updatedUser.getCreatedBy());
        managedUserVM.setCreatedDate(updatedUser.getCreatedDate());
        managedUserVM.setLastModifiedBy(updatedUser.getLastModifiedBy());
        managedUserVM.setLastModifiedDate(updatedUser.getLastModifiedDate());
        managedUserVM.setRoles(Collections.singleton(RolesConstants.USER));

        restUserMockMvc.perform(put("/api/users").contentType(MediaType.APPLICATION_JSON)
                .content(TestUtil.convertObjectToJsonBytes(managedUserVM))).andExpect(status().isBadRequest());
    }

    @Test
    @Transactional
    public void testUpdateUserExistingIdNumber() throws Exception {
        // Initialize the database
        userRepository.saveAndFlush(user);

        final User anotherUser = new User();
        anotherUser.setIdNumber("covider");
        anotherUser.setPassword(RandomStringUtils.random(60));
        anotherUser.setActivated(true);
        anotherUser.setEmail("covider@localhost");
        anotherUser.setName("hipster");
        anotherUser.setLangKey("en");
        userRepository.saveAndFlush(anotherUser);

        // Update the user
        final User updatedUser = userRepository.findById(user.getId()).get();

        final ManagedUserVM managedUserVM = new ManagedUserVM();
        managedUserVM.setId(updatedUser.getId());
        managedUserVM.setIdNumber("covider");// this idNumber should already be used by anotherUser
        managedUserVM.setPassword(updatedUser.getPassword());
        managedUserVM.setName(updatedUser.getName());
        managedUserVM.setEmail(updatedUser.getEmail());
        managedUserVM.setActivated(updatedUser.getActivated());
        managedUserVM.setLangKey(updatedUser.getLangKey());
        managedUserVM.setCreatedBy(updatedUser.getCreatedBy());
        managedUserVM.setCreatedDate(updatedUser.getCreatedDate());
        managedUserVM.setLastModifiedBy(updatedUser.getLastModifiedBy());
        managedUserVM.setLastModifiedDate(updatedUser.getLastModifiedDate());
        managedUserVM.setRoles(Collections.singleton(RolesConstants.USER));

        restUserMockMvc.perform(put("/api/users").contentType(MediaType.APPLICATION_JSON)
                .content(TestUtil.convertObjectToJsonBytes(managedUserVM))).andExpect(status().isBadRequest());
    }

    @Test
    @Transactional
    public void testDeleteUser() throws Exception {
        // Initialize the database
        userRepository.saveAndFlush(user);
        final int databaseSizeBeforeDelete = userRepository.findAll().size();

        // Delete the user
        restUserMockMvc.perform(delete("/api/users/{idnumber}", user.getIdNumber()).accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isNoContent());

        assertThat(cacheManager.getCache(UserRepository.USERS_BY_ID_NUMBER_CACHE).get(user.getIdNumber())).isNull();

        // Validate the database is empty
        assertPersistedUsers(users -> assertThat(users).hasSize(databaseSizeBeforeDelete - 1));
    }

    @Test
    public void testUserEquals() throws Exception {
        TestUtil.equalsVerifier(User.class);
        final User user1 = new User();
        user1.setId(1L);
        final User user2 = new User();
        user2.setId(user1.getId());
        assertThat(user1).isEqualTo(user2);
        user2.setId(2L);
        assertThat(user1).isNotEqualTo(user2);
        user1.setId(null);
        assertThat(user1).isNotEqualTo(user2);
    }

    @Test
    public void testUserDTOtoUser() {
        final UserDTO userDTO = new UserDTO();
        userDTO.setId(DEFAULT_ID);
        userDTO.setIdNumber(DEFAULT_ID_NUMBER);
        userDTO.setName(DEFAULT_NAME);
        userDTO.setEmail(DEFAULT_EMAIL);
        userDTO.setActivated(true);
        userDTO.setLangKey(DEFAULT_LANGKEY);
        userDTO.setCreatedBy(DEFAULT_ID_NUMBER);
        userDTO.setLastModifiedBy(DEFAULT_ID_NUMBER);
        userDTO.setRoles(Collections.singleton(RolesConstants.USER));

        final User user = userMapper.userDTOToUser(userDTO);
        assertThat(user.getId()).isEqualTo(DEFAULT_ID);
        assertThat(user.getIdNumber()).isEqualTo(DEFAULT_ID_NUMBER);
        assertThat(user.getName()).isEqualTo(DEFAULT_NAME);
        assertThat(user.getEmail()).isEqualTo(DEFAULT_EMAIL);
        assertThat(user.getActivated()).isEqualTo(true);
        assertThat(user.getLangKey()).isEqualTo(DEFAULT_LANGKEY);
        assertThat(user.getCreatedBy()).isNull();
        assertThat(user.getCreatedDate()).isNotNull();
        assertThat(user.getLastModifiedBy()).isNull();
        assertThat(user.getLastModifiedDate()).isNotNull();
        assertThat(user.getRoles()).extracting("name").containsExactly(RolesConstants.USER);
    }

    @Test
    public void testUserToUserDTO() {
        user.setId(DEFAULT_ID);
        user.setCreatedBy(DEFAULT_ID_NUMBER);
        user.setCreatedDate(LocalDateTime.now());
        user.setLastModifiedBy(DEFAULT_ID_NUMBER);
        user.setLastModifiedDate(LocalDateTime.now());
        Set<Role> roles = new HashSet<>();
        Role role = new Role();
        role.setName(RolesConstants.USER);
        roles.add(role);
        user.setRoles(roles);

        final UserDTO userDTO = userMapper.userToUserDTO(user);

        assertThat(userDTO.getId()).isEqualTo(DEFAULT_ID);
        assertThat(userDTO.getIdNumber()).isEqualTo(DEFAULT_ID_NUMBER);
        assertThat(userDTO.getName()).isEqualTo(DEFAULT_NAME);
        assertThat(userDTO.getEmail()).isEqualTo(DEFAULT_EMAIL);
        assertThat(userDTO.isActivated()).isEqualTo(true);
        assertThat(userDTO.getLangKey()).isEqualTo(DEFAULT_LANGKEY);
        assertThat(userDTO.getCreatedBy()).isEqualTo(DEFAULT_ID_NUMBER);
        assertThat(userDTO.getCreatedDate()).isEqualTo(user.getCreatedDate());
        assertThat(userDTO.getLastModifiedBy()).isEqualTo(DEFAULT_ID_NUMBER);
        assertThat(userDTO.getLastModifiedDate()).isEqualTo(user.getLastModifiedDate());
        assertThat(userDTO.getRoles()).containsExactly(RolesConstants.USER);
        assertThat(userDTO.toString()).isNotNull();
    }

    private void assertPersistedUsers(final Consumer<List<User>> userAssertion) {
        userAssertion.accept(userRepository.findAll());
    }
}
