package pl.mmieczak.cookbook.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.mmieczak.cookbook.domain.UserRole;

public interface UserRoleRepository extends JpaRepository<UserRole, Long> {
}
