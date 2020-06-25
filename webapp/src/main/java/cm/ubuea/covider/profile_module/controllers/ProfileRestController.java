package cm.ubuea.covider.profile_module.controllers;

import cm.ubuea.covider.profile_module.dto.*;
import cm.ubuea.covider.profile_module.services.UserProfileService;
import cm.ubuea.covider.profile_module.services.UserServiceImpl;
import cm.ubuea.covider.profile_module.util.TokenUtility;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/api")
public class ProfileRestController {
    private static final Logger lg = LoggerFactory.getLogger(ProfileRestController.class);

    @Value("${jwt.http.request.header}")
    private String tokenHeader;

    private AuthenticationManager authManager;
    private TokenUtility tokenUtil;
    private UserProfileService userProfileService;
    private UserServiceImpl userService;
    public ProfileRestController(AuthenticationManager authManager, TokenUtility tokenUtil,
                                 UserProfileService userProfileService,
                                 UserServiceImpl userService) {
        this.authManager = authManager;
        this.tokenUtil = tokenUtil;
        this.userProfileService = userProfileService;
        this.userService = userService;
    }

    @PostMapping(value = "${domain.endpoints.post.namesecret}")
    public ResponseEntity<?> signMeIn(@RequestBody AuthRequestBody content) {
        userService.authenticate(content.getUsername(), content.getPassword());

        final UserDetails userDetails = userProfileService.loadUserByUsername(content.getUsername());
        final String token = tokenUtil.generateToken(userDetails);

        return ResponseEntity.ok(new AuthResponseBody(token));
    }

//    Getting user details
    @GetMapping("${domain.endpoints.get.userdetails}")
    public ResponseEntity<UserInfoDTO> whoAmI(HttpServletRequest req) {
        String token = getTokenFromRequest(req);

        return ResponseEntity.ok().body(userService.loadMyInfo(token));
    }

    //update user details
    //update location
    @PatchMapping("${domain.endpoints.patch.location}")
    ResponseEntity<?> changeMyCurrentLocation(@RequestBody NewLocation currentLocation, HttpServletRequest request) {
        String token = getTokenFromRequest(request);

        userService.modifyCurrentLocation(token, currentLocation);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    //update identity card number
    @PatchMapping("${domain.endpoints.patch.idcardnumber}")
    ResponseEntity<?> modifyMyIDCardNumber(@RequestBody NewIDCard changeIDCard, HttpServletRequest request) {
        String token = getTokenFromRequest(request);

        userService.modifyIDCardNumber(token, changeIDCard);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    private String getTokenFromRequest(HttpServletRequest request) {
        return request.getHeader(tokenHeader).substring(7);
    }
}
