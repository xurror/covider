package cm.ubuea.covider.profile_module.services;

import cm.ubuea.covider.profile_module.dto.NewIDCard;
import cm.ubuea.covider.profile_module.dto.NewLocation;
import cm.ubuea.covider.profile_module.models.User;
import cm.ubuea.covider.profile_module.dto.UserInfoDTO;
import cm.ubuea.covider.profile_module.repositories.UserRepos;
import cm.ubuea.covider.profile_module.util.TokenUtility;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class UserServiceImpl {
    private static final Logger lg = LoggerFactory.getLogger(UserServiceImpl.class);

    private TokenUtility tokenUtil;
    private AuthenticationManager authManager;
    private UserRepos userRepository;

    public UserServiceImpl(TokenUtility tokenUtil, AuthenticationManager authManager,
                           UserRepos userRepository) {
        this.tokenUtil = tokenUtil;
        this.authManager = authManager;
        this.userRepository = userRepository;
    }

    public UserInfoDTO loadMyInfo(String token) {
        String uname = tokenUtil.getUsernameFromToken(token);

        UserInfoDTO userInfo = new UserInfoDTO();
        userInfo.setName(uname);

        return userInfo;
    }

    public void modifyIDCardNumber(String token, NewIDCard changeIDCard) {
        String uname = tokenUtil.getUsernameFromToken(token);
        User user = userRepository.findByCardnumber(uname).get();
        user.setCardnumber(changeIDCard.getNewCardNumber());
        userRepository.save(user);
    }

    public void modifyCurrentLocation(String token, NewLocation newLocation) {
        String uname = tokenUtil.getUsernameFromToken(token);
        User user = userRepository.findByCardnumber(uname).get();

        //search for the location
        //if found, set it as current location of user
        //else save as new location then set it as current user's location
        //resave the user

//        user.getLocation().setName(newLocation.getName());
        userRepository.save(user);
    }

    public void authenticate(String username, String password) {
        Objects.requireNonNull(username, "Username must not be empty");
        Objects.requireNonNull(password, "Password must not be empty");

        try {
            authManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
        } catch (Exception e) {
            lg.error("An unhandled exception occured");
            e.printStackTrace();
        }
    }
}
