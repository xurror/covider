package cm.ubuea.covider.registration.api;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import cm.ubuea.covider.registration.api.vm.KeyAndPasswordVM;
import cm.ubuea.covider.registration.api.vm.ManagedUserVM;
import cm.ubuea.covider.registration.domain.User;
import cm.ubuea.covider.registration.exceptions.EmailAlreadyUsedException;
import cm.ubuea.covider.registration.exceptions.InvalidPasswordException;
import cm.ubuea.covider.registration.repository.UserRepository;
import cm.ubuea.covider.registration.service.MailService;
import cm.ubuea.covider.registration.service.UserService;
import cm.ubuea.covider.registration.service.dto.PasswordChangeDTO;
import cm.ubuea.covider.registration.service.dto.UserDTO;
import cm.ubuea.covider.security.SecurityUtils;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.*;

/**
 * REST controller for managing the current user's account.
 */
@RestController
@RequestMapping("/api")
public class AccountResource {

    private static class AccountResourceException extends RuntimeException {
        private static final long serialVersionUID = 1L;

        private AccountResourceException(String message) {
            super(message);
        }
    }

    private final Logger log = LoggerFactory.getLogger(AccountResource.class);

    private final UserRepository userRepository;

    private final UserService userService;

    private final MailService mailService;

    public AccountResource(UserRepository userRepository, UserService userService, MailService mailService) {

        this.userRepository = userRepository;
        this.userService = userService;
        this.mailService = mailService;
    }

    /**
     * {@code POST  /register} : register the user.
     *
     * @param managedUserVM the managed user View Model.
     * @throws InvalidPasswordException {@code 400 (Bad Request)} if the password is incorrect.
     * @throws EmailAlreadyUsedException {@code 400 (Bad Request)} if the email is already used.
     * @return
     */
    @PostMapping("/register")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<User> registerAccount(@Valid @RequestBody ManagedUserVM managedUserVM) throws URISyntaxException {
        if (!checkPasswordLength(managedUserVM.getPassword())) {
            throw new InvalidPasswordException();
        }
        User user = userService.registerUser(managedUserVM, managedUserVM.getPassword());
        User activatedUser = userService.activateRegistration(user.activationKey).orElseThrow(() ->
            new AccountResourceException("User activation key not found"));
        // try {
        //     mailService.sendActivationEmail(user);
        // } catch (NullPointerException e) {
        //     throw new NullPointerException(e.getMessage());
        // }

        final String credentials = activatedUser.getIdNumber() + ":" + activatedUser.getPassword();
        final String encodedCredentials = Base64.getEncoder().encodeToString(credentials.getBytes());
        return ResponseEntity.created(new URI("/api/authenticate"))
            .header("Authorization", "Basic " + encodedCredentials)
            .body(activatedUser);
    }

    // /**
    //  * {@code GET  /activate} : activate the registered user.
    //  *
    //  * @param key the activation key.
    //  * @throws RuntimeException {@code 500 (Internal Server Error)} if the user couldn't be activated.
    //  */
    // @GetMapping("/activate")
    // public void activateAccount(@RequestParam(value = "key") String key) {
    //     Optional<User> user = userService.activateRegistration(key);
    //     if (!user.isPresent()) {
    //         throw new AccountResourceException("No user was found for this activation key");
    //     }
    // }

    /**
     * {@code GET  /authenticate} : check if the user is authenticated, and return its idNumber.
     *
     * @param request the HTTP request.
     * @return the idNumber if the user is authenticated.
     */
    @GetMapping("/authenticate")
    public String isAuthenticated(HttpServletRequest request) {
        log.debug("REST request to check if the current user is authenticated");
        return request.getRemoteUser();
    }

    /**
     * {@code GET  /account} : get the current user.
     *
     * @return the current user.
     * @throws RuntimeException {@code 500 (Internal Server Error)} if the user couldn't be returned.
     */
    @GetMapping("/account")
    public UserDTO getAccount() {
        return userService.getUserWithRoles()
            .map(UserDTO::new)
            .orElseThrow(() -> new AccountResourceException("User could not be found"));
    }

    /**
     * {@code POST  /account} : update the current user information.
     *
     * @param userDTO the current user information.
     * @throws EmailAlreadyUsedException {@code 400 (Bad Request)} if the email is already used.
     * @throws RuntimeException {@code 500 (Internal Server Error)} if the user idNumber wasn't found.
     * @return
     */
    @PostMapping("/account")
    public ResponseEntity<User> saveAccount(@Valid @RequestBody UserDTO userDTO) throws URISyntaxException {
        String userIdNumber = SecurityUtils.getCurrentUserIdNumber().orElseThrow(() -> new AccountResourceException("Current user idNumber not found"));
        Optional<User> existingUser = userRepository.findOneByEmailIgnoreCase(userDTO.getEmail());
        if (existingUser.isPresent() && (!existingUser.get().getIdNumber().equalsIgnoreCase(userIdNumber))) {
            throw new EmailAlreadyUsedException();
        }
        User user = userRepository.findOneByIdNumber(userIdNumber).orElseThrow(() ->
            new AccountResourceException("Current user idNumber not found"));
        userService.updateUser(userDTO.getName(), userDTO.getEmail(), userDTO.getLangKey());

        final String credentials = user.getIdNumber() + ":" + user.getPassword();
        final String encodedCredentials = Base64.getEncoder().encodeToString(credentials.getBytes());
        return ResponseEntity.created(new URI("/api/authenticate"))
            .header("Authorization", "Basic " + encodedCredentials)
            .body(user);
    }

    /**
     * {@code POST  /account/change-password} : changes the current user's password.
     *
     * @param passwordChangeDto current and new password.
     * @throws InvalidPasswordException {@code 400 (Bad Request)} if the new password is incorrect.
     * @return
     */
    @PostMapping(path = "/account/change-password")
    public ResponseEntity<Object> changePassword(@RequestBody PasswordChangeDTO passwordChangeDto) {
        if (!checkPasswordLength(passwordChangeDto.getNewPassword())) {
            throw new InvalidPasswordException();
        }
        userService.changePassword(passwordChangeDto.getCurrentPassword(), passwordChangeDto.getNewPassword());
        return ResponseEntity.accepted().build();
    }

    /**
     * {@code POST   /account/reset-password/init} : Send an email to reset the password of the user.
     *
     * @param mail the mail of the user.
     * @return
     */
    @PostMapping(path = "/account/reset-password/init")
    public ResponseEntity<Object> requestPasswordReset(@RequestBody String mail) {
        Optional<User> user = userService.requestPasswordReset(mail);
        if (user.isPresent()) {
            mailService.sendPasswordResetMail(user.get());
            return ResponseEntity.accepted().build();
        } else {
            // Pretend the request has been successful to prevent checking which emails really exist
            // but log that an invalid attempt has been made
            log.warn("Password reset requested for non existing mail");
            return ResponseEntity.notFound().build();
        }
    }

    /**
     * {@code POST   /account/reset-password/finish} : Finish to reset the password of the user.
     *
     * @param keyAndPassword the generated key and the new password.
     * @throws InvalidPasswordException {@code 400 (Bad Request)} if the password is incorrect.
     * @throws RuntimeException {@code 500 (Internal Server Error)} if the password could not be reset.
     * @return
     */
    @PostMapping(path = "/account/reset-password/finish")
    public ResponseEntity<User> finishPasswordReset(@RequestBody KeyAndPasswordVM keyAndPassword) throws URISyntaxException {
        if (!checkPasswordLength(keyAndPassword.getNewPassword())) {
            throw new InvalidPasswordException();
        }
        User user = userService.completePasswordReset(keyAndPassword.getNewPassword(), keyAndPassword.getKey()).orElseThrow(() ->
                new AccountResourceException("No user was found for this reset key"));

        final String credentials = user.getIdNumber() + ":" + user.getPassword();
        final String encodedCredentials = Base64.getEncoder().encodeToString(credentials.getBytes());
        return ResponseEntity.created(new URI("/api/authenticate"))
            .header("Authorization", "Basic " + encodedCredentials)
            .body(user);
    }

    private static boolean checkPasswordLength(String password) {
        return !StringUtils.isEmpty(password) &&
            password.length() >= ManagedUserVM.PASSWORD_MIN_LENGTH &&
            password.length() <= ManagedUserVM.PASSWORD_MAX_LENGTH;
    }
}
