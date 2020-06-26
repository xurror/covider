package cm.ubuea.covider.profile_module.services;

import cm.ubuea.covider.profile_module.models.UserProfile;
import cm.ubuea.covider.profile_module.models.Role;
import cm.ubuea.covider.profile_module.models.User;
import cm.ubuea.covider.profile_module.repositories.UserRepos;
import cm.ubuea.covider.profile_module.util.PwEncoder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class UserProfileService implements UserDetailsService {
    private static final Logger lg = LoggerFactory.getLogger(UserProfileService.class);
    private PwEncoder pe;
    private UserRepos userRepository;

    public UserProfileService(PwEncoder pw, UserRepos userRepository) {
        this.userRepository = userRepository;
        this.pe = pw;
    }

    @Override
    public org.springframework.security.core.userdetails.UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        userRepository.deleteAll();

        Role r = new Role();
        r.setDescription("Some description");
        r.setValue("ROLE_USER");
        Set<Role> roles = new HashSet<>();
        roles.add(r);

        User u = new User();
        u.setCardnumber("12345");
        u.setId(pe.passwordEncoder().encode("12ebb"));
        u.setRole(roles);

        Role r2 = new Role();
        r2.setDescription("Agent description");
        r2.setValue("ROLE_AGENT");
        Set<Role> roles2 = new HashSet<>();
        roles2.add(r2);

        User u2 = new User();
        u2.setCardnumber("54321");
        u2.setId(pe.passwordEncoder().encode("bbe21"));
        u2.setRole(roles2);

        userRepository.saveAll(Arrays.asList(u, u2));

        //USER NAMES ARE THEIR IDENTITY CARD NUMBERS
        Optional<User> user = userRepository.findByCardnumber(username);

        if(!user.isPresent()) {
            throw new UsernameNotFoundException(String.format("USER_NOT_FOUND %s",username));
        }
        return new UserProfile(user.get());
    }
}
