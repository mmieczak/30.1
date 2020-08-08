package pl.mmieczak.cookbook.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.mmieczak.cookbook.domain.Author;

public interface AuthorRepository extends JpaRepository<Author, Long> {

    Author findByFirstnameContainsIgnoreCase(String firstname);

    Author findByUsernameContainsIgnoreCase(String name);

}
