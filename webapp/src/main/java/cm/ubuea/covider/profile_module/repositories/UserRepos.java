package cm.ubuea.covider.profile_module.repositories;

import cm.ubuea.covider.profile_module.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepos extends JpaRepository<User, Long> {
  Optional<User> findByCardnumber(String card);
}
