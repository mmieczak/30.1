package pl.mmieczak.cookbook.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.mmieczak.cookbook.domain.User;

public interface UserRepository extends JpaRepository<User, Long> {

    User findByUsername(String username);

    //  User findByUsernameContainsIgnoreCase(String firstnam§e);
}
